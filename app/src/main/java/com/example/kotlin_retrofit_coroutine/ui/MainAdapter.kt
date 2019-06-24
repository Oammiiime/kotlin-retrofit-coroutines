package com.example.kotlin_retrofit_coroutine.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_retrofit_coroutine.R
import com.example.kotlin_retrofit_coroutine.model.Data
import kotlinx.android.synthetic.main.adapter_main.view.*

class  MainAdapter : ListAdapter<Data, MainAdapter.MainViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_main, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(data: Data) {
        with(itemView) {
            textViewTitle.text = data.first_name
        }
    }
}

    class DiffCallback : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }
}