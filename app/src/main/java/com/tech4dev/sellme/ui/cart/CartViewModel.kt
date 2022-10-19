package com.tech4dev.sellme.ui.cart
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.tech4dev.sellme.data.models.Notification
import com.tech4dev.sellme.data.models.Product
import com.tech4dev.sellme.data.repository.CartRepository
import com.tech4dev.sellme.data.repository.NotificationRepository

class CartViewModel(application: Application) : AndroidViewModel(application) {


    private  val notificationRepo = NotificationRepository(application)

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

    fun clearCart() {
       CartRepository.clearCart()
    }

    fun saveNotification(notification: Notification) {
        notificationRepo.saveNotification(notification)

    }

}