package com.innocsnt.gestalt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.innocsnt.gestalt.data.model.ElementDistribution
import com.innocsnt.gestalt.databinding.ItemElementDistributionBinding

class ElementDistributionAdapter(
    private val elementDistributionList: List<ElementDistribution>
) :
    RecyclerView.Adapter<ElementDistributionAdapter.ElementDistributionViewHolder>() {

    inner class ElementDistributionViewHolder(private val binding: ItemElementDistributionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(elementDistribution: ElementDistribution) {
            Glide.with(binding.root.context)
                .load(elementDistribution.element.elementAvatar)
                .into(binding.ivElement)

            binding.tvEleName.text = elementDistribution.element.elementName
            binding.tvElePercent.text = "${elementDistribution.percentage}%"
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ElementDistributionViewHolder {
        val view = ItemElementDistributionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ElementDistributionViewHolder(view)
    }

    override fun onBindViewHolder(holder: ElementDistributionViewHolder, position: Int) {
        val elementDistribution = elementDistributionList[position]
        holder.bind(elementDistribution)
    }

    override fun getItemCount(): Int = elementDistributionList.size
}