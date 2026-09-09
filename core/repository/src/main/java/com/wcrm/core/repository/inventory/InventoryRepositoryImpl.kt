package com.wcrm.core.repository.inventory

import com.wcrm.core.database.dao.InventoryDao
import com.wcrm.core.domain.repository.InventoryRepository
import com.wcrm.core.model.InventoryMovement
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * پیاده‌سازی Repository گردش موجودی بر پایه Room.
 *
 * این کلاس تنها مسئول اتصال قرارداد Domain به DAO و تبدیل مدل‌های داده است.
 * قوانین تجاری موجودی باید در UseCaseها باقی بمانند.
 */
class InventoryRepositoryImpl @Inject constructor(
    private val inventoryDao: InventoryDao
) : InventoryRepository {

    override fun observeInventoryMovements(): Flow<List<InventoryMovement>> =
        inventoryDao.observeMovements().map { entities ->
            entities.map { it.toDomain() }
        }

    override fun observeProductMovements(productId: Long): Flow<List<InventoryMovement>> =
        inventoryDao.observeProductMovements(productId).map { entities ->
            entities.map { it.toDomain() }
        }

    override suspend fun addInventoryMovement(movement: InventoryMovement): Long =
        inventoryDao.insertMovement(movement.toEntity())
}
