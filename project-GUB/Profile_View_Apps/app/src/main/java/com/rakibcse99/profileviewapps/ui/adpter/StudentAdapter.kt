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
                firstName.text = it.name
                id.text = it.id.toString()
                ksa1.text = it.ksa1.toString()
                ksa2.text = it.ksa2.toString()
                quiz.text = it.quizMark.toString()
                mid.text = it.mid.toString()
                finalS.text = it.final.toString()
                val totalNumber =
                    (it.ksa1 ?: 0) + (it.ksa2 ?: 0) + (it.final ?: 0) + (it.quizMark ?: 0) + (it.mid
                        ?: 0)
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