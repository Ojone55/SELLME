package com.tech4dev.sellme.ui.favourite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tech4dev.sellme.data.models.Product
import com.tech4dev.sellme.data.repository.FavouriteRepository

class FavouriteViewModel(application: Application) : AndroidViewModel(application) {
    private val favouriteRepository = FavouriteRepository(application)


    fun removeFromFavourite(id: String) {
        favouriteRepository.removeProduct(id)
    }

    fun addToFavourite(id: String) {
        favouriteRepository.addProduct(id)
    }

    fun getAllFavouriteProducts(): MutableLiveData<List<String>> {
        return favouriteRepository.getAllFavourites()
    }

    fun isFavourite(productId: String): Boolean {
        return favouriteRepository.isFavourite(productId)
    }

    fun getProductFromUids(listOfUids: List<String>): MutableLiveData<List<Product>> {
        return favouriteRepository.getProductFromUids(listOfUids)
    }

}