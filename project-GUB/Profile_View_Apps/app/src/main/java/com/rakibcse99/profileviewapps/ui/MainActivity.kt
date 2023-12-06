package com.rakibcse99.profileviewapps.ui

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
import com.rakibcse99.profileviewapps.ui.adpter.CharacterModelViewAdapter
import com.rakibcse99.profileviewapps.ui.viewModel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
private lateinit var  binding: ActivityMainBinding
    @Inject
   lateinit var characterViewAdapter: CharacterModelViewAdapter


    private val viewModeCharacter by viewModels<CharacterViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(true) // Hide the default title
        binding.shimmerLChatList.startShimmer()
        viewModeCharacter.getCharacter()
        initViews()
        lifecycleScope.launch {
            viewModeCharacter.characterModelResult.collectLatest {

                when (it.status) {
                    Status.SUCCESS -> {
                       binding.shimmerLChatList.stopShimmer()
                       binding.shimmerLChatList.visibility = View.GONE

                        val characterModel = it.data
                        characterModel?.apply {
                            characterViewAdapter.differ.submitList(toList())

                        }
                    }
                        Status.LOADING -> {
                            binding.shimmerLChatList.startShimmer()
                        }
                        Status.ERROR -> {
                            binding.shimmerLChatList.stopShimmer()
                            binding.shimmerLChatList.visibility = View.GONE

                            val errMsg = it.error?.message ?: ""
                            Toast.makeText(this@MainActivity, (errMsg), Toast.LENGTH_SHORT).show()
                        }
                    }

                }
            }
        }


    private fun initViews() {
      binding.apply{
            recylerview.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
                adapter = characterViewAdapter
            }
          swipeRefreshLayout.setOnRefreshListener {
          viewModeCharacter.getCharacter()
              swipeRefreshLayout.isRefreshing = false
          }
        }
    }


    override fun onResume() {
        super.onResume()
     binding.shimmerLChatList.startShimmer()

    }

    override fun onPause() {
      binding.shimmerLChatList.stopShimmer()
        super.onPause()
    }
}