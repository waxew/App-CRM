package com.wcrm.feature.customer

sealed interface CustomerEvent {
    data class SearchChanged(val query: String) : CustomerEvent
    data class DeleteRequested(val customerId: Long) : CustomerEvent
    data object Refresh : CustomerEvent
}
