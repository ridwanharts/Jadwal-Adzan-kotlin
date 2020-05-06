package com.ridwanharts.jadwaladzan.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ridwanharts.jadwaladzan.data.db.entities.CURRENT_USER_ID
import com.ridwanharts.jadwaladzan.data.db.entities.Data

@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveData(data: Data)

    @Query("SELECT * FROM Data WHERE uid = $CURRENT_USER_ID")
    fun getData() : LiveData<Data>

}