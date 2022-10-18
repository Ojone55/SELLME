package com.tech4dev.sellme.ui.notifications

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tech4dev.sellme.data.models.Notification
import com.tech4dev.sellme.data.repository.NotificationRepository


    class NotificationsViewModel(application: Application) : AndroidViewModel(application) {
        private val repo = NotificationRepository(application)

        private val _text = MutableLiveData<String>().apply {
            value = "This is notifications Fragment"
            fun getAllNotifications(): MutableList<Notification> {
                return repo.getAllNotifications()
            }



        }
}
