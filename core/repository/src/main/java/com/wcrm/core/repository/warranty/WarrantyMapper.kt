package com.wcrm.core.repository.warranty

import com.wcrm.core.database.entity.WarrantyEntity
import com.wcrm.core.model.Warranty
import com.wcrm.core.model.WarrantyStatus

/** تبدیل بین مدل پایگاه‌داده و مدل دامنه گارانتی. */
internal fun WarrantyEntity.toDomain(): Warranty = Warranty(
    id = id,
    productId = productId,
    serialNumber = serialNumber,
    startDate = startDate,
    endDate = endDate,
    status = runCatching { WarrantyStatus.valueOf(status) }.getOrDefault(WarrantyStatus.ACTIVE),
    notes = notes
)

/** تبدیل مدل دامنه گارانتی به موجودیت قابل ذخیره در Room. */
internal fun Warranty.toEntity(): WarrantyEntity = WarrantyEntity(
    id = id,
    productId = productId,
    serialNumber = serialNumber,
    startDate = startDate,
    endDate = endDate,
    status = status.name,
    notes = notes
)
