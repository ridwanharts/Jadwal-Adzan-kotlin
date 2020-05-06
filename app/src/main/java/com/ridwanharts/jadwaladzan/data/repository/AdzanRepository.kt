package com.ridwanharts.jadwaladzan.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ridwanharts.jadwaladzan.Coroutines
import com.ridwanharts.jadwaladzan.data.db.AppDatabase
import com.ridwanharts.jadwaladzan.data.db.entities.Data
import com.ridwanharts.jadwaladzan.data.db.entities.TimeAdzan
import com.ridwanharts.jadwaladzan.data.network.ApiAdzan
import com.ridwanharts.jadwaladzan.data.network.SafeApiRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AdzanRepository(
    private val api : ApiAdzan,
    private val db: AppDatabase
): SafeApiRequest() {

    private val datax = MutableLiveData<Data>()

    suspend fun getData(currentDate: String?): LiveData<Data>{
        return withContext(Dispatchers.IO){
            val response = apiRequest {
                api.getData(currentDate!!)
            }
            datax.postValue(response.jadwal?.data)
            db.getDataDao().saveData(response.jadwal?.data!!)
            db.getDataDao().getData()
        }
    }

    fun getDatax() = db.getDataDao().getData()

    fun filterTimeAdzan() : ArrayList<TimeAdzan>{
        val listTimeAdzan = ArrayList<TimeAdzan>()

        val listData = arrayOf(
            TimeAdzan("Imsak", getDatax().value?.imsak.toString()),
            TimeAdzan("Subuh", getDatax().value?.subuh.toString()),
            TimeAdzan("Dzuhur", getDatax().value?.dzuhur.toString()),
            TimeAdzan("Ashar", getDatax().value?.ashar.toString()),
            TimeAdzan("Maghrib", getDatax().value?.maghrib.toString()),
            TimeAdzan("Isya", getDatax().value?.isya.toString())
        )

        for (i in 0 until listData.size){
            listTimeAdzan.add(listData.get(i))
        }
        return listTimeAdzan
    }

}
