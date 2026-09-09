package com.wcrm.core.database.di

import androidx.room.RoomDatabase

/**
 * قرارداد عمومی برای معرفی کلاس پایگاه‌داده Room.
 *
 * این abstraction به بخش‌هایی که فقط به نوع پایگاه‌داده نیاز دارند اجازه می‌دهد بدون
 * وابستگی مستقیم به پیاده‌سازی مشخص [RoomDatabase] کار کنند. در صورت اضافه شدن چند
 * پایگاه‌داده یا تغییر پیاده‌سازی در آینده، این قرارداد نقطه جداسازی مناسبی ایجاد می‌کند.
 */
interface DatabaseProvider {
    /** کلاس concrete پایگاه‌داده Room مورد استفاده برنامه را برمی‌گرداند. */
    fun databaseClass(): Class<out RoomDatabase>
}
