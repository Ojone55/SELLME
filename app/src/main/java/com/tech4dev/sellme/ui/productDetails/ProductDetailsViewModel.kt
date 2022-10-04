package com.tech4dev.sellme.ui.productDetails

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.AndroidViewModel

class ProductDetailsViewModel (application: Application):AndroidViewModel(application){
    private val context:Context=application.applicationContext

    fun saveToCart(id:String){
        //access the sharedpreference
        //get access to the editor
        //save the id 

    }
}
