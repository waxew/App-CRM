package com.wcrm.core.database.di

import android.content.Context
import androidx.room.Room
import com.wcrm.core.database.AppDatabase
import com.wcrm.core.database.dao.CustomerDao
import com.wcrm.core.database.dao.InvoiceDao
import com.wcrm.core.database.dao.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * ماژول Hilt برای ساخت و تزریق نمونه یکتای پایگاه‌داده Room.
 *
 * این ماژول نقطه مرکزی ایجاد [AppDatabase] و ارائه DAOهای پایگاه‌داده است تا
 * Featureها و Repositoryها مستقیماً مسئول ساخت Room نباشند.
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    /** نمونه Singleton از [AppDatabase] را برای کل چرخه عمر برنامه فراهم می‌کند. */
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "wcrm_database"
    ).build()

    /** DAO مشتری را از نمونه مشترک پایگاه‌داده در اختیار Repository قرار می‌دهد. */
    @Provides
    fun provideCustomerDao(database: AppDatabase): CustomerDao = database.customerDao()

    /** DAO محصول را برای Repository محصول فراهم می‌کند. */
    @Provides
    fun provideProductDao(database: AppDatabase): ProductDao = database.productDao()

    /** DAO فاکتور را برای Repository فاکتور فراهم می‌کند. */
    @Provides
    fun provideInvoiceDao(database: AppDatabase): InvoiceDao = database.invoiceDao()
}
