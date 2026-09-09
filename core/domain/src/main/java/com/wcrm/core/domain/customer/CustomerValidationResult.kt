package com.wcrm.core.domain.customer

/**
 * نتیجه اعتبارسنجی اطلاعات مشتری.
 *
 * این مدل در لایه Domain قرار دارد تا منطق اعتبارسنجی
 * مستقل از رابط کاربری و دیتابیس نگهداری شود.
 */
sealed interface CustomerValidationResult {

    /**
     * زمانی که اطلاعات مشتری معتبر است.
     */
    data object Valid : CustomerValidationResult

    /**
     * زمانی که اطلاعات وارد شده دارای خطا است.
     *
     * @param message پیام توضیح خطای اعتبارسنجی
     */
    data class Invalid(val message: String) : CustomerValidationResult
}
