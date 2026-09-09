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
    abstract fun customerDao(): CustomerDao
    abstract fun productDao(): ProductDao
    abstract fun invoiceDao(): InvoiceDao
    abstract fun inventoryDao(): InventoryDao
    abstract fun warrantyDao(): WarrantyDao
    abstract fun repairDao(): RepairDao
    abstract fun serialDao(): SerialDao
}
