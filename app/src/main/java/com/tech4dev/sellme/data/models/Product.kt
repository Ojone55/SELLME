package com.tech4dev.sellme.data.models

data class Product(
    var image: String? =null,
    var name : String? =null,
    var price : Double=0.0,
    var seller: String? =null,
    var size : String? =null,
    var uid : String? =null,
)
