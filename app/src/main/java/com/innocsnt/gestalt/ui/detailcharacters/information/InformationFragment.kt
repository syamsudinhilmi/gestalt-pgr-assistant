package com.innocsnt.gestalt.ui.detailcharacters.information

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.innocsnt.gestalt.adapter.ConstructAdapter
import com.innocsnt.gestalt.data.model.Construct
import com.innocsnt.gestalt.databinding.FragmentInformationBinding
import com.innocsnt.gestalt.ui.detailcharacters.DetailCharsActivity


class InformationFragment : Fragment() {
    private var _binding: FragmentInformationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        val constructInfo = args?.getString(DetailCharsActivity.CONSTRUCT_INFO)
        val constructSpeciality = args?.getString(DetailCharsActivity.CONSTRUCT_SPECIALTY)
        val constructHp = args?.getString(DetailCharsActivity.CONSTRUCT_HP)
        val constructDef = args?.getString(DetailCharsActivity.CONSTRUCT_DEF)
        val constructAtk = args?.getString(DetailCharsActivity.CONSTRUCT_ATK)
        val constructCrit = args?.getString(DetailCharsActivity.CONSTRUCT_CRIT)
        val consMentalAge = args?.getString(DetailCharsActivity.CONS_MENTAL_AGE)
        val consActiveDate = args?.getString(DetailCharsActivity.CONS_ACTIVE_DATE)
        val consHeight = args?.getString(DetailCharsActivity.CONS_HEIGHT)
        val consWeight = args?.getString(DetailCharsActivity.CONS_WEIGHT)
        val consFluidType = args?.getString(DetailCharsActivity.CONS_FLUID_TYPE)

        val adapter = ConstructAdapter(constructList = listOf(), classList = listOf())
        adapter.notifyDataSetChanged()


        adapter.setOnItemClickCallBack(object: ConstructAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Construct) {
                Intent(requireActivity(), DetailCharsActivity::class.java).also {
                    it.putExtra(DetailCharsActivity.CONSTRUCT_INFO, data.consInfo)
                    it.putExtra(DetailCharsActivity.CONSTRUCT_SPECIALTY, data.consSpecialty)
                    it.putExtra(DetailCharsActivity.CONSTRUCT_HP, data.consHp)
                    it.putExtra(DetailCharsActivity.CONSTRUCT_DEF, data.consDef)
                    it.putExtra(DetailCharsActivity.CONSTRUCT_ATK, data.consAtk)
                    it.putExtra(DetailCharsActivity.CONSTRUCT_CRIT, data.consCrit)
                    it.putExtra(DetailCharsActivity.CONS_MENTAL_AGE, data.consMentalAge)
                    it.putExtra(DetailCharsActivity.CONS_ACTIVE_DATE, data.consActiveDate)
                    it.putExtra(DetailCharsActivity.CONS_HEIGHT, data.consHeight)
                    it.putExtra(DetailCharsActivity.CONS_WEIGHT, data.consWeight)
                    it.putExtra(DetailCharsActivity.CONS_FLUID_TYPE, data.consFluidType)
                    startActivity(it)
                }
            }
        })

        binding.apply {
            tvInformation.text = constructInfo
            tvSpeciality.text = constructSpeciality
            tvHp.text = constructHp
            tvDef.text = constructDef
            tvAtk.text = constructAtk
            tvCrit.text = constructCrit
            tvMentalAge.text = consMentalAge
            tvActivation.text = consActiveDate
            tvHeight.text = consHeight
            tvWeight.text = consWeight
            tvVitalFluid.text = consFluidType
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}