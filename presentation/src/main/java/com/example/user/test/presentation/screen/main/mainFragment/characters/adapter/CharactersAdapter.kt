package com.example.user.test.presentation.screen.main.mainFragment.characters.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.domain.entity.Characters
import com.example.user.test.R
import com.example.user.test.presentation.utils.setImageUrl
import kotlinx.android.synthetic.main.character_item.view.*

class CharactersAdapter(private val clickListener: (Characters) -> Unit)
    : RecyclerView.Adapter<CharactersAdapter.CharactersHolder>() {

    var list: List<Characters> = emptyList()

    override fun onCreateViewHolder(group: ViewGroup, position: Int): CharactersHolder {
        val inflater = LayoutInflater.from(group.context)
        val view = inflater.inflate(R.layout.character_item,group,false)

        return CharactersHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CharactersHolder, position: Int) {
       val character = list[position]

        holder.itemView.tvCharacterName.text = character.name
        holder.itemView.tvCharacterDescription.text = character.description
        holder.itemView.ivCharacterPhoto.setImageUrl(character.photoUrl)

        holder.itemView.setOnClickListener{
            clickListener(character)
        }
    }

    interface AdapterClickListener {
        fun onClick(character: Characters)
    }

    class CharactersHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}