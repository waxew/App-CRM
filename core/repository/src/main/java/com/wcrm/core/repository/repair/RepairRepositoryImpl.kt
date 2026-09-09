package com.wcrm.core.repository.repair

import com.wcrm.core.database.dao.RepairDao
import com.wcrm.core.domain.repository.RepairRepository
import com.wcrm.core.model.RepairTicket
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * پیاده‌سازی Repository تعمیرات با استفاده از Room.
 */
class RepairRepositoryImpl @Inject constructor(
    private val dao: RepairDao
) : RepairRepository {

    override fun observeRepairs(): Flow<List<RepairTicket>> =
        dao.observeRepairs().map { entities -> entities.map(RepairMapper::toDomain) }

    override suspend fun getRepairById(id: Long): RepairTicket? =
        dao.getById(id)?.let(RepairMapper::toDomain)

    override fun observeCustomerRepairs(customerId: Long): Flow<List<RepairTicket>> =
        dao.observeByCustomer(customerId).map { entities -> entities.map(RepairMapper::toDomain) }

    override suspend fun createRepair(ticket: RepairTicket): Long =
        dao.insert(RepairMapper.toEntity(ticket))

    override suspend fun updateRepair(ticket: RepairTicket) {
        dao.update(RepairMapper.toEntity(ticket))
    }

    override suspend fun deleteRepair(id: Long) {
        dao.getById(id)?.let { dao.delete(it) }
    }
}
