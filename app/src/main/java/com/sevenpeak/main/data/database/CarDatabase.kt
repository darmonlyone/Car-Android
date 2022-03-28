package com.sevenpeak.main.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sevenpeak.main.data.database.dao.CarDao
import com.sevenpeak.main.data.database.model.CarData

@Database(entities = [CarData::class], version = 1)
@TypeConverters(DateConverters::class)
abstract class CarDatabase : RoomDatabase() {
    abstract fun carDao(): CarDao
}

