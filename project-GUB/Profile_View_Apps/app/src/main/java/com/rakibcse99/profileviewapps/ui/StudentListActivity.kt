package com.rakibcse99.profileviewapps.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rakibcse99.profileviewapps.base.Status
import com.rakibcse99.profileviewapps.databinding.ActivityStudentListBinding
import com.rakibcse99.profileviewapps.repository.model.StudentModelItem
import com.rakibcse99.profileviewapps.ui.adpter.StudentAdapter
import com.rakibcse99.profileviewapps.ui.viewModel.CharacterViewModel
import com.rakibcse99.profileviewapps.utils.SimpleCallback
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class StudentListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentListBinding

    @Inject
    lateinit var studentAdapter: StudentAdapter


    private val viewModeCharacter by viewModels<CharacterViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModeCharacter.getStudent()
        initViews()
        studentAdapter.updateListener = object : SimpleCallback<StudentModelItem> {
            @SuppressLint("SuspiciousIndentation")
            override fun callback(any: StudentModelItem) {
                val bundle = Bundle()
                bundle.putInt("id", any.id ?: 0)
                bundle.putString("name", any.name)
                bundle.putInt("ksa1", any.ksa1 ?: 0)
                bundle.putInt("ksa2", any.ksa2 ?: 0)
                bundle.putInt("mid", any.mid ?: 0)
                bundle.putInt("final", any.final ?: 0)
                bundle.putInt("total", any.total ?: 0)
                bundle.putInt("mark", any.quizMark ?: 0)
              val i=  Intent(this@StudentListActivity, UpdateStudentActivity::class.java)
                i.putExtras(bundle)
                startActivity(
                  i
                )
            }
        }

        studentAdapter.deleteListener = object : SimpleCallback<StudentModelItem> {
            override fun callback(any: StudentModelItem) {
                any.id?.let { viewModeCharacter.delete(it.toString()) }
                Toast.makeText(this@StudentListActivity, "Deleted", Toast.LENGTH_SHORT).show()
                onBackPressed()
            }

        }

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
                        Toast.makeText(this@StudentListActivity, (errMsg), Toast.LENGTH_SHORT)
                            .show()
                    }
                }

            }
        }
    }


    private fun initViews() {
        binding.apply {
            recylerview.apply {
                setHasFixedSize(true)
                layoutManager =
                    LinearLayoutManager(this@StudentListActivity, RecyclerView.VERTICAL, false)
                adapter = studentAdapter
            }
        }
    }

}