package com.aryanvedh.vocab

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.aryanvedh.vocab.database.Word
import com.aryanvedh.vocab.fragments.HomeFragmentDirections

class WordAdapter(private val context: Context) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    var allWords = ArrayList<Word>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val viewholder =
            WordViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.word_item, parent, false))
        return viewholder
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val currentWord = allWords[position]
        holder.id.text = currentWord.id.toString()
        holder.word.text = currentWord.word
        holder.meaning.text = currentWord.meaning

        holder.row.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToUpdateFragment(currentWord)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return allWords.size
    }


    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id = itemView.findViewById<TextView>(R.id.wordID)
        val word = itemView.findViewById<TextView>(R.id.wordTexList)
        val meaning = itemView.findViewById<TextView>(R.id.wordMeaningTextView)
        val row = itemView.findViewById<ConstraintLayout>(R.id.wordRow)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(word: List<Word>){
        this.allWords = word as ArrayList<Word>
        notifyDataSetChanged()
    }

}

