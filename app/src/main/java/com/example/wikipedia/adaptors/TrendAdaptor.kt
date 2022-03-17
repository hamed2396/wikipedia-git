package com.example.wikipedia.adaptors

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikipedia.dataClass.ItemPost
import com.example.wikipedia.databinding.ItemExploreBinding
import com.example.wikipedia.databinding.ItemTrendBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class TrendAdaptor(private val data: ArrayList<ItemPost>,val itemEvents: ItemEvents) :
    RecyclerView.Adapter<TrendAdaptor.TrendViewHolder>() {


    inner class TrendViewHolder(private val binding: ItemTrendBinding) : RecyclerView.ViewHolder(binding.root){


        @SuppressLint("SetTextI18n")
        fun bindViews(post: ItemPost){

            binding.textTrendInsight.text=post.insight
            binding.textTrendTitle.text=post.txtTitle
            binding.textTrendSubtitle.text=post.subTitle
            binding.textTrendNumber.text=(adapterPosition+1).toString()
            Glide.with(binding.root).load(post.url).transform(RoundedCornersTransformation(32,8)).into(binding.imageView2)

            itemView.setOnClickListener {
                itemEvents.onItemClicked(post)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendViewHolder {
        val binding = ItemTrendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrendViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {
        holder.bindViews(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

