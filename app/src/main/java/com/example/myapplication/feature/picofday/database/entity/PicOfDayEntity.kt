package com.example.myapplication.feature.picofday.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pic_of_day")
data class PicOfDayEntity(
    @PrimaryKey
    val date: String,
    val title: String,
    val description: String,
    val cachedUrl: String
)
