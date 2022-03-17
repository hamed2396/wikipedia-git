package com.example.wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.wikipedia.dataClass.ItemPost
import com.example.wikipedia.databinding.ActivityMain3Binding
import com.example.wikipedia.fragments.SEND_DATA_TO_SECOND_ACTIVITY

class MainActivity3 : AppCompatActivity() {
    lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val dataPost=intent.getParcelableExtra<ItemPost>(SEND_DATA_TO_SECOND_ACTIVITY)
        dataPost?.let {
            showData(dataPost)
        }

    }

    private fun showData(post: ItemPost) {
        Glide.with(this).load(post.url).into(binding.imageView4)
    }
}