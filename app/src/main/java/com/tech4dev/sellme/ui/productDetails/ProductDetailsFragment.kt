package com.tech4dev.sellme.ui.productDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tech4dev.sellme.data.models.Product
import com.tech4dev.sellme.databinding.FragmentProductDetailsListDialogBinding

class ProductDetailsFragment(val product: Product) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentProductDetailsListDialogBinding
    private lateinit var productDetailsViewModel: ProductDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        productDetailsViewModel=ViewModelProvider(this).get(ProductDetailsViewModel::class.java)
        binding = FragmentProductDetailsListDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Glide.with(requireContext())
            .load(product.image)
            .into(binding.productImage)

        //show.details
        binding.productName.text =product.name
        binding.price.text= "$${product.price}"
        binding.seller.text=product.seller
        binding.size.text=product.size

        binding.addToCart.setOnClickListener {
            //get the product id
            val id:String=product.uid?:""
            //save the product id to sharedpreference
            productDetailsViewModel.saveToCart(product)
            //alert user that it has been added to cart
            Toast.makeText(requireContext(),"Save To Cart",Toast.LENGTH_LONG).show()

        }
    }
}