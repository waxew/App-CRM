package com.wcrm.core.domain.customer

import com.wcrm.core.model.customer.Customer

/**
 * UseCase اعتبارسنجی مشتری.
 *
 * وظیفه این کلاس بررسی قوانین پایه اطلاعات مشتری
 * قبل از ارسال داده به Repository است.
 *
 * این منطق در Domain نگهداری می‌شود تا در تمام رابط‌های کاربری
 * و Business Profileها قابل استفاده باشد.
 */
class ValidateCustomerUseCase {

    /**
     * بررسی صحت اطلاعات مشتری.
     *
     * @param customer مدل مشتری برای بررسی
     * @return نتیجه اعتبارسنجی شامل وضعیت موفق یا پیام خطا
     */
    operator fun invoke(customer: Customer): CustomerValidationResult {
        return if (customer.name.isBlank()) {
            CustomerValidationResult.Invalid("Customer name is required")
        } else {
            CustomerValidationResult.Valid
        }
    }
}
