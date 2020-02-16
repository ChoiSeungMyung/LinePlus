package com.programmers.android.apps.line.models.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.programmers.android.apps.line.DB_TABLE_MEMO
import com.programmers.android.apps.line.models.Memo

@Dao
interface MemoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMemo(memo: Memo)

    @Delete
    fun deleteMemo(vararg memo: Memo)

    @Query("SELECT * FROM $DB_TABLE_MEMO ORDER BY memoId")
    fun getAllMemos(): LiveData<List<Memo>>

    @Query("SELECT * FROM $DB_TABLE_MEMO WHERE memoId = :id")
    fun getMemo(id: Int): Memo

    @Update
    fun modifyMemo(memo: Memo)

    @Query("DELETE FROM $DB_TABLE_MEMO")
    fun deleteAll()
}