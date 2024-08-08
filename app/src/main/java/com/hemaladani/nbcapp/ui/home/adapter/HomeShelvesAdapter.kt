package com.hemaladani.nbcapp.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.ui.platform.ComposeView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hemaladani.nbcapp.R
import com.hemaladani.nbcapp.data.dto.home.Item

class HomeShelvesAdapter(val context:Context, val trendingNowItems:List<Item>):
    RecyclerView
    .Adapter<HomeShelvesAdapter.TrendingNowViewHolder>() {
    inner class TrendingNowViewHolder(val trendingNowItemView: ComposeView): RecyclerView.ViewHolder
        (trendingNowItemView){
       /* val imgShow:ImageView = trendingNowItemView.findViewById(R.id.img_trending_now)
        val lblShow:TextView = trendingNowItemView.findViewById(R.id.lbl_trending_now_show)*/
            fun bind(imageUrl:String,showLabel:String){
                trendingNowItemView.setContent { homeAdapterItemsView(imageUrl = imageUrl, showLabel = showLabel) }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingNowViewHolder {
       return TrendingNowViewHolder(ComposeView(parent.context))
    }

    override fun getItemCount(): Int = trendingNowItems.size

    override fun onBindViewHolder(holder: TrendingNowViewHolder, position: Int) {
        val trendingNowShow = trendingNowItems[position]
        /*holder.lblShow.text = trendingNowShow.title
        Glide.with(context).load(trendingNowShow.image).into(holder.imgShow)*/
        trendingNowShow?.image?.let { holder.bind(it,trendingNowShow.title) }
    }

}