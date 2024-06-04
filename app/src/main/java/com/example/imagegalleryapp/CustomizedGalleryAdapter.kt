package com.example.imagegalleryapp

import android.content.Context
import android.content.res.ColorStateList
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Gallery
import com.google.android.material.imageview.ShapeableImageView

class CustomizedGalleryAdapter(private val context: Context, private val images: IntArray) :
    BaseAdapter() {
    override fun getCount(): Int = images.size

    override fun getItem(position: Int) = images[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return ShapeableImageView(context).apply {
            setImageResource(images[position])
            layoutParams = Gallery.LayoutParams(200, 200)
            if (isSelected) {
                strokeColor =
                    ColorStateList.valueOf(resources.getColor(R.color.black, context.theme))
                strokeWidth = 10f
            }
        }
    }


}