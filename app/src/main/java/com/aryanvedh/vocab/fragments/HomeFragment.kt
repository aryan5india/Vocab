package com.aryanvedh.vocab.fragments

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aryanvedh.vocab.R
import com.aryanvedh.vocab.WordAdapter
import com.aryanvedh.vocab.database.WordViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var mViewModel : WordViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerview = view.findViewById<RecyclerView>(R.id.wordRecyclerView)
        val mAdapter = WordAdapter(requireContext())
        recyclerview.adapter = mAdapter
        recyclerview.layoutManager = LinearLayoutManager(context)

        mViewModel = ViewModelProvider(this).get(WordViewModel::class.java)
        mViewModel.allWords.observe(viewLifecycleOwner, Observer { word ->
            mAdapter.setData(word)
        })

    }
}