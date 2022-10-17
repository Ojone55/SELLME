package com.tech4dev.sellme.data.favourite_provider

import androidx.lifecycle.MutableLiveData

interface FavouriteProvider {


    interface FavouriteProvider {
        fun addFavourite(productId: String)

        fun removeFavourite(productId: String)

        fun isFavourite(productId: String): Boolean

        fun getFavouriteItems(): MutableLiveData<List<String>>
    }

    fun addFavourite(productId: String)
    fun removeFavourite(productId: String)
    fun isFavourite(productId: String): Boolean
    fun getFavouriteItems(): MutableLiveData<List<String>>

}