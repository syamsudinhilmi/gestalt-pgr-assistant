package com.innocsnt.gestalt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.innocsnt.gestalt.data.model.ElementDistribution
import com.innocsnt.gestalt.data.model.MemoryPosition
import com.innocsnt.gestalt.databinding.ItemElementDistributionBinding
import com.innocsnt.gestalt.databinding.ItemMemoriesRecommendationBinding

class MemoryPositionAdapter(
    private val memoryPositionList: List<MemoryPosition>
) :
    RecyclerView.Adapter<MemoryPositionAdapter.MemoryPositionViewHolder>() {

    inner class MemoryPositionViewHolder(private val binding: ItemMemoriesRecommendationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(memoryPosition: MemoryPosition) {
            Glide.with(binding.root.context)
                .load(memoryPosition.memories.memoryAvatar)
                .into(binding.ivMemo)

            binding.tvMemoName.text = memoryPosition.memories.memoryName
            binding.tvMemoUsage.text = "x${memoryPosition.usage}"
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MemoryPositionViewHolder {
        val view = ItemMemoriesRecommendationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MemoryPositionViewHolder(view)
    }

    override fun getItemCount(): Int = memoryPositionList.size

    override fun onBindViewHolder(holder: MemoryPositionViewHolder, position: Int) {
        val memoryPosition = memoryPositionList[position]
        holder.bind(memoryPosition)
    }
}