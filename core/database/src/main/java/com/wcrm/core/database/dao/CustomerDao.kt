package com.wcrm.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import com.wcrm.core.database.entity.CustomerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomerDao {

    @Query("SELECT * FROM customers ORDER BY createdAt DESC")
    fun getCustomers(): Flow<List<CustomerEntity>>

    @Insert
    suspend fun insert(customer: CustomerEntity)
}
