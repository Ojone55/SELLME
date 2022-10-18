package com.tech4dev.sellme.data.firebase


import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.tech4dev.sellme.data.models.Product

class ProductDatasource {
    //Get reference to firestore database
    private val db = Firebase.firestore


    //Create function that will fetch the product from the database
    fun getProductInfo(): MutableLiveData<List<Product>> {
        val productLivedata = MutableLiveData<List<Product>>()
        db.collection("products")
            .get()
            .addOnSuccessListener { documents ->
                val listOfProducts: List<Product> = documents.toObjects(Product::class.java)
                productLivedata.value = listOfProducts
            }
            .addOnFailureListener{ error ->
                Log.e("Firebase Error", error.message.toString())
            }

        return productLivedata

    }

    //This will take a list of ids
    //and return a livedata of products which can be observed
    fun getProductFromUids(productUids: List<String>): MutableLiveData<List<Product>>{
        val productLivedata = MutableLiveData<List<Product>>(listOf())
        if(productUids.isEmpty()) return productLivedata

        db.collection("products")
            .whereIn("uid", productUids)
            .get()
            .addOnSuccessListener { documents ->
                val listOfProducts: List<Product> = documents.toObjects(Product::class.java)
                productLivedata.value = listOfProducts
            }
            .addOnFailureListener{ error ->
                Log.e("Firebase Error", error.message.toString())
            }

        return productLivedata
    }


}
