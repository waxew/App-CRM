package com.wcrm.core.repository.product

import com.wcrm.core.database.entity.ProductEntity
import com.wcrm.core.model.Product

/**
 * تبدیل‌کننده مدل Room و مدل Domain برای محصول.
 */
internal object ProductMapper {
    fun ProductEntity.toDomain(): Product = Product(
        id = id,
        name = name,
        category = category,
        brand = brand,
        price = price,
        cost = cost,
        stock = stock,
        createdAt = createdAt
    )

    fun Product.toEntity(): ProductEntity = ProductEntity(
        id = id,
        name = name,
        category = category,
        brand = brand,
        price = price,
        cost = cost,
        stock = stock,
        createdAt = createdAt
    )
}
