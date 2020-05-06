package com.ridwanharts.jadwaladzan.util

import android.content.Context
import android.os.Build
import java.time.LocalDateTime.now
import java.time.format.DateTimeFormatter

class CurrentDate {

    fun getDate(): String?{
        var date : String? = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            date = now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        }else{

        }
        return date
    }

}
