package com.wcrm.feature.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * داشبورد اصلی W-CRM.
 * TopBar در App Shell نگه‌داری می‌شود تا همه Featureها یک سربرگ مشترک داشته باشند.
 */
@Composable
fun DashboardScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "خلاصه امروز", style = MaterialTheme.typography.titleLarge)

            MetricRow(
                firstTitle = "فروش امروز",
                firstValue = "۰ تومان",
                secondTitle = "مشتریان",
                secondValue = "۰"
            )
            MetricRow(
                firstTitle = "محصولات",
                firstValue = "۰",
                secondTitle = "موجودی کم",
                secondValue = "۰"
            )

            Spacer(modifier = Modifier.height(4.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "وضعیت سیستم", style = MaterialTheme.typography.titleMedium)
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

/** ردیف دو ستونه متریک؛ وزن ستون‌ها در Scope صحیح Row اعمال می‌شود. */
@Composable
private fun MetricRow(
    firstTitle: String,
    firstValue: String,
    secondTitle: String,
    secondValue: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        DashboardMetricCard(firstTitle, firstValue, Modifier.weight(1f))
        DashboardMetricCard(secondTitle, secondValue, Modifier.weight(1f))
    }
}

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
            Text(text = title, style = MaterialTheme.typography.bodyMedium)
            Text(text = value, fontSize = 20.sp, style = MaterialTheme.typography.titleMedium)
        }
    }
}
