package com.tech4dev.sellme.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tech4dev.sellme.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private lateinit var binding: FragmentNotificationsBinding

    private lateinit var  notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        binding = FragmentNotificationsBinding.inflate(inflater, container, false)

        return binding.root
    }

   override fun onViewCreated(view: View,savedInstanceState: Bundle?){
       val listOfNotification =notificationsViewModel.getAllNotifications()
       binding.listOfNotification.layoutManager=LinearLayoutManager(requireContext())
       binding.listOfNotification.adapter=NotificationsAdapter(requireContext(), listOfNotification)
      val dividerItemDecoration= DividerItemDecoration(requireContext(),RecyclerView.VERTICAL)
       binding.listOfNotification.addItemDecoration(dividerItemDecoration)

   }

}