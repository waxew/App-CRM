package com.wcrm.feature.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wcrm.business.profile.schema.BusinessProfile
import com.wcrm.business.profile.schema.DashboardWidgetDefinition

/**
 * داشبورد Profile-aware برنامه.
 * عنوان‌ها و کارت‌ها مستقیماً از BusinessProfile فعال خوانده می‌شوند و برای هر صنف متفاوت‌اند.
 */
@Composable
fun DashboardScreen(profile: BusinessProfile) {
    val widgets = profile.dashboardWidgets.sortedBy { it.order }
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(profile.name, style = MaterialTheme.typography.titleLarge)
            Text(
                text = "نمای تخصصی ${profile.terminology.saleLabel}",
                style = MaterialTheme.typography.bodyMedium
            )

            widgets.chunked(2).forEach { rowWidgets ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    rowWidgets.forEach { widget ->
                        DashboardMetricCard(widget, Modifier.weight(1f))
                    }
                    if (rowWidgets.size == 1) Spacer(Modifier.weight(1f))
                }
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("پروفایل فعال", style = MaterialTheme.typography.titleMedium)
                    Text("${profile.name} • ${profile.id}")
                    Text("Theme: ${profile.theme.themeKey}", style = MaterialTheme.typography.bodySmall)
                    Text(
                        "${profile.attributes.size} فیلد تخصصی و ${profile.enabledModules.size} ماژول فعال",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

/** کارت مشترک؛ عنوان و آیکون معنایی از Profile Schema می‌آید. */
@Composable
private fun DashboardMetricCard(widget: DashboardWidgetDefinition, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(widget.title, style = MaterialTheme.typography.bodyMedium)
            Text("۰", fontSize = 20.sp, style = MaterialTheme.typography.titleMedium)
            Text(widget.iconKey, style = MaterialTheme.typography.labelSmall)
        }
    }
}
