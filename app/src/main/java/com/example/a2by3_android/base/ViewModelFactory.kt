package com.example.a2by3_android.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a2by3_android.ui.dashboard.DashboardViewModel
import com.example.a2by3_android.ui.home.HomeViewModel
import com.example.a2by3_android.ui.notifications.NotificationsViewModel
import javax.inject.Inject

/**
Created By Ovais on 12/16/20
 */
class ViewModelFactory @Inject constructor(private val repository: BaseRepository , private val paramters: Any ?= null) :
    ViewModelProvider.Factory {
    // add your view models here
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
          //  example below
            modelClass.isAssignableFrom(DashboardViewModel::class.java) -> DashboardViewModel(repository) as T
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(repository) as T
            modelClass.isAssignableFrom(NotificationsViewModel::class.java) -> NotificationsViewModel(repository) as T
            else -> throw IllegalAccessException("Unknown View Model.Please add your view model in factory")
        }
    }
}