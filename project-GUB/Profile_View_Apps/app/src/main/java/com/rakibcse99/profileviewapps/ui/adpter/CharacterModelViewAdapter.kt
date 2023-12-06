package com.rakibcse99.profileviewapps.ui.adpter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rakibcse99.profileviewapps.databinding.ItemProfileBinding
import com.rakibcse99.profileviewapps.repository.model.CharacterModel
import com.rakibcse99.profileviewapps.utils.SimpleCallback
import javax.inject.Inject

class CharacterModelViewAdapter @Inject constructor() :  RecyclerView.Adapter<CharacterModelViewAdapter.CharacterHolder>() {
    var listener: SimpleCallback<CharacterModel>? = null
    inner class CharacterHolder(val binding: ItemProfileBinding) :
        RecyclerView.ViewHolder(binding.root)


    private val differCallback = object : DiffUtil.ItemCallback<CharacterModel>() {
        override fun areItemsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {

        val binding =
            ItemProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterHolder(binding)

    }

    override fun getItemCount(): Int {
        return differ.currentList.size

    }


    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        val characterModel = differ.currentList[position]

//        holder
        holder.binding.apply {
            characterModel?.let {
                firstName.text=it.name
                gender.text=it.gender
                dateOfBirth.text=it.dateOfBirth
                Glide
                    .with(holder.binding.root)
                    .load(it.image)
                    .centerCrop()
                    .into(holder.binding.profileImage)

                     root.setOnClickListener {
                    listener?.callback(characterModel)

                }
            }
        }
    }
}