package com.wcrm.core.repository.product

import com.wcrm.core.database.dao.ProductDao
import com.wcrm.core.domain.repository.ProductRepository
import com.wcrm.core.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * پیاده‌سازی Repository محصول.
 *
 * این کلاس مرز بین Domain و Room است.
 */
class ProductRepositoryImpl @Inject constructor(
    private val dao: ProductDao
) : ProductRepository {

    override fun observeProducts(): Flow<List<Product>> =
        dao.getProducts().map { list -> list.map(ProductMapper::toDomain) }

    override suspend fun getProductById(id: Long): Product? =
        dao.getById(id)?.let(ProductMapper::toDomain)

    override suspend fun addProduct(product: Product): Long =
        dao.insert(ProductMapper.toEntity(product))

    override suspend fun updateProduct(product: Product) {
        dao.update(ProductMapper.toEntity(product))
    }

    override suspend fun deleteProduct(id: Long) {
        dao.getById(id)?.let { dao.delete(it) }
    }

    override fun searchProducts(query: String): Flow<List<Product>> =
        dao.search(query).map { list -> list.map(ProductMapper::toDomain) }
}
