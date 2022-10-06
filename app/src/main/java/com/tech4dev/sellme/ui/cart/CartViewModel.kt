package com.tech4dev.sellme.ui.cart
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tech4dev.sellme.data.models.Product
import com.tech4dev.sellme.data.repository.CartRepository

class CartViewModel : ViewModel() {

    fun getProducts(): List<Product>{
        return CartRepository.getSelectedProducts().keys.toList()
    }

    fun getQuantity(product: Product): Int{
        return CartRepository.getQuantity(product)
    }

    fun increaseQuantity(product: Product){
        CartRepository.increaseQuantity(product)
    }

    fun decreaseQuantity(product: Product){
        CartRepository.reduceQuantity(product)
    }

    fun removeFromCart(product: Product){
        CartRepository.removeFromCart(product)
    }
    fun getCartLiveData():MutableLiveData<MutableMap<Product,Int>>{
        return CartRepository.getCartLiveData()
    }
    fun getPrice():Double{
        return CartRepository.getPrice()
    }

}