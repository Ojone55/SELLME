package com.tech4dev.sellme.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tech4dev.sellme.data.firebase.ProductDatasource
import com.tech4dev.sellme.data.models.Product

class ProductRepository {
    fun getProducts():MutableLiveData<List<Product>>{
        val productDatasource=ProductDatasource()
        return productDatasource.getProductInfo()
    }
}
