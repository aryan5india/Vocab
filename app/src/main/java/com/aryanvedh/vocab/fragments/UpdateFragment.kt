package com.aryanvedh.vocab.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.aryanvedh.vocab.R
import com.aryanvedh.vocab.database.Word
import com.aryanvedh.vocab.database.WordViewModel
import kotlinx.coroutines.currentCoroutineContext

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mViewModel: WordViewModel

    private lateinit var wordUpdate: EditText
    private lateinit var meaningUpdate: EditText
    private lateinit var updateData: Button
    private lateinit var wordView: TextView
    private lateinit var meaningView: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        wordUpdate = view.findViewById(R.id.wordUpdate)
        meaningUpdate = view.findViewById(R.id.meaningUpdate)
        updateData = view.findViewById(R.id.updateData)
        wordUpdate.setText(args.currentWord.word)
        meaningUpdate.setText(args.currentWord.meaning)

        wordView = view.findViewById(R.id.wordView)
        meaningView = view.findViewById(R.id.meaningView)

        wordView.text = wordUpdate.text.toString()
        meaningView.text = meaningUpdate.text.toString()


        mViewModel = ViewModelProvider(this).get(WordViewModel::class.java)

        updateData.setOnClickListener {
            updateItem()
        }

        return view
    }

    private fun updateItem() {
        val word = wordUpdate.text.toString()
        val meaning = meaningUpdate.text.toString()

        if (inputCheck(word, meaning)) {
            val updatedWord = Word(args.currentWord.id, word, meaning)

            mViewModel.update(updatedWord)

            findNavController().navigate(R.id.action_updateFragment_to_homeFragment)
            Toast.makeText(context, "Successfully updated", Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(context, "Fill fields to update", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(word: String, meaning: String): Boolean {
        return !(TextUtils.isEmpty(word) && TextUtils.isEmpty(meaning))
    }
}