package com.wcrm.core.domain.customer

sealed interface CustomerOperationResult {
    data object Success : CustomerOperationResult
    data class Error(val message: String) : CustomerOperationResult
}
