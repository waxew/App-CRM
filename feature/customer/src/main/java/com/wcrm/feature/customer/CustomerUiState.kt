package com.wcrm.feature.customer

import com.wcrm.core.model.customer.Customer

data class CustomerUiState(
    val customers: List<Customer> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
