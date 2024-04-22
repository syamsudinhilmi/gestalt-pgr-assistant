package com.innocsnt.gestalt.adapter.pager

import android.content.Context
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.innocsnt.gestalt.R
import com.innocsnt.gestalt.ui.detailcharacters.build.BuildFragment
import com.innocsnt.gestalt.ui.detailcharacters.information.InformationFragment

class DetailPagerAdapter(
    private val mCtx: Context,
    fragmentManager: FragmentManager,
    data: Bundle
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var fragmentBundle: Bundle

    init {
        fragmentBundle = data
    }

    @StringRes
    private val tabHeaders = intArrayOf(R.string.title_build, R.string.title_information)

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = BuildFragment()
            1 -> fragment = InformationFragment()
        }
        fragment?.arguments = this.fragmentBundle

        return fragment as Fragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mCtx.resources.getString(tabHeaders[position])
    }
}