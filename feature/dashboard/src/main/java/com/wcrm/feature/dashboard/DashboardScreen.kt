package com.wcrm.feature.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.weight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalLayoutDirection

/**
 * داشبورد اصلی W-CRM.
 *
 * این صفحه فعلاً یک خروجی نمایشی واقعی و قابل Build ارائه می‌کند تا معماری UI
 * از حالت placeholder خارج شود. مقادیر نمایش‌داده‌شده نمونه هستند و در مرحله
 * اتصال ViewModel به Repositoryها با داده‌های واقعی Room جایگزین می‌شوند.
 */
@Composable
fun DashboardScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Column {
                            Text(text = "W-CRM")
                            Text(
                                text = "داشبورد مدیریت کسب‌وکار",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "خلاصه امروز",
                    style = MaterialTheme.typography.titleLarge
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    DashboardMetricCard(
                        title = "فروش امروز",
                        value = "۰ تومان",
                        modifier = Modifier.weight(1f)
                    )
                    DashboardMetricCard(
                        title = "مشتریان",
                        value = "۰",
                        modifier = Modifier.weight(1f)
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    DashboardMetricCard(
                        title = "محصولات",
                        value = "۰",
                        modifier = Modifier.weight(1f)
                    )
                    DashboardMetricCard(
                        title = "موجودی کم",
                        value = "۰",
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "وضعیت سیستم",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "هسته CRM، Room، Repository و Business Profile فعال هستند.",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "مرحله بعد: اتصال داده‌های واقعی Dashboard به ViewModel و UseCaseها.",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}

/** کارت متریک قابل استفاده مجدد برای شاخص‌های اصلی داشبورد. */
@Composable
private fun DashboardMetricCard(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = value,
                fontSize = 20.sp,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
