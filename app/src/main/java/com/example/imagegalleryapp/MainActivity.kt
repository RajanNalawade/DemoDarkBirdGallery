package com.example.imagegalleryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imagegalleryapp.databinding.ActivityMainBinding
import com.google.android.material.imageview.ShapeableImageView

class MainActivity : AppCompatActivity() {
    private lateinit var galleryAdapter: CustomizedGalleryAdapter

    private lateinit var binding: ActivityMainBinding

    private val images = intArrayOf(
        R.drawable.icon_1,
        R.drawable.icon_2,
        R.drawable.icon_3,
        R.drawable.icon_4,
        R.drawable.icon_5,
        R.drawable.icon_6,
        R.drawable.icon_7,
        R.drawable.icon_8
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        galleryAdapter = CustomizedGalleryAdapter(this, images)
        binding.apply {
            viewImage.setImageResource(images[0]);
            imgGallery.let {
                it.adapter = galleryAdapter
                it.setOnItemClickListener { parent, view, position, id ->
                    // Whichever image is clicked, that is set in the  selectedImageView
                    // position will indicate the location of image
                    viewImage.setImageResource(images[position]);
                    it.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
                        viewImage.setImageResource(images[position]);
                    }
                }
            }

        }

    }
}