package com.wcrm.core.repository.repair

import com.wcrm.core.database.entity.RepairEntity
import com.wcrm.core.model.RepairStatus
import com.wcrm.core.model.RepairTicket

/**
 * تبدیل بین مدل Room و مدل Domain تعمیرات.
 */
internal object RepairMapper {

    /** Entity پایگاه‌داده را به مدل دامنه تبدیل می‌کند. */
    fun toDomain(entity: RepairEntity): RepairTicket = RepairTicket(
        id = entity.id,
        customerId = entity.customerId,
        device = entity.device,
        problem = entity.problem,
        status = RepairStatus.valueOf(entity.status),
        cost = entity.cost,
        notes = entity.notes,
        createdAt = entity.createdAt,
        updatedAt = entity.updatedAt
    )

    /** مدل دامنه را برای ذخیره در Room آماده می‌کند. */
    fun toEntity(ticket: RepairTicket): RepairEntity = RepairEntity(
        id = ticket.id,
        customerId = ticket.customerId,
        device = ticket.device,
        problem = ticket.problem,
        status = ticket.status.name,
        cost = ticket.cost,
        notes = ticket.notes,
        createdAt = ticket.createdAt,
        updatedAt = ticket.updatedAt
    )
}
