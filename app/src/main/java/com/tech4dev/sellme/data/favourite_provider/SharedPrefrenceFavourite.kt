package com.tech4dev.sellme.data.favourite_provider

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData

class SharedPreferenceFavourite(context: Context) : FavouriteProvider {
    //Created our sharedpreference file
    private val favouriteStorage: SharedPreferences = context.getSharedPreferences("FAVOURITES", Context.MODE_PRIVATE)
    //Create an editor instance
    private val editor: SharedPreferences.Editor = favouriteStorage.edit()
    //Create an instance of a live data
    private val livedata = MutableLiveData<List<String>>()

    override fun addFavourite(productId: String) {
        editor.putString(productId,productId)
        editor.apply()

        notifyObservers()
    }

     override fun removeFavourite(productId: String) {
        editor.remove(productId)
        editor.apply()

        notifyObservers()
    }

    override fun isFavourite(productId: String): Boolean {
        val item: String? = favouriteStorage.getString(productId, "")
        if(item.isNullOrEmpty()){
            return false
        }
        return true
    }

    override fun getFavouriteItems(): MutableLiveData<List<String>> {
        return livedata
    }


    private fun notifyObservers(){
        livedata.value = favouriteStorage.all.keys.toList()
    }
}
