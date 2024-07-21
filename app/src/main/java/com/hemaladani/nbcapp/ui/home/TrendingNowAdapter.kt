package com.hemaladani.nbcapp.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hemaladani.nbcapp.R
import com.hemaladani.nbcapp.data.Item

class TrendingNowAdapter(val context:Context, val trendingNowItems:List<Item>):
    RecyclerView
    .Adapter<TrendingNowAdapter
    .TrendingNowViewHolder>() {
    inner class TrendingNowViewHolder(trendingNowItemView: View): RecyclerView.ViewHolder
        (trendingNowItemView){
        val imgShow:ImageView = trendingNowItemView.findViewById(R.id.img_trending_now)
        val lblShow:TextView = trendingNowItemView.findViewById(R.id.lbl_trending_now_show)
        val imgShowProvider:ImageView = trendingNowItemView.findViewById(R.id.img_show_provider)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingNowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_trending_now,
            parent,false)
        return TrendingNowViewHolder(view)
    }

    override fun getItemCount(): Int = trendingNowItems.size

    override fun onBindViewHolder(holder: TrendingNowViewHolder, position: Int) {
        val trendingNowShow = trendingNowItems[position]
        holder.lblShow.text = trendingNowShow.title
        Glide.with(context).load(trendingNowShow.image).into(holder.imgShow)
    }

}