package com.wcrm.core.domain.usecase.customer

import com.wcrm.core.domain.repository.CustomerRepository
import com.wcrm.core.model.Customer

/**
 * مورد استفاده افزودن مشتری جدید به CRM.
 *
 * این کلاس در لایه Domain قرار دارد و مسئول هماهنگ کردن
 * درخواست افزودن مشتری بین لایه Presentation و Repository است.
 *
 * منطق ذخیره‌سازی در این بخش وجود ندارد و توسط Repository پیاده‌سازی می‌شود.
 */
class AddCustomerUseCase(
    private val repository: CustomerRepository
) {
    /**
     * اجرای عملیات افزودن مشتری.
     *
     * @return شناسه مشتری ذخیره‌شده
     */
    suspend operator fun invoke(customer: Customer): Long = repository.addCustomer(customer)
}
