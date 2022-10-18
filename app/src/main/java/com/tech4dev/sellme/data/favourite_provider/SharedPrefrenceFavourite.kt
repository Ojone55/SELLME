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

    override fun addFavourite(productUid: String) {
        editor.putString(productUid,productUid)
        editor.commit()

        notifyObservers()
    }

     override fun removeFavourite(productUid: String) {
        editor.remove(productUid)
        editor.commit()

        notifyObservers()
    }

    override fun isFavourite(productUid: String): Boolean {
        val item: String? = favouriteStorage.getString(productUid, "")
        if(item.isNullOrEmpty()){
            return false
        }
        return true
    }

    override fun getFavouriteItems(): MutableLiveData<List<String>> {
        notifyObservers()
        return livedata

    }


    private fun notifyObservers(){
        livedata.value = favouriteStorage.all.keys.toList()
    }
}
