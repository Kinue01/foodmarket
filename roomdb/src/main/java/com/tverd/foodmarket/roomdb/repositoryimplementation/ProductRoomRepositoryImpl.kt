package com.tverd.foodmarket.roomdb.repositoryimplementation

import com.tverd.foodmarket.data.repository.product.ProductRoomRepository
import com.tverd.foodmarket.domain.model.Product
import com.tverd.foodmarket.roomdb.dao.ProductDao
import com.tverd.foodmarket.roomdb.dao.ServiceDao
import com.tverd.foodmarket.roomdb.mappers.ProductEntityMapper
import com.tverd.foodmarket.roomdb.mappers.ServiceEntityMapper

class ProductRoomRepositoryImpl(
    private val productDao: ProductDao,
    private val serviceDao: ServiceDao,
    private val productEntityMapper: ProductEntityMapper,
    private val serviceEntityMapper: ServiceEntityMapper
) : ProductRoomRepository {
    override suspend fun getProducts(): List<Product> {
        return productDao.getProducts().map {
            productEntityMapper.mapFromEntity(it)
        }
    }

    override suspend fun saveProducts(products: List<Product>) {
        productDao.saveProducts(products.map {
            productEntityMapper.mapToEntity(it)
        })
        products.map {
            serviceDao.saveService(serviceEntityMapper.mapToEntity(it.prod_service))
        }
    }

    override suspend fun deleteProducts() {
        productDao.deleteProducts()
        serviceDao.deleteServices()
    }

    override suspend fun isCached(): Boolean {
        return productDao.getProducts().isNotEmpty()
    }

    override suspend fun getProductById(id: Int): Product {
        val res = productDao.getProductById(id)
        return if (res != null)
            productEntityMapper.mapFromEntity(res)
        else
            Product()
    }
}