package com.tech4dev.sellme.data.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.tech4dev.sellme.data.favourite_provider.FavouriteProvider
import com.tech4dev.sellme.data.favourite_provider.SharedPreferenceFavourite



class FavouriteRepository(context: Context) {
    private val favouriteProvider: FavouriteProvider = SharedPreferenceFavourite(context)

    fun removeProduct(id: String) {
        favouriteProvider.removeFavourite(id)

    }

    fun addProduct(id: String) {
        favouriteProvider.addFavourite(id)
    }

    fun getAllFavourites(): MutableLiveData<List<String>>{
        return favouriteProvider.getFavouriteItems()
    }

    fun isFavourite(productId: String): Boolean {
        return favouriteProvider.isFavourite(productId)
    }
}