package com.example.lesson61f.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson61f.R
import com.example.lesson61f.data.model.ExampleModel
import com.example.lesson61f.databinding.FragmentRecyclerViewBinding
import com.example.lesson61f.ui.adapter.Adapter

class RecyclerViewFragment : Fragment(R.layout.fragment_recycler_view) {
    private val binding by viewBinding(FragmentRecyclerViewBinding::bind)
    private val adapter = Adapter()
    private val list = mutableListOf<ExampleModel>()
    private val viewModel by viewModels<ViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeRecyclerView()
        setupObserve()
    }

    private fun initializeRecyclerView() = with(binding) {
        rv.adapter = this@RecyclerViewFragment.adapter
        this@RecyclerViewFragment.adapter.submitList(list)
    }

    private fun setupObserve() {
        viewModel.animeLiveData.observe(viewLifecycleOwner) {
            Log.e("tag", "list:${adapter}")
            adapter.submitList(it)
        }
    }
}