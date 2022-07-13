package com.example.myapplication.mainactivity.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.application.di.DaggerApplicationComponent
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.mainactivity.adapter.MainActivityAdapter
import com.example.myapplication.mainactivity.data.Data
import com.example.myapplication.mainactivity.listeners.OnItemClickListener
import com.example.myapplication.secondactivity.SecondActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: MainViewModel by viewModels {
        factory
    }

    private lateinit var binding: ActivityMainBinding

    private val adapter = MainActivityAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAdapter(this)
        DaggerApplicationComponent.builder().build().inject(this)
        bindViewModel()
    }

    private fun setAdapter(context: Context) {
        with(binding) {
            gifsRecyclerView.adapter = adapter
            gifsRecyclerView.layoutManager = LinearLayoutManager(context)
            adapter.setOnItemClickListener(object : OnItemClickListener {
                override fun onItemClick(data: Data) {
                    Log.d("TAG", "onItemClick: ${data.images.urlAddress.url}")
                    val intent = Intent(this@MainActivity, SecondActivity::class.java)
                    intent.putExtra("url", data.images.urlAddress.url)
                    startActivity(intent)
                }
            })
        }
    }

    private fun bindViewModel() {
        viewModel.getGifs()
        viewModel.gifList.observe(this) {
            adapter.setGifsList(it)
        }
    }
}