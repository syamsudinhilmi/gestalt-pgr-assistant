package com.innocsnt.gestalt.adapter

import android.content.Context
import android.content.Intent
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.innocsnt.gestalt.data.model.Class
import com.innocsnt.gestalt.data.model.Construct
import com.innocsnt.gestalt.databinding.ItemCharsBinding
import com.innocsnt.gestalt.ui.detailcharacters.DetailCharsActivity
import com.innocsnt.gestalt.ui.detailcharacters.DetailCharsActivity.Companion.ELEMENT_DISTRIBUTION_LIST

class ConstructAdapter(
    private val constructList: List<Construct>,
    private val classList: List<Class>,
) : RecyclerView.Adapter<ConstructAdapter.ConstructViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null
    fun setOnItemClickCallBack (onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Construct)
    }

    private var filteredConstructList: List<Construct> = constructList.toList()

    fun filterByName(query: String) {
        filteredConstructList = if (query.isEmpty()) {
            constructList.toList()
        } else {
            constructList.filter {
                it.consName.contains(query, ignoreCase = true)
                        || it.consFrame.contains(query, ignoreCase = true)
            }
        }
        if (filteredConstructList.isEmpty()) {
            filteredConstructList = constructList.toList()
        }

        notifyDataSetChanged()
    }

    class ConstructViewHolder(private val binding: ItemCharsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            construct: Construct,
            consClass: Class?,
        ) {

            Glide.with(binding.root.context)
                .asBitmap()
                .load(construct.consAvatar)
                .into(binding.ivChars)

            Glide.with(binding.root.context)
                .load(consClass?.classAvatar)
                .into(binding.ivCharsClass)

            binding.tvConstruct.text = construct.consName
            binding.tvFrame.text = construct.consFrame
            binding.tvRank.text = construct.consRank

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailCharsActivity::class.java)
                intent.putExtra(DetailCharsActivity.CHAR_AVATAR_3D, construct.consAvatar3d)
                intent.putExtra(DetailCharsActivity.CHAR_AVATAR_AWAKEN, construct.consAvatarAwaken)
                intent.putExtra(DetailCharsActivity.CHAR_AVATAR_DORM, construct.consAvatarDorm)
                intent.putExtra(DetailCharsActivity.CHAR_AVATAR_MODEL, construct.consAvatarModel)
                intent.putExtra(DetailCharsActivity.CONSTRUCT_NAME, construct.consName)
                intent.putExtra(DetailCharsActivity.CONSTRUCT_FRAME, construct.consFrame)
                intent.putExtra(DetailCharsActivity.CONSTRUCT_RANK, construct.consRank)
                intent.putExtra(DetailCharsActivity.CONSTRUCT_INFO, construct.consInfo)
                intent.putExtra(DetailCharsActivity.CONSTRUCT_SPECIALTY, construct.consSpecialty)
                intent.putExtra(DetailCharsActivity.CONSTRUCT_CLASS, consClass?.classAvatar)
                intent.putExtra(DetailCharsActivity.CONSTRUCT_HP, construct.consHp)
                intent.putExtra(DetailCharsActivity.CONSTRUCT_DEF, construct.consDef)
                intent.putExtra(DetailCharsActivity.CONSTRUCT_ATK, construct.consAtk)
                intent.putExtra(DetailCharsActivity.CONSTRUCT_CRIT, construct.consCrit)
                intent.putExtra(DetailCharsActivity.CONS_MENTAL_AGE, construct.consMentalAge)
                intent.putExtra(DetailCharsActivity.CONS_ACTIVE_DATE, construct.consActiveDate)
                intent.putExtra(DetailCharsActivity.CONS_HEIGHT, construct.consHeight)
                intent.putExtra(DetailCharsActivity.CONS_WEIGHT, construct.consWeight)
                intent.putExtra(DetailCharsActivity.CONS_FLUID_TYPE, construct.consFluidType)

                intent.putParcelableArrayListExtra(ELEMENT_DISTRIBUTION_LIST, ArrayList(construct.consElementDistribution))
                intent.putParcelableArrayListExtra(DetailCharsActivity.MEMORY_POSITION_LIST, ArrayList(construct.consMemoryPosition))

                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConstructViewHolder {
        val view = ItemCharsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConstructViewHolder(view)
    }

    private fun Int.dpToPx(context: Context): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            context.resources.displayMetrics
        ).toInt()
    }


    override fun getItemCount(): Int = filteredConstructList.size

    override fun onBindViewHolder(holder: ConstructViewHolder, position: Int) {
        val construct = filteredConstructList[position]
        val consClass = classList.find { it.classId == construct.consClass.classId }
        holder.bind(construct, consClass)

        val layoutParams = holder.itemView.layoutParams as ViewGroup.MarginLayoutParams
        if (position % 2 == 0) {
            layoutParams.setMargins(
                16.dpToPx(holder.itemView.context),
                8.dpToPx(holder.itemView.context),
                8.dpToPx(holder.itemView.context),
                8.dpToPx(holder.itemView.context)
            )
        } else {
            layoutParams.setMargins(
                8.dpToPx(holder.itemView.context),
                8.dpToPx(holder.itemView.context),
                16.dpToPx(holder.itemView.context),
                8.dpToPx(holder.itemView.context)
            )
        }
    }
}