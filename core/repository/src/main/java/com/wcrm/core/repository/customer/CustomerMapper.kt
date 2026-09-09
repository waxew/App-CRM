package com.wcrm.core.repository.customer

import com.wcrm.core.database.entity.CustomerEntity
import com.wcrm.core.model.customer.Customer
import java.time.Instant

/**
 * Mapper بین مدل ذخیره‌سازی Room و مدل دامنه مشتری.
 *
 * زمان‌ها در پایگاه‌داده به صورت Long ذخیره می‌شوند و در Domain به صورت [Instant]
 * نگهداری می‌شوند. این فایل مرز تبدیل این دو نمایش را متمرکز نگه می‌دارد.
 */
internal fun CustomerEntity.toDomain(): Customer = Customer(
    id = id,
    name = name,
    phone = phone,
    mobile = mobile,
    address = address,
    email = email,
    createdAt = Instant.ofEpochMilli(createdAt),
    updatedAt = Instant.ofEpochMilli(updatedAt),
    notes = notes
)

/** مدل دامنه مشتری را به Entity قابل ذخیره در Room تبدیل می‌کند. */
internal fun Customer.toEntity(): CustomerEntity = CustomerEntity(
    id = id,
    name = name,
    phone = phone.orEmpty(),
    mobile = mobile.orEmpty(),
    address = address,
    email = email,
    notes = notes,
    createdAt = createdAt.toEpochMilli(),
    updatedAt = updatedAt.toEpochMilli()
)
