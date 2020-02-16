package com.programmers.android.apps.line.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.programmers.android.apps.line.R
import com.programmers.android.apps.line.adapters.viewholders.MemoItemClick
import com.programmers.android.apps.line.adapters.viewholders.MemoListViewHolder
import com.programmers.android.apps.line.models.Memo


class MemoListAdapter(private val listener: MemoItemClick) : RecyclerView.Adapter<MemoListViewHolder>() {
    var memoList: List<Memo> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoListViewHolder =
        MemoListViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_memo_item,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = memoList.size

    override fun onBindViewHolder(holder: MemoListViewHolder, position: Int) {
        val memo = memoList[position]
        holder.apply { bind(listener, memo) }
    }
}