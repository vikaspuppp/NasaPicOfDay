package com.example.myapplication.feature.picofday.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.feature.picofday.database.entity.PicOfDayEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PicOfDayDao {
    @Query("SELECT * FROM pic_of_day ")
    fun getPicOfDay(): Flow<PicOfDayEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(picOfDayEntity: PicOfDayEntity)

    @Query("SELECT COUNT(date) FROM pic_of_day")
    suspend fun hasCached()
}