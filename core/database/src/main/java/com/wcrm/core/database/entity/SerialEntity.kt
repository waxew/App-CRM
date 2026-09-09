package com.wcrm.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "serials")
data class SerialEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val imei: String? = null,
    val serialNumber: String? = null,
    val productId: Long
)
