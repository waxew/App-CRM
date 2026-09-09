package com.wcrm.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wcrm.core.database.entity.CustomerEntity

@Database(
    entities = [CustomerEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
}
