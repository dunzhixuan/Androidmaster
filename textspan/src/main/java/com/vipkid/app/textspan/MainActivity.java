package com.vipkid.app.textspan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ShowAllTextView textView = findViewById(R.id.txv);
    textView.setMaxShowLines(3);

    String title =
        "“我在墨西哥、意大利、摩洛哥、法国、瑞典、挪威、泰国、巴厘岛……每个孩子来上课时，问外教Nate的第一个问题是：\uD83D\uDE02\n\n你现在在哪里？他的回答都不一样。\\n\\n即便出门在外，他也一点没耽误给孩子们";
//    SpannableString themeAndTitleText = new SpannableString("#" + "北美好外教" + "#  " + title);
//
//    themeAndTitleText.setSpan(
//        new ShowAllSpan(
//            this,
//            new ShowAllSpan.OnAllSpanClickListener() {
//              @Override
//              public void onClick(View widget) {
//	              Toast.makeText(MainActivity.this, "点击了主题", Toast.LENGTH_SHORT).show();
//              }
//            }),
//        0,
//        7,
//        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//    textView.setMyText(themeAndTitleText);
//    textView.setMovementMethod(LinkMovementMethod.getInstance());

    textView.setMyText(title);
    textView.setOnAllSpanClickListener(
        new ShowAllSpan.OnAllSpanClickListener() {
          @Override
          public void onClick(View view) {
            Toast.makeText(MainActivity.this, "点击了全文1", Toast.LENGTH_SHORT).show();
          }
        });
  }
}
