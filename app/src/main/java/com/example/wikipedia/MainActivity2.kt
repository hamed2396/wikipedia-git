package com.example.wikipedia

import android.R
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.wikipedia.dataClass.ItemPost
import com.example.wikipedia.databinding.ActivityMain2Binding
import com.example.wikipedia.fragments.SEND_DATA_TO_SECOND_ACTIVITY

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBarMain)
        binding.colMain.setExpandedTitleColor(ContextCompat.getColor(this, R.color.transparent))
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val dataPost=intent.getParcelableExtra<ItemPost>(SEND_DATA_TO_SECOND_ACTIVITY)
        dataPost?.let {
            showData(dataPost)
        }



    }

    private fun showData(itemPost: ItemPost) {
        Glide.with(this).load(itemPost.url).into(binding.imgDetail)
        binding.txtDetailTitle.text=itemPost.txtTitle
        binding.txtDetailSubTitle.text=itemPost.subTitle
        binding.txtDetailText.text=itemPost.txtDetail
        binding.detailOpenWiki.setOnClickListener {
            val address="https://en.wikipedia.org/wiki/Main_Page"
            val intent= Intent(Intent.ACTION_VIEW, Uri.parse(address))
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId== R.id.home){
            onBackPressed()
        }

        return true
    }
}