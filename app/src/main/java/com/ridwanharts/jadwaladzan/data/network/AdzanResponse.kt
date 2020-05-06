package com.ridwanharts.jadwaladzan.data.network

import com.ridwanharts.jadwaladzan.data.db.entities.Jadwal
import com.ridwanharts.jadwaladzan.data.db.entities.Query

data class AdzanResponse(
    val jadwal: Jadwal?,
    val query: Query?,
    val status: String?
)