package com.aryanvedh.vocab.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aryanvedh.vocab.R
import com.aryanvedh.vocab.WordAdapter
import com.aryanvedh.vocab.database.WordViewModel


class DictionaryFragment : Fragment(R.layout.fragment_dictionary) {

    private lateinit var mViewModel : WordViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dictRecy = view.findViewById<RecyclerView>(R.id.dictRecy)




    }

}