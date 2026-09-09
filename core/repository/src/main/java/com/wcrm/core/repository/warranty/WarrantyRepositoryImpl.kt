package com.wcrm.core.repository.warranty

import com.wcrm.core.database.dao.WarrantyDao
import com.wcrm.core.domain.repository.WarrantyRepository
import com.wcrm.core.model.Warranty
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * پیاده‌سازی Repository گارانتی بر پایه Room.
 *
 * این کلاس تنها نقطه اتصال Domain به WarrantyDao است و تبدیل بین Entity و مدل Domain
 * را از طریق Mapperهای همین پکیج انجام می‌دهد.
 */
class WarrantyRepositoryImpl @Inject constructor(
    private val warrantyDao: WarrantyDao
) : WarrantyRepository {

    override fun observeWarranties(): Flow<List<Warranty>> =
        warrantyDao.observeWarranties().map { entities -> entities.map { it.toDomain() } }

    override suspend fun getWarrantyById(id: Long): Warranty? =
        warrantyDao.getById(id)?.toDomain()

    override suspend fun getWarrantyBySerialNumber(serialNumber: String): Warranty? =
        warrantyDao.getBySerialNumber(serialNumber)?.toDomain()

    override suspend fun addWarranty(warranty: Warranty): Long =
        warrantyDao.insert(warranty.toEntity())

    override suspend fun updateWarranty(warranty: Warranty) {
        warrantyDao.update(warranty.toEntity())
    }

    override suspend fun deleteWarranty(id: Long) {
        warrantyDao.deleteById(id)
    }
}
