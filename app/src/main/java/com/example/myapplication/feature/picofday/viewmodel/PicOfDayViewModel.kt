package com.example.myapplication.feature.picofday.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.feature.picofday.model.ErrorModel
import com.example.myapplication.feature.picofday.model.PicOfDayModel

class PicOfDayViewModel(application: Application) : AndroidViewModel(application) {
    val isProgress: MutableLiveData<Boolean> by lazy { MutableLiveData() }
    val dataModel: MutableLiveData<PicOfDayModel> by lazy { MutableLiveData() }
    val errorModel: MutableLiveData<ErrorModel> by lazy { MutableLiveData() }

    fun fetchData() {
        if (!isNetworkAvailable()) {
            if (isCachedAvailable()) {
                // return data from DB.
                return
            }
//            return only error and blank screen.
            return
        }
//  cached into DB
// return data
    }

    private fun isNetworkAvailable(): Boolean =
        (getApplication<Application>()
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
            .activeNetworkInfo?.isConnectedOrConnecting == true

    private fun isCachedAvailable(): Boolean {
//        fetched the data from data base and return true false.
        return true
    }

}