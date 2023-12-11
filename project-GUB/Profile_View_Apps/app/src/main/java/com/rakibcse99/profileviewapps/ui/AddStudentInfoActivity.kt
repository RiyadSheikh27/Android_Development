package com.rakibcse99.profileviewapps.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.rakibcse99.profileviewapps.R
import com.rakibcse99.profileviewapps.databinding.ActivityAddStudentInfoBinding
import com.rakibcse99.profileviewapps.databinding.ActivityStudentListBinding
import com.rakibcse99.profileviewapps.repository.model.StudentModelItem
import com.rakibcse99.profileviewapps.ui.viewModel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddStudentInfoActivity : AppCompatActivity() {
lateinit var binding: ActivityAddStudentInfoBinding
    private val viewModeCharacter by viewModels<CharacterViewModel>()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddStudentInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
      //  val id:Int= binding.id.id

        var student:StudentModelItem = StudentModelItem(0,0,0,0,0,"rakib",0,0)



        binding.submit.setOnClickListener {
            if(validation()){


            }
            // viewModeCharacter.addStudent(student)

        }
    }


@RequiresApi(Build.VERSION_CODES.O)
private  fun validation():Boolean{

    if (binding.name.text.isNullOrEmpty()){
        binding.name.setError("Enter name")
        binding.name.focusable
        return false
    }
    return true
}
}