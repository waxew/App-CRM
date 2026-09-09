package com.wcrm.feature.customer

sealed interface CustomerAction {
    data object LoadCustomers : CustomerAction
    data object SaveCustomer : CustomerAction
    data class Search(val query: String) : CustomerAction
}
