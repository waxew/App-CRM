package com.wcrm.feature.customer

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CustomerListItem(
    name: String,
    phone: String
) {
    Text(text = "$name - $phone")
}
