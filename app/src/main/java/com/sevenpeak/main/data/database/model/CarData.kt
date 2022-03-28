package com.sevenpeak.main.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class CarData(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "date") val date: Date?,
    @ColumnInfo(name = "ingress") val ingress: String,
    @ColumnInfo(name = "image_url") val imageUrl: String
)
