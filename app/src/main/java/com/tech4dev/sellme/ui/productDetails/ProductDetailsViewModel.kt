package com.tech4dev.sellme.ui.productDetails

import androidx.lifecycle.ViewModel

import com.tech4dev.sellme.data.models.Product
import com.tech4dev.sellme.data.repository.CartRepository



class ProductDetailsViewModel ():ViewModel(){
    fun saveToCart( product : Product) {
        CartRepository.addToCart(product)
    }
}
