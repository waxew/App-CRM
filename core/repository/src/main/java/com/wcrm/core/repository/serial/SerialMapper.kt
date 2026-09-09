package com.wcrm.core.repository.serial

import com.wcrm.core.database.entity.SerialEntity as SerialDbEntity
import com.wcrm.core.model.SerialEntity as SerialDomainEntity

/**
 * تبدیل بین مدل سریال Domain و Entity پایگاه‌داده.
 *
 * استفاده از alias باعث می‌شود هم‌نام بودن مدل Domain و Entity دیتابیس
 * بدون ابهام و بدون تغییر نام عمومی مدل‌های موجود مدیریت شود.
 */
object SerialMapper {
    /** Entity دیتابیس را به مدل Domain تبدیل می‌کند. */
    fun toDomain(entity: SerialDbEntity): SerialDomainEntity = SerialDomainEntity(
        id = entity.id,
        productId = entity.productId,
        imei = entity.imei,
        serialNumber = entity.serialNumber,
        createdAt = entity.createdAt
    )

    /** مدل Domain را برای ذخیره در Room به Entity دیتابیس تبدیل می‌کند. */
    fun toEntity(model: SerialDomainEntity): SerialDbEntity = SerialDbEntity(
        id = model.id,
        productId = model.productId,
        imei = model.imei,
        serialNumber = model.serialNumber,
        createdAt = model.createdAt
    )
}
