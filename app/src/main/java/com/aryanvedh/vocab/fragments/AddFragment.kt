package com.aryanvedh.vocab.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.aryanvedh.vocab.R
import com.aryanvedh.vocab.database.Word
import com.aryanvedh.vocab.database.WordViewModel

class AddFragment : Fragment(R.layout.fragment_add) {
    private lateinit var mViewModel: WordViewModel
    private lateinit var wordEditText: EditText
    private lateinit var meaningEditText: EditText
    private lateinit var word: String
    private lateinit var meaning: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        wordEditText = view.findViewById(R.id.wordEditText)
        meaningEditText = view.findViewById(R.id.meaningEditText)

        mViewModel = ViewModelProvider(this).get(WordViewModel::class.java)

        val submitData = view.findViewById<Button>(R.id.submitData)

        submitData.setOnClickListener {
            insertDataToDatabse()
        }

    }

    private fun insertDataToDatabse() {
        word = wordEditText.text.toString()
        meaning = meaningEditText.text.toString()
        if (inputCheck(word, meaning)){
            val word = Word(0, word, meaning)
            mViewModel.insert(word)
            Toast.makeText(context, "Successfully Added", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_homeFragment)
        } else {
            Toast.makeText(context, "please fill all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(word: String, meaning: String): Boolean {
        return !(TextUtils.isEmpty(word) && TextUtils.isEmpty(meaning))
    }


}