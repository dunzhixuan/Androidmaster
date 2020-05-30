package com.dunzhixuan.glide;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

  private ImageView img_1, img_2, img_3;
  private Button btn1, btn2, btn3;
  private String url1 =
      "https://img.vipkidstatic.com/parent/feeback/cd0257b780734c50a359ab7094960087.png";
  private String url2 =
      "https://img.vipkidstatic.com/parent/feeback/abcbfd299b1e4f34a96695d698014535.png";;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    img_1 = findViewById(R.id.img_1);
    img_2 = findViewById(R.id.img_2);
    img_3 = findViewById(R.id.img_3);
    btn1 = findViewById(R.id.btn1);
    btn2 = findViewById(R.id.btn2);
    btn3 = findViewById(R.id.btn3);

    btn1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Glide.with(MainActivity.this)
                .load(url1)
                .centerCrop()
                .placeholder(R.drawable.m_homepage_default_circle_radius15_bg)
                .error(R.drawable.m_homepage_default_circle_radius15_bg)
                .crossFade()
//                    .skipMemoryCache(true)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transform(new GlideCircleTransform(MainActivity.this))
                .into(img_1);

            Glide.with(MainActivity.this)
                .load(url2)
                .centerCrop()
                .placeholder(R.drawable.m_homepage_default_circle_radius15_bg)
                .error(R.drawable.m_homepage_default_circle_radius15_bg)
                    .crossFade()
//                    .skipMemoryCache(true)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transform(new GlideCircleTransform(MainActivity.this))
                .into(img_2);
          }
        });

    btn2.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Glide.with(MainActivity.this)
                .load(url2)
                .centerCrop()
                .placeholder(R.drawable.m_homepage_default_circle_radius15_bg)
                .error(R.drawable.m_homepage_default_circle_radius15_bg)
                    .crossFade()
//                    .skipMemoryCache(true)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transform(new GlideCircleTransform(MainActivity.this))
                .into(img_3);
          }
        });

    btn3.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Glide.with(MainActivity.this)
                .load(url1)
                .centerCrop()
                .placeholder(R.drawable.m_homepage_default_circle_radius15_bg)
                .error(R.drawable.m_homepage_default_circle_radius15_bg)
                    .crossFade()
//                    .skipMemoryCache(true)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transform(new GlideCircleTransform(MainActivity.this))
                .into(img_3);
          }
        });
  }
}
