package com.rakibcse99.profileviewapps.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.lifecycle.lifecycleScope
import com.rakibcse99.profileviewapps.base.Status
import com.rakibcse99.profileviewapps.databinding.ActivityAddStudentInfoBinding
import com.rakibcse99.profileviewapps.repository.model.StudentModelItem
import com.rakibcse99.profileviewapps.ui.viewModel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UpdateStudentActivity  : AppCompatActivity() {
    lateinit var binding: ActivityAddStudentInfoBinding
    private val viewModeCharacter by viewModels<CharacterViewModel>()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddStudentInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.extras?.getInt("id")
        val name = intent.extras?.getString("name")
        val ksa1 = intent.extras?.getInt("ksa1")
        val ksa2 = intent.extras?.getInt("ksa2")
        val mid = intent.extras?.getInt("mid")
        val mark = intent.extras?.getInt("mark")
         val final = intent.extras?.getInt("final")


        binding.id.setText(id.toString())
        binding.name.setText( name.toString())
        binding.ksa1.setText( ksa1.toString())
        binding.ksa2.setText( ksa2.toString())
        binding.mid.setText( mid.toString())
        binding.finals.setText(final.toString())
        binding.quiz.setText(mark.toString())




        binding.submit.setOnClickListener {
            if (validation()) {
                var student: StudentModelItem =
                    StudentModelItem(
                        binding.finals.text.toString().toInt(),
id.toString().toInt(),
                        binding.ksa1.text.toString().toInt(),
                        binding.ksa2.text.toString().toInt(),
                        binding.mid.text.toString().toInt(),
                        binding.name.text.toString(),
                        binding.quiz.text.toString().toInt(),
0
                        )
                viewModeCharacter.updateStudent(student)

            }

        }


        lifecycleScope.launch {
            viewModeCharacter.dataResponseModelResult.collectLatest {

                when (it.status) {
                    Status.SUCCESS -> {


                        val dataResponse = it.data
                        Toast.makeText(this@UpdateStudentActivity, dataResponse?.message, Toast.LENGTH_SHORT).show()


                    }
                    Status.LOADING -> {

                    }
                    Status.ERROR -> {


                        val errMsg = it.error?.message ?: ""
                        Toast.makeText(this@UpdateStudentActivity, (errMsg), Toast.LENGTH_SHORT).show()
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