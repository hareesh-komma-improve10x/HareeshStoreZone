package com.improve10x.hareeshstorezone;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class BindingUtilities {
    @BindingAdapter("imageUrl")

    public static void loadImage(ImageView imageView, String url) {
        Picasso.get().load(url).into(imageView);
    }
}
