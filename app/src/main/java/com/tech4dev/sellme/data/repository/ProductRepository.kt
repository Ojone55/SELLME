package com.tech4dev.sellme.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tech4dev.sellme.data.models.Product
import com.tech4dev.sellme.data.firebase.ProductDataSource

class ProductRepository {
    fun getProducts(): MutableLiveData<List<Product>> {
        val  productDataSource =ProductDataSource()

        return productDataSource.getProductInfo()

    }



}