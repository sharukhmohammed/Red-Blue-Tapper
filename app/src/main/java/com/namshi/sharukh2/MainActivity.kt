package com.namshi.sharukh2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Size
import androidx.recyclerview.widget.GridLayoutManager
import com.namshi.sharukh2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //val screenSize = Size(binding.root.width, binding.root.height)
        val screenSize = screenSize(this)

        binding.recycler.layoutManager = GridLayoutManager(this, 4)
        binding.recycler.adapter = TapAdapter(screenSize)


    }

}