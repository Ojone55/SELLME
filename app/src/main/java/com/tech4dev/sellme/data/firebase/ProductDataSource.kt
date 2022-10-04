package com.tech4dev.sellme.data.firebase

import android.util.Log

import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.tech4dev.sellme.data.models.Product


class ProductDataSource{
    //Get reference to firestoredatabase
    private val db = Firebase. firestore

    fun getProductInfo(): MutableLiveData<List<Product>> {
        val productLivedata = MutableLiveData<List<Product>>()

        db.collection("product")
            .get()
            .addOnSuccessListener { documents ->
                val listOfProduct: List<Product> = documents.toObjects(Product::class.java)
                productLivedata.value = listOfProduct
            }


                    .addOnFailureListener { error ->
                        Log.e("Firebase Error", error.message.toString())
                    }
                return productLivedata
            }
    }

