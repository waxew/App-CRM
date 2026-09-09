package com.wcrm.feature.customer

sealed interface CustomerScreenState {
    data object Loading : CustomerScreenState
    data class Success(
        val customers: List<String>
    ) : CustomerScreenState
    data class Error(
        val message: String
    ) : CustomerScreenState
}
