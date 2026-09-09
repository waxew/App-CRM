package com.wcrm.core.repository.di

import com.wcrm.core.domain.repository.CustomerRepository
import com.wcrm.core.domain.repository.InventoryRepository
import com.wcrm.core.domain.repository.InvoiceRepository
import com.wcrm.core.domain.repository.ProductRepository
import com.wcrm.core.domain.repository.WarrantyRepository
import com.wcrm.core.repository.customer.CustomerRepositoryImpl
import com.wcrm.core.repository.inventory.InventoryRepositoryImpl
import com.wcrm.core.repository.invoice.InvoiceRepositoryImpl
import com.wcrm.core.repository.product.ProductRepositoryImpl
import com.wcrm.core.repository.warranty.WarrantyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * اتصال قراردادهای Repository لایه Domain به پیاده‌سازی‌های واقعی لایه Data.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    /** پیاده‌سازی Repository مشتری را در اختیار Domain قرار می‌دهد. */
    @Binds
    abstract fun bindCustomerRepository(
        implementation: CustomerRepositoryImpl
    ): CustomerRepository

    /** پیاده‌سازی Repository محصول را در اختیار Domain قرار می‌دهد. */
    @Binds
    abstract fun bindProductRepository(
        implementation: ProductRepositoryImpl
    ): ProductRepository

    /** پیاده‌سازی Repository فاکتور را در اختیار Domain قرار می‌دهد. */
    @Binds
    abstract fun bindInvoiceRepository(
        implementation: InvoiceRepositoryImpl
    ): InvoiceRepository

    /** پیاده‌سازی Repository موجودی را در اختیار Domain قرار می‌دهد. */
    @Binds
    abstract fun bindInventoryRepository(
        implementation: InventoryRepositoryImpl
    ): InventoryRepository

    /** پیاده‌سازی Repository گارانتی را در اختیار Domain قرار می‌دهد. */
    @Binds
    abstract fun bindWarrantyRepository(
        implementation: WarrantyRepositoryImpl
    ): WarrantyRepository
}
