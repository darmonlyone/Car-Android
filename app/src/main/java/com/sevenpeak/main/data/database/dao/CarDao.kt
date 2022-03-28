package com.sevenpeak.main.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sevenpeak.main.data.database.model.CarData

@Dao
interface CarDao {
    @Query("SELECT * FROM CarData")
    fun getAll(): Array<CarData>

    @Insert
    fun insertAll(vararg users: CarData)

    @Query("DELETE FROM CarData")
    fun clear()
}