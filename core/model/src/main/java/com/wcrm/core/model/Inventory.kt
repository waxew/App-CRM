package com.wcrm.core.model

enum class InventoryMovementType {
    STOCK_IN,
    STOCK_OUT,
    ADJUSTMENT,
    SALE,
    RETURN
}

data class InventoryMovement(
    val id: Long = 0,
    val productId: Long,
    val type: InventoryMovementType,
    val quantity: Int,
    val note: String? = null,
    val createdAt: Long = System.currentTimeMillis()
)

data class InventorySnapshot(
    val productId: Long,
    val stock: Int,
    val lowStockThreshold: Int = 0
) {
    val isLowStock: Boolean
        get() = stock <= lowStockThreshold
}
