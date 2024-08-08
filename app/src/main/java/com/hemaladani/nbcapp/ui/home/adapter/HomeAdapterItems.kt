package com.hemaladani.nbcapp.ui.home.adapter

import android.provider.Settings.Global.getString
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.Placeholder
import com.bumptech.glide.integration.compose.placeholder
import com.hemaladani.nbcapp.R

@OptIn(ExperimentalGlideComposeApi::class)
//@Preview
@Composable
fun homeAdapterItemsView(imageUrl:String,showLabel:String){
    Column(modifier = Modifier.height(200.dp).width(200.dp)) {
        //TODO: FIX image height and width
        GlideImage(modifier = Modifier.fillMaxSize(),model = imageUrl, contentDescription = "Show Images")
        Text(text = showLabel, color = Color.White)
    }
}