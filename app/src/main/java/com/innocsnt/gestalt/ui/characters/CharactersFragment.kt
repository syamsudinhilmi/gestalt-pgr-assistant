package com.innocsnt.gestalt.ui.characters

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.innocsnt.gestalt.adapter.ConstructAdapter
import com.innocsnt.gestalt.data.local.DataManager
import com.innocsnt.gestalt.databinding.FragmentCharactersBinding

class CharactersFragment : Fragment() {

    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!
    private lateinit var constructRV: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = constructRV.adapter as ConstructAdapter

        binding.apply {
            searchView.setupWithSearchBar(searchBar)
            searchView.editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    adapter.filterByName(s.toString())
                }
                override fun afterTextChanged(s: Editable?) {}
            })
        }
    }


    private fun setupRecyclerView() {
        constructRV = binding.constructRV

        val dataManager = DataManager()
        dataManager.loadData()

        constructRV.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
            val constructAdapter = ConstructAdapter(
                dataManager.constructList,
                dataManager.classList,
            )
            adapter = constructAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}