package com.example.myapplication.mainactivity.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.GifItemBinding
import com.example.myapplication.mainactivity.data.Data
import com.example.myapplication.mainactivity.listeners.OnItemClickListener

class MainActivityAdapter() : RecyclerView.Adapter<MainActivityAdapter.MainViewHolder>() {

    private var gifs = mutableListOf<Data>()
    private lateinit var clickListener: OnItemClickListener

    fun setOnItemClickListener(listener: OnItemClickListener) {
        clickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder =
        MainViewHolder(
            GifItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            clickListener
        )

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val gif = gifs[position]
        holder.binding.titleTextView.text = gif.title
        Glide.with(holder.itemView.context).asGif().load(gif.images.urlAddress.url)
            .into(holder.binding.gifImageView)
    }

    override fun getItemCount(): Int = gifs.size

    @SuppressLint("NotifyDataSetChanged")
    fun setGifsList(gifs: List<Data>) {
        this.gifs = gifs.toMutableList()
        notifyDataSetChanged()
    }

    inner class MainViewHolder(val binding: GifItemBinding, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                listener.onItemClick(gifs[adapterPosition])
            }
        }
    }
}