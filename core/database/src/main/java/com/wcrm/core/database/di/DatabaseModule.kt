package com.wcrm.core.database.di

import android.content.Context
import androidx.room.Room
import com.wcrm.core.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * ماژول Hilt برای ساخت و تزریق نمونه یکتای پایگاه‌داده Room.
 *
 * این ماژول نقطه مرکزی ایجاد [AppDatabase] است تا تمام بخش‌های برنامه از یک نمونه مشترک
 * استفاده کنند. نام فایل پایگاه‌داده و تنظیمات ساخت Room در این لایه نگه داشته می‌شوند
 * و Featureها نباید مستقیماً Room را مقداردهی اولیه کنند.
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    /**
     * نمونه Singleton از [AppDatabase] را برای کل چرخه عمر برنامه فراهم می‌کند.
     *
     * با استفاده از [ApplicationContext] از نگه‌داری ناخواسته Activity/Screen Context
     * و ایجاد نشت حافظه جلوگیری می‌شود.
     */
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "wcrm_database"
    ).build()
}
