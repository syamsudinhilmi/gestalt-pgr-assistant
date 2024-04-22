package com.innocsnt.gestalt.ui.detailcharacters

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.innocsnt.gestalt.adapter.pager.DetailPagerAdapter
import com.innocsnt.gestalt.adapter.ElementDistributionAdapter
import com.innocsnt.gestalt.data.model.ElementDistribution
import com.innocsnt.gestalt.databinding.ActivityDetailCharsBinding

class DetailCharsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailCharsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCharsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindingViews()
        pagerSetup()
        setupRecyclerView()
    }


    private fun pagerSetup() {
        val pagerAdapter = DetailPagerAdapter(this, supportFragmentManager, intent.extras!!)
        binding.viewPager.adapter = pagerAdapter
        binding.tab.setupWithViewPager(binding.viewPager)
    }

    private fun setupRecyclerView() {
        // Mendapatkan data elementDistribution dari intent
        val elementDistributions: List<ElementDistribution> =
            intent.getParcelableArrayListExtra(ELEMENT_DISTRIBUTION_LIST)
                ?: throw IllegalArgumentException("Element distribution list is null")

        val adapter = ElementDistributionAdapter(elementDistributions)

        // Tetapkan layout manager ke RecyclerView
        binding.rvElements.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        // Tetapkan adapter ke RecyclerView
        binding.rvElements.adapter = adapter
    }


    private fun bindingViews() {
        val charAvatar3D = intent.getStringExtra(CHAR_AVATAR_3D)
        val charAvatarAwaken = intent.getStringExtra(CHAR_AVATAR_AWAKEN)
        val charAvatarDorm = intent.getStringExtra(CHAR_AVATAR_DORM)
        val charAvatarModel = intent.getStringExtra(CHAR_AVATAR_MODEL)
        val constructName = intent.getStringExtra(CONSTRUCT_NAME)
        val constructFrame = intent.getStringExtra(CONSTRUCT_FRAME)
        val construtClass = intent.getStringExtra(CONSTRUCT_CLASS)
        val constructRank = intent.getStringExtra(CONSTRUCT_RANK)

        Glide.with(this)
            .load(charAvatar3D)
            .into(binding.ivAvatar3d)
        Glide.with(this)
            .load(charAvatarAwaken)
            .into(binding.ivAvatarAwaken)
        Glide.with(this)
            .load(charAvatarDorm)
            .into(binding.ivAvatarDorm)
        Glide.with(this)
            .load(charAvatarModel)
            .into(binding.ivAvatarModel)
        Glide.with(this)
            .load(construtClass)
            .into(binding.ivCharsClass)

        binding.tvConstruct.text = constructName
        binding.tvFrame.text = constructFrame
        binding.tvRank.text = constructRank
    }

    companion object {
        const val CHAR_AVATAR_3D = "char_avatar_3d"
        const val CHAR_AVATAR_AWAKEN = "char_avatar_awaken"
        const val CHAR_AVATAR_DORM = "char_avatar_dorm"
        const val CHAR_AVATAR_MODEL = "char_avatar_model"
        const val CONSTRUCT_NAME = "construct_name"
        const val CONSTRUCT_FRAME = "construct_frame"
        const val CONSTRUCT_RANK = "construct_rank"
        const val CONSTRUCT_INFO = "construct_info"
        const val CONSTRUCT_CLASS = "construct_class"
        const val CONSTRUCT_SPECIALTY = "construct_specialty"
        const val CONSTRUCT_HP = "construct_hp"
        const val CONSTRUCT_DEF = "construct_def"
        const val CONSTRUCT_ATK = "construct_atk"
        const val CONSTRUCT_CRIT = "construct_crit"

        const val CONS_MENTAL_AGE = "cons_mental_age"
        const val CONS_ACTIVE_DATE = "cons_active_date"
        const val CONS_HEIGHT = "cons_height"
        const val CONS_WEIGHT = "cons_weight"
        const val CONS_FLUID_TYPE = "cons_fluid_type"
        const val ELEMENT_DISTRIBUTION_LIST = "element_distribution_list"
        const val MEMORY_POSITION_LIST = "memory_position_list"
    }
}