package com.rakibcse99.profileviewapps.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rakibcse99.profileviewapps.R
import com.rakibcse99.profileviewapps.base.Status
import com.rakibcse99.profileviewapps.databinding.ActivityStudentListBinding
import com.rakibcse99.profileviewapps.ui.adpter.StudentAdapter
import com.rakibcse99.profileviewapps.ui.viewModel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
@AndroidEntryPoint
class StudentListActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityStudentListBinding

    @Inject
    lateinit var studentAdapter: StudentAdapter


    private val viewModeCharacter by viewModels<CharacterViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityStudentListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModeCharacter.getStudent()
        initViews()

        lifecycleScope.launch {
            viewModeCharacter.studentModelResult.collectLatest {

                when (it.status) {
                    Status.SUCCESS -> {


                        val characterModel = it.data
                        characterModel?.apply {
                            studentAdapter.differ.submitList(toList())

                        }
                    }
                    Status.LOADING -> {

                    }
                    Status.ERROR -> {


                        val errMsg = it.error?.message ?: ""
                        Toast.makeText(this@StudentListActivity, (errMsg), Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }



    private fun initViews() {
        binding.apply{
            recylerview.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@StudentListActivity, RecyclerView.VERTICAL, false)
                adapter = studentAdapter
            }
        }
    }

}