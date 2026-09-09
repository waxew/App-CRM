package com.wcrm.feature.dashboard

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DashboardCard(
    title: String,
    value: String
) {
    Card {
        Text(text = "$title: $value")
    }
}
