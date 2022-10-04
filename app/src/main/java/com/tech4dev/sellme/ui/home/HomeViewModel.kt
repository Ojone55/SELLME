package com.tech4dev.sellme.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tech4dev.sellme.data.models.Product
import com.tech4dev.sellme.data.repository.ProductRepository

class HomeViewModel : ViewModel() {
    private val productRepository = ProductRepository()
    private val product: MutableLiveData<List<Product>> = productRepository.getProducts()

    fun getAllProduct(): MutableLiveData<List<Product>> {
        return product
    }

}