package com.ridwanharts.jadwaladzan.ui

import androidx.lifecycle.ViewModel
import com.ridwanharts.jadwaladzan.data.db.entities.TimeAdzan
import com.ridwanharts.jadwaladzan.data.repository.AdzanRepository
import com.ridwanharts.jadwaladzan.lazyDefered
import com.ridwanharts.jadwaladzan.util.CurrentDate

class TestViewModel(
    repository: AdzanRepository
): ViewModel() {

    val currentDate = CurrentDate().getDate()

    val getData by lazyDefered {
        repository.getData(currentDate)
    }

    var data = repository.getDatax()

    var list = repository.filterTimeAdzan()

    fun filterTimeAdzan() : ArrayList<TimeAdzan>{
        val listTimeAdzan = ArrayList<TimeAdzan>()

        val listData = arrayOf(
            TimeAdzan("Imsak", data.value?.imsak.toString()),
            TimeAdzan("Subuh", data.value?.subuh.toString()),
            TimeAdzan("Dzuhur", data.value?.dzuhur.toString()),
            TimeAdzan("Ashar", data.value?.ashar.toString()),
            TimeAdzan("Maghrib", data.value?.maghrib.toString()),
            TimeAdzan("Isya", data.value?.isya.toString())
        )

        for (i in 0 until listData.size){
            listTimeAdzan.add(listData.get(i))
        }
        return listTimeAdzan
    }


}