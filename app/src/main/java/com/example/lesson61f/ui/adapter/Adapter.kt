package com.example.lesson61f.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lesson61f.data.model.ExampleModel
import com.example.lesson61f.databinding.ItemBinding


class Adapter : ListAdapter<ExampleModel, Adapter.ExampleModelViewHolder>(ExampleModelDiffUtil) {

    inner class ExampleModelViewHolder(private val binding: ItemBinding) : ViewHolder(binding.root) {
        fun onBind(item: ExampleModel) = with(binding) {
            title.text = item.text
            image.setImageResource(item.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleModelViewHolder {
        return ExampleModelViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ExampleModelViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val ExampleModelDiffUtil = object : DiffUtil.ItemCallback<ExampleModel>() {
            override fun areItemsTheSame(oldItem: ExampleModel, newItem: ExampleModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ExampleModel, newItem: ExampleModel): Boolean {
                return oldItem.text == newItem.text
            }
        }
    }
}