package com.rakibcse99.profileviewapps.ui

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.rakibcse99.profileviewapps.base.Status
import com.rakibcse99.profileviewapps.databinding.ActivityAddStudentInfoBinding
import com.rakibcse99.profileviewapps.repository.model.StudentDto
import com.rakibcse99.profileviewapps.ui.viewModel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddStudentInfoActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddStudentInfoBinding
    private val viewModeCharacter by viewModels<CharacterViewModel>()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddStudentInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //  val id:Int= binding.id.id





        binding.submit.setOnClickListener {
            if (validation()) {
                var student: StudentDto =
                    StudentDto(

                        binding.finals.text.toString(),
                        binding.id.text.toString(),

                        binding.ksa1.text.toString(),
                        binding.ksa2.text.toString(),
                        binding.quiz.text.toString(),
                        binding.mid.text.toString(),
                        binding.name.text.toString(),

                        )
                viewModeCharacter.addStudent(student)

            }

        }


        lifecycleScope.launch {
            viewModeCharacter.dataResponseModelResult.collectLatest {

                when (it.status) {
                    Status.SUCCESS -> {


                        val dataResponse = it.data
                        Toast.makeText(this@AddStudentInfoActivity, dataResponse?.message, Toast.LENGTH_SHORT).show()


                    }
                    Status.LOADING -> {

                    }
                    Status.ERROR -> {


                        val errMsg = it.error?.message ?: ""
                        Toast.makeText(this@AddStudentInfoActivity, (errMsg), Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun validation(): Boolean {

        if (binding.name.text.isNullOrEmpty()) {
            binding.name.setError("Enter name")
            binding.name.focusable
            return false
        }
        return true
    }
}