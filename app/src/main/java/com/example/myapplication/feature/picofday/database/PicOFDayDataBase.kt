package com.example.myapplication.feature.picofday.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.feature.picofday.database.dao.PicOfDayDao
import com.example.myapplication.feature.picofday.database.entity.PicOfDayEntity

@Database(entities = [PicOfDayEntity::class], version = 1, exportSchema = false)
abstract class PicOFDayDataBase : RoomDatabase() {
    abstract fun picOfDayDao(): PicOfDayDao

    companion object {
        @Volatile
        private var INSTANCE: PicOFDayDataBase? = null

        fun getDatabase(context: Context): PicOFDayDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PicOFDayDataBase::class.java,
                    "PIC_OF_DAY_DATABASE"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}