package com.wcrm.core.domain.customer

import com.wcrm.core.domain.repository.CustomerRepository
import com.wcrm.core.model.customer.Customer
import kotlinx.coroutines.flow.Flow

/**
 * کاربرد دریافت فهرست مشتریان از لایه Domain.
 *
 * این UseCase فقط به قرارداد CustomerRepository وابسته است و جزئیات
 * ذخیره‌سازی داده‌ها را نمی‌شناسد. خروجی به‌صورت Flow ارائه می‌شود تا
 * تغییرات فهرست مشتریان به‌صورت واکنشی به لایه‌های بالاتر منتقل شود.
 */
class GetCustomersUseCase(
    private val repository: CustomerRepository
) {
    /** جریان واکنشی فهرست مشتریان را برمی‌گرداند. */
    operator fun invoke(): Flow<List<Customer>> = repository.observeCustomers()
}
