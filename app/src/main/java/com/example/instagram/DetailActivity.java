package com.example.instagram;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import org.parceler.Parcels;

import java.util.Date;


public class DetailActivity extends AppCompatActivity {

    Post post;
    TextView title;
    TextView caption;
    ImageView image;
    TextView timeStamp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        title = (TextView) findViewById(R.id.tvDetailTitle);
        caption = (TextView) findViewById(R.id.tvDetailCaption);
        image = (ImageView) findViewById(R.id.ivDetailImage);
        timeStamp = (TextView) findViewById(R.id.tvDetailTime);

        post = (Post) Parcels.unwrap(getIntent().getParcelableExtra(Post.class.getSimpleName()));

        title.setText(post.getUser().getUsername());
        caption.setText(post.getDescription());
        Date createdAt = post.getCreatedAt();
        String timeAgo = Post.calculateTimeAgo(createdAt);
        timeStamp.setText(timeAgo);

        ParseFile photo = post.getImage();
        if (photo != null) {
            Glide.with(this).load(photo.getUrl()).into(image);
        }


    }
}
