package com.rakibcse99.profileviewapps.ui.adpter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rakibcse99.profileviewapps.databinding.ItemProfileBinding
import com.rakibcse99.profileviewapps.repository.model.StudentModelItem
import com.rakibcse99.profileviewapps.utils.SimpleCallback
import javax.inject.Inject

class StudentAdapter @Inject constructor() :
    RecyclerView.Adapter<StudentAdapter.CharacterHolder>() {
    var updateListener: SimpleCallback<StudentModelItem>? = null
    var deleteListener: SimpleCallback<StudentModelItem>? = null

    inner class CharacterHolder(val binding: ItemProfileBinding) :
        RecyclerView.ViewHolder(binding.root)


    private val differCallback = object : DiffUtil.ItemCallback<StudentModelItem>() {
        override fun areItemsTheSame(
            oldItem: StudentModelItem,
            newItem: StudentModelItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: StudentModelItem,
            newItem: StudentModelItem
        ): Boolean {
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
        val studentModel = differ.currentList[position]

//        holder
        holder.binding.apply {
            studentModel?.let {
                firstName.text ="Name:"+it.name
                id.text ="ID:"+ it.id.toString()
                ksa1.text ="Mark of KSA1: "+ it.ksa1.toString()
                ksa2.text = "Mark of KSA2: "+it.ksa2.toString()
                quiz.text = "Mark of Quiz: "+it.quizMark.toString()
                mid.text = "Mark of Mid: "+it.mid.toString()
                finalS.text = "Mark of Final: "+it.final.toString()
                var total_mark= (it.ksa1 ?: 0) + (it.ksa2 ?: 0) + (it.final ?: 0) + (it.quizMark ?: 0) + (it.mid
                    ?: 0)
                val totalNumber ="Total Mark:"+total_mark
                total.text = totalNumber.toString()




                update.setOnClickListener {
                    updateListener?.callback(studentModel)

                }
                delete.setOnClickListener {
                    deleteListener?.callback(studentModel)

                }
            }
        }
    }
}