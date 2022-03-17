package com.example.wikipedia.adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikipedia.dataClass.ItemPost
import com.example.wikipedia.databinding.ItemExploreBinding

class ExploreAdaptor(private val data: ArrayList<ItemPost>,val itemEvents: ItemEvents) :
    RecyclerView.Adapter<ExploreAdaptor.ExploreViewHolder>() {


    inner class ExploreViewHolder(private val binding: ItemExploreBinding) : RecyclerView.ViewHolder(binding.root){


        fun bindViews(post: ItemPost){
            Glide.with(itemView.context).load(post.url).into(binding.imgExploreMain)
            binding.txtExploreTitle.text=post.txtTitle
            binding.txtExploreDetail.text=post.txtDetail
            binding.txtExploreSubTitle.text=post.subTitle
            itemView.setOnClickListener {
                itemEvents.onItemClicked(post)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        val binding = ItemExploreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExploreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
       holder.bindViews(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}