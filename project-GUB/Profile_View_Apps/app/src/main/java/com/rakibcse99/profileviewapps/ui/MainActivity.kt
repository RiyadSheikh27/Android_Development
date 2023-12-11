package com.rakibcse99.profileviewapps.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rakibcse99.profileviewapps.base.Status
import com.rakibcse99.profileviewapps.databinding.ActivityMainBinding
import com.rakibcse99.profileviewapps.ui.viewModel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(true) // Hide the default title



        binding.addStudent.setOnClickListener {
            startActivity(Intent(this, AddStudentInfoActivity::class.java).apply {
                // you can add values(if any) to pass to the next class or avoid using `.apply`
                putExtra("keyIdentifier", "data")
            })
        }



        binding.allResult.setOnClickListener {
            startActivity(Intent(this, StudentListActivity::class.java).apply {
                // you can add values(if any) to pass to the next class or avoid using `.apply`
                putExtra("keyIdentifier", "data")
            })
        }


        }




}