package com.wcrm.core.repository.customer

import com.wcrm.core.database.dao.CustomerDao
import com.wcrm.core.domain.repository.CustomerRepository
import com.wcrm.core.model.customer.Customer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * پیاده‌سازی Repository مشتری در لایه داده.
 *
 * این کلاس مرز بین قرارداد Domain و منبع داده محلی Room است. Feature و UseCaseها
 * فقط قرارداد [CustomerRepository] را می‌شناسند و جزئیات Room در این لایه باقی می‌ماند.
 */
class CustomerRepositoryImpl @Inject constructor(
    private val customerDao: CustomerDao
) : CustomerRepository {

    /** فهرست مشتریان را از Room دریافت و به مدل دامنه تبدیل می‌کند. */
    override fun observeCustomers(): Flow<List<Customer>> =
        customerDao.getCustomers().map { entities -> entities.map { it.toDomain() } }

    /** مشتری را با شناسه یکتا دریافت می‌کند. */
    override suspend fun getCustomerById(id: Long): Customer? =
        customerDao.getById(id)?.toDomain()

    /** مشتری جدید را در Room ذخیره می‌کند. */
    override suspend fun addCustomer(customer: Customer): Long =
        customerDao.insert(customer.toEntity())

    /** اطلاعات مشتری موجود را به‌روزرسانی می‌کند. */
    override suspend fun updateCustomer(customer: Customer) {
        customerDao.update(customer.toEntity())
    }

    /** مشتری را بر اساس شناسه حذف می‌کند. */
    override suspend fun deleteCustomer(id: Long) {
        customerDao.deleteById(id)
    }

    /** جست‌وجوی مشتری را به صورت واکنشی در اختیار Domain قرار می‌دهد. */
    override fun searchCustomers(query: String): Flow<List<Customer>> =
        customerDao.search(query).map { entities -> entities.map { it.toDomain() } }
}
