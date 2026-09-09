package com.wcrm.core.domain.customer

sealed interface CustomerValidationResult {
    data object Valid : CustomerValidationResult
    data class Invalid(val message: String) : CustomerValidationResult
}
