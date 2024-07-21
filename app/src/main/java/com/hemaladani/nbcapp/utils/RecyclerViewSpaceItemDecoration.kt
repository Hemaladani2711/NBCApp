package com.hemaladani.nbcapp.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewSpaceItemDecoration(var space: Int):RecyclerView.ItemDecoration() {
    init {
        this.space = space
    }
    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        outRect.left = space
        outRect.right = space
        outRect.bottom = space
    }
}