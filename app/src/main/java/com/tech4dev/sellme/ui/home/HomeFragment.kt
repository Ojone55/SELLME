package com.tech4dev.sellme.ui.home

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.tech4dev.sellme.R
import com.tech4dev.sellme.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding
    private lateinit var homeViewModel:HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }
    override fun  onViewCreated(view: View,savedInstanceState: Bundle?)  {
       // The usage interface lets you inject your own implementation
        val menuHost: MenuHost= requireActivity()
        menuHost.addMenuProvider(HomeMenuProvider(),viewLifecycleOwner,Lifecycle.State.RESUMED)

        //Listen for products
        homeViewModel.getAllProduct().observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Number of products ${it.size}", Toast.LENGTH_LONG).show()
            homeViewModel.getAllProduct().observe(viewLifecycleOwner) {listOfFetchedProducts ->
                binding.listOfProduct.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.listOfProduct.adapter = ProductsAdapter(requireContext(), listOfFetchedProducts, childFragmentManager)
            }
        }

       
 }

    class HomeMenuProvider : MenuProvider {
        override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
            menuInflater.inflate(R.menu.home_menu, menu)
        }
        override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
            return true
        }

    }
}
    







