package com.tech4dev.sellme.ui.cart

import androidx.lifecycle.ViewModel

import com.tech4dev.sellme.data.models.Product
import com.tech4dev.sellme.data.repository.CartRepository

class CartViewModel : ViewModel() {
    // val selectedProducts

    fun getProducts(): List<Product> {
        return CartRepository.getSelectedProduct().keys.toList()
    }
    fun increaseQuantity(){

    }
    fun decreaseQuantity(){


    }
    fun deleteFromCart(){

    }
}
