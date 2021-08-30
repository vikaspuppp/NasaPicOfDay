package com.example.myapplication.feature.picofday.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.feature.picofday.viewmodel.PicOfDayViewModel

class PicOfDayActivity : AppCompatActivity() {

    private lateinit var viewModel: PicOfDayViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pic_of_day)
        init()
        viewModel.fetchData()
    }

    private fun init() {
        viewModel = ViewModelProvider(this).get(PicOfDayViewModel::class.java)
        viewModel.isProgress.observe(this, Observer { })
        viewModel.dataModel.observe(this, Observer { })
        viewModel.errorModel.observe(this, Observer { })
    }
}