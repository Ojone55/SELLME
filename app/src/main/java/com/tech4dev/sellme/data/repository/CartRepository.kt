package com.tech4dev.sellme.data.repository

import androidx.lifecycle.MutableLiveData
import com.tech4dev.sellme.data.models.Product

object CartRepository {
    private val selectedProducts = mutableMapOf<Product, Int>()
    private val cartLiveData=MutableLiveData<MutableMap<Product, Int>>(selectedProducts)

    fun addToCart(product: Product){
        selectedProducts.put(product, 1)
    }

    fun getQuantity(product: Product): Int{
        return selectedProducts[product]!!
    }

    fun removeFromCart(product: Product){
        selectedProducts.remove(product)
        notifyValueChange()
    }

    fun reduceQuantity(product: Product){
        //get quantity
        var quantity:Int = selectedProducts[product]!!
        quantity--
        selectedProducts[product] = quantity
        notifyValueChange()
    }

    fun increaseQuantity(product: Product){
        var quantity: Int = selectedProducts[product]!!
        quantity++
        selectedProducts[product] = quantity
        notifyValueChange()
    }

    fun getPrice(): Double{
        var price: Double = 0.0
        for(items in selectedProducts.keys){
            val quantity: Int= selectedProducts[items]!!
            val totalPrice= items.price * quantity
            price += totalPrice
        }
        return price
    }

    fun getSelectedProducts(): Map<Product, Int>{
        return selectedProducts.toMap()
    }

    fun getCartLiveData():MutableLiveData<MutableMap<Product,Int>>{
        return cartLiveData
    }
    private fun notifyValueChange() {
        cartLiveData.value = selectedProducts
    }
    fun clearCart(){
        selectedProducts.clear()

        notifyValueChange()
    }
}