package com.tech4dev.sellme.data.repository

import com.tech4dev.sellme.data.models.Product

object CartRepository {
    private val selectedProduct = mutableMapOf<Product, Int>()

    fun addToCart(product: Product) {
        selectedProduct.put(product,1)

}
    fun removeFromCart(product: Product){
        selectedProduct.remove(product)
    }
    fun reduceQuantity(product: Product){
        //get quantity
        var quantity:Int= selectedProduct[product]!!
        quantity
        selectedProduct[product] =quantity

    }
    fun increaseQuantity(product: Product){
        //get quantity
        var quantity:Int= selectedProduct[product]!!
        quantity
        selectedProduct[product] =quantity


    }


    fun getPrice():Double {
        var price: Double = 0.0
        for (items in selectedProduct.keys) {
            price += items.price
        }
        return price
    }
    fun getSelectedProduct():Map<Product, Int>{
        return selectedProduct.toMap()
    }
}




