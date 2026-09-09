package com.wcrm.core.repository.product

import com.wcrm.core.database.entity.ProductEntity
import com.wcrm.core.model.Product

/**
 * تبدیل‌کننده مدل Room و مدل Domain برای محصول.
 *
 * توابع این Mapper به‌صورت تابع معمولی تعریف شده‌اند تا Repository بتواند آن‌ها را
 * به‌صورت مستقیم و بدون وابستگی به receiver ضمنی فراخوانی کند.
 */
internal object ProductMapper {

    /** موجودیت Room را به مدل دامنه محصول تبدیل می‌کند. */
    fun toDomain(entity: ProductEntity): Product = Product(
        id = entity.id,
        name = entity.name,
        category = entity.category,
        brand = entity.brand,
        price = entity.price,
        cost = entity.cost,
        stock = entity.stock,
        createdAt = entity.createdAt,
        updatedAt = entity.updatedAt
    )

    /** مدل دامنه محصول را برای ذخیره‌سازی به موجودیت Room تبدیل می‌کند. */
    fun toEntity(product: Product): ProductEntity = ProductEntity(
        id = product.id,
        name = product.name,
        category = product.category,
        brand = product.brand,
        price = product.price,
        cost = product.cost,
        stock = product.stock,
        createdAt = product.createdAt,
        updatedAt = product.updatedAt
    )
}
