package com.android.guicelebrini.kotlincoroutines.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.guicelebrini.kotlincoroutines.R
import com.android.guicelebrini.kotlincoroutines.model.Character
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.characters_list_item.view.*

class AdapterRecyclerCharacters(val charactersList: ArrayList<Character>, val context: Context) : RecyclerView.Adapter<AdapterRecyclerCharacters.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.characters_list_item, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val character = charactersList[position]

        holder.set(character, context)
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun set (character: Character, context: Context){

            itemView.text_name.text = character.name
            itemView.text_house.text = character.house
            itemView.text_ancestry.text = character.ancestry
            Glide.with(context).load(character.image).into(itemView.image_character)

        }

    }
}