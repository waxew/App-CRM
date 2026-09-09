package com.wcrm.core.domain.usecase.customer

import com.wcrm.core.domain.repository.CustomerRepository
import com.wcrm.core.model.Customer
import kotlinx.coroutines.flow.Flow

/**
 * دریافت جریان تغییرات مشتریان.
 *
 * این UseCase داده‌های مشتری را به صورت Flow در اختیار لایه UI قرار می‌دهد
 * تا تغییرات دیتابیس به صورت واکنشی نمایش داده شوند.
 */
class GetCustomersUseCase(
    private val repository: CustomerRepository
) {
    /**
     * مشاهده لیست مشتریان.
     *
     * @return Flow شامل لیست به‌روز مشتریان
     */
    operator fun invoke(): Flow<List<Customer>> = repository.observeCustomers()
}
