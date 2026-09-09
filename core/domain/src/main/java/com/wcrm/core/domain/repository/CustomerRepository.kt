package com.wcrm.core.domain.repository

import com.wcrm.core.model.Customer
import kotlinx.coroutines.flow.Flow

/**
 * قرارداد دسترسی به داده‌های مشتری در لایه Domain.
 *
 * این اینترفیس مشخص می‌کند منطق کسب‌وکار چگونه با داده‌های مشتری کار کند،
 * بدون اینکه به Room، شبکه یا هر پیاده‌سازی ذخیره‌سازی خاصی وابسته باشد.
 * پیاده‌سازی واقعی این قرارداد باید در لایه Repository/Data قرار گیرد.
 */
interface CustomerRepository {
    /**
     * جریان واکنشی فهرست تمام مشتریان را برمی‌گرداند.
     * با هر تغییر در منبع داده، مقدار جدید از طریق Flow منتشر می‌شود.
     */
    fun observeCustomers(): Flow<List<Customer>>

    /** یک مشتری را با شناسه یکتا پیدا می‌کند؛ در صورت نبود مشتری مقدار null برمی‌گردد. */
    suspend fun getCustomerById(id: Long): Customer?

    /** مشتری جدید را ذخیره کرده و شناسه رکورد ایجادشده را برمی‌گرداند. */
    suspend fun addCustomer(customer: Customer): Long

    /** اطلاعات مشتری موجود را به‌روزرسانی می‌کند. */
    suspend fun updateCustomer(customer: Customer)

    /** مشتری مشخص‌شده را بر اساس شناسه حذف می‌کند. */
    suspend fun deleteCustomer(id: Long)

    /**
     * مشتریان مطابق عبارت جست‌وجو را به‌صورت Flow برمی‌گرداند.
     * نحوه تطبیق نام، شماره تماس یا سایر فیلدها بر عهده پیاده‌سازی Repository است.
     */
    fun searchCustomers(query: String): Flow<List<Customer>>
}
