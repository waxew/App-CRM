package com.wcrm.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wcrm.core.database.dao.CustomerDao
import com.wcrm.core.database.dao.InventoryDao
import com.wcrm.core.database.dao.InvoiceDao
import com.wcrm.core.database.dao.ProductDao
import com.wcrm.core.database.dao.RepairDao
import com.wcrm.core.database.dao.SerialDao
import com.wcrm.core.database.dao.WarrantyDao
import com.wcrm.core.database.entity.CustomerEntity
import com.wcrm.core.database.entity.InventoryEntity
import com.wcrm.core.database.entity.InvoiceEntity
import com.wcrm.core.database.entity.ProductEntity
import com.wcrm.core.database.entity.RepairEntity
import com.wcrm.core.database.entity.SerialEntity
import com.wcrm.core.database.entity.WarrantyEntity

/**
 * پایگاه داده اصلی برنامه W-CRM.
 *
 * این کلاس نقطه اتصال لایه Domain و Data است و تمام Entityهای پایگاه داده
 * و DAOهای مربوط به ماژول‌های اصلی CRM را مدیریت می‌کند.
 *
 * قوانین معماری:
 * - Featureها نباید مستقیماً به این کلاس وابسته باشند.
 * - دسترسی به داده‌ها فقط از طریق Repository انجام می‌شود.
 * - افزایش نسخه Database باید همراه با Migration کنترل شود.
 */
@Database(
    entities = [
        CustomerEntity::class,
        ProductEntity::class,
        InvoiceEntity::class,
        InventoryEntity::class,
        WarrantyEntity::class,
        RepairEntity::class,
        SerialEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    /** دسترسی به اطلاعات مشتریان. */
    abstract fun customerDao(): CustomerDao

    /** دسترسی به اطلاعات محصولات. */
    abstract fun productDao(): ProductDao

    /** دسترسی به فاکتورها. */
    abstract fun invoiceDao(): InvoiceDao

    /** دسترسی به گردش موجودی کالا. */
    abstract fun inventoryDao(): InventoryDao

    /** دسترسی به اطلاعات ضمانت کالا. */
    abstract fun warrantyDao(): WarrantyDao

    /** دسترسی به تیکت‌های تعمیرات. */
    abstract fun repairDao(): RepairDao

    /** دسترسی به شماره سریال و IMEI کالاها. */
    abstract fun serialDao(): SerialDao
}
