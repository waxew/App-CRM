package com.wcrm.core.repository.serial

import com.wcrm.core.database.dao.SerialDao
import com.wcrm.core.domain.repository.SerialRepository
import com.wcrm.core.model.SerialEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * پیاده‌سازی Repository سریال و IMEI با استفاده از Room.
 */
class SerialRepositoryImpl @Inject constructor(
    private val dao: SerialDao
) : SerialRepository {

    override fun observeSerials(): Flow<List<SerialEntity>> =
        dao.observeSerials().map { entities -> entities.map(SerialMapper::toDomain) }

    override suspend fun getById(id: Long): SerialEntity? =
        dao.getById(id)?.let(SerialMapper::toDomain)

    override suspend fun addSerial(serial: SerialEntity): Long =
        dao.insert(SerialMapper.toEntity(serial))

    override suspend fun deleteSerial(id: Long) {
        dao.getById(id)?.let { dao.delete(it) }
    }
}
