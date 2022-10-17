package com.tech4dev.sellme.ui.favourite

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.tech4dev.sellme.R
import com.tech4dev.sellme.data.models.Product
import com.tech4dev.sellme.databinding.FragmentFavouriteBinding
import com.tech4dev.sellme.ui.home.ProductsAdapter

class FavouriteFragment : Fragment() {
    private lateinit var fragmentFavouriteBinding: FragmentFavouriteBinding
    private lateinit var viewModel: FavouriteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(FavouriteViewModel::class.java)

        fragmentFavouriteBinding = FragmentFavouriteBinding.inflate(inflater, container, false)
        return fragmentFavouriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getAllFavouriteProducts().observe(viewLifecycleOwner) { listOfUids ->

            viewModel.getProductFromUids(listOfUids).observe(viewLifecycleOwner) { listOfProducts ->
                if (listOfProducts.size>0) {
                    fragmentFavouriteBinding.listOfFavourites.visibility = View.GONE
                    fragmentFavouriteBinding.notFound.visibility = View.VISIBLE

                    fragmentFavouriteBinding.listOfFavourites.adapter =
                        ProductsAdapter(requireContext(), listOfProducts, childFragmentManager)

                    fragmentFavouriteBinding.listOfFavourites.layoutManager =
                        GridLayoutManager(requireContext(), 2)
                } else {
                    //Favourite is empty message
                    fragmentFavouriteBinding.listOfFavourites.visibility = View.GONE
                    fragmentFavouriteBinding.notFound.visibility = View.VISIBLE
                }
            }

        }

    }
}