package com.tech4dev.sellme.ui.cart

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.tech4dev.sellme.databinding.FragmentCartBinding

class CartFragment : Fragment() {


    private   lateinit var binding : FragmentCartBinding
    private lateinit var cartViewModel: CartViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        cartViewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        binding= FragmentCartBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var productsInCart = cartViewModel.getProducts()

        binding.itemsInCart.layoutManager =LinearLayoutManager(requireContext())
        binding.itemsInCart.adapter=CartAdapter(requireContext(),productsInCart)
       //Add line seperator
        val dividerItemDecoration= DividerItemDecoration(requireContext(),RecyclerView.VERTICAL)
        binding.itemsInCart.addItemDecoration(dividerItemDecoration)


    }
}

