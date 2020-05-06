package com.ridwanharts.jadwaladzan.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID = 0

@Entity
data class Data(
    var imsak: String,
    var isya: String,
    var dzuhur: String,
    var dhuha: String,
    var subuh: String,
    var terbit: String,
    var ashar: String,
    var tanggal: String,
    var maghrib: String
){
    @PrimaryKey(autoGenerate = false)
    var uid: Int = CURRENT_USER_ID
}