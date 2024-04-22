package com.innocsnt.gestalt.ui.detailcharacters.build

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.innocsnt.gestalt.adapter.MemoryPositionAdapter
import com.innocsnt.gestalt.data.model.MemoryPosition
import com.innocsnt.gestalt.databinding.FragmentBuildBinding
import com.innocsnt.gestalt.ui.detailcharacters.DetailCharsActivity.Companion.MEMORY_POSITION_LIST

class BuildFragment : Fragment() {
    private var _binding: FragmentBuildBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBuildBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val memoryPositionList: List<MemoryPosition> = arguments?.getParcelableArrayList(MEMORY_POSITION_LIST) ?: listOf()

        val adapter = MemoryPositionAdapter(memoryPositionList)

        binding.rvMemories.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvMemories.adapter = adapter
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
