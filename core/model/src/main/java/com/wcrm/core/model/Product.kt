package com.wcrm.core.model

data class Product(
    val id: Long = 0,
    val name: String,
    val category: String? = null,
    val brand: String? = null,
    val price: Long = 0,
    val cost: Long = 0,
    val stock: Int = 0,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
