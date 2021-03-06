package com.programmers.android.apps.line.models.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.programmers.android.apps.line.DB_TABLE_MEMO
import com.programmers.android.apps.line.models.Memo

@Dao
interface MemoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMemo(memo: Memo)

    @Delete
    suspend fun deleteMemo(vararg memo: Memo)

    @Query("SELECT * FROM $DB_TABLE_MEMO ORDER BY memoId DESC")
    fun getAllMemos(): LiveData<List<Memo>>

    @Query("SELECT * FROM $DB_TABLE_MEMO WHERE memoId = :id")
    suspend fun getMemo(id: String): Memo

    @Update
    suspend fun modifyMemo(memo: Memo)

    @Query("DELETE FROM $DB_TABLE_MEMO")
    suspend fun deleteAll()
}