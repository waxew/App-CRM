package com.wcrm.core.database.di

import androidx.room.RoomDatabase

interface DatabaseProvider {
    fun databaseClass(): Class<out RoomDatabase>
}
