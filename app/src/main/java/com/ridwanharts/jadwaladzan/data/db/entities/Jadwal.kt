package com.ridwanharts.jadwaladzan.data.db.entities

import androidx.room.Entity

@Entity
data class Jadwal(
    val data: Data? = null,
    val status: String? = null
)
