package com.wcrm.core.repository.inventory

import com.wcrm.core.database.entity.InventoryEntity
import com.wcrm.core.model.InventoryMovement
import com.wcrm.core.model.InventoryMovementType

/**
 * تبدیل مدل پایگاه‌داده گردش موجودی به مدل Domain.
 */
internal fun InventoryEntity.toDomain(): InventoryMovement = InventoryMovement(
    id = id,
    productId = productId,
    type = InventoryMovementType.valueOf(movementType),
    quantity = quantity,
    note = note,
    createdAt = createdAt
)

/**
 * تبدیل مدل Domain گردش موجودی به Entity قابل ذخیره در Room.
 */
internal fun InventoryMovement.toEntity(): InventoryEntity = InventoryEntity(
    id = id,
    productId = productId,
    quantity = quantity,
    movementType = type.name,
    note = note,
    createdAt = createdAt
)
