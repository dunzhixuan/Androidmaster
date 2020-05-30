package com.dunzhixuan.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
  static final String DEFAULT_RES_PATH_FREFIX = "android.resource://";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      String channelId = "chat";
      String channelName = "聊天消息";
      int importance = NotificationManager.IMPORTANCE_HIGH;
      createNotificationChannel(channelId, channelName, importance);

      channelId = "subscribe";
      channelName = "订阅消息";
      importance = NotificationManager.IMPORTANCE_DEFAULT;
      createNotificationChannel(channelId, channelName, importance);
    }

    Button button = findViewById(R.id.btn_notification);
    button.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            addNotificaction2(MainActivity.this, "标题", "内容", "answer_right", "", null);
            //            showNotifyOnlyText();
          }
        });

    ImageView imageView = findViewById(R.id.img_notification);
    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.notification);
    Bitmap newbm = scaleBitmap(bitmap);
    imageView.setImageBitmap(newbm);
  }

  @TargetApi(Build.VERSION_CODES.O)
  private void createNotificationChannel(String channelId, String channelName, int importance) {
    NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
    NotificationManager notificationManager =
        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    notificationManager.createNotificationChannel(channel);
  }

  public synchronized void addNotificaction2(
      Context context,
      String title,
      String content,
      String audio,
      String pic,
      PendingIntent pendingIntent) {

    NotificationCompat.Builder mBuilder;
    Notification notification = null;
    //		int assignSoundId =
    //						context
    //										.getResources()
    //										.getIdentifier(Utils.getAudio(audio), DEFAULT_RES_SOUND_TYPE, getPackageName());
    mBuilder = new NotificationCompat.Builder(context, "chat");

    int assignSoundId =
        context.getResources().getIdentifier(getAudio(audio), "raw", getPackageName());

    if (assignSoundId != 0) {
      String defaultSoundPath = DEFAULT_RES_PATH_FREFIX + getPackageName() + "/" + assignSoundId;

      Uri soundRes = Uri.parse(defaultSoundPath);
      mBuilder.setSound(soundRes);
    }

    mBuilder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
    if (pendingIntent != null) {
      mBuilder.setContentIntent(pendingIntent);
    }
    mBuilder.setSmallIcon(R.mipmap.lib_push_launcher_icon);

    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.notification);
    Bitmap newbm = scaleBitmap(bitmap);
    mBuilder.setLargeIcon(newbm);
    mBuilder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));

    mBuilder.setAutoCancel(true);
    mBuilder.setContentTitle(title);
    mBuilder.setContentText(content);
    if (!TextUtils.isEmpty(pic)) {
      mBuilder.setStyle(
          new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeFile(pic)));
    }

    notification = mBuilder.build();
	  if (assignSoundId != 0) {
		  String defaultSoundPath = DEFAULT_RES_PATH_FREFIX + getPackageName() + "/" + assignSoundId;
		  Uri soundRes = Uri.parse(defaultSoundPath);

      mBuilder.setSound(soundRes);
//      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//        // 播放提示声音
//        try {
//          Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), soundRes);
//          r.play();
//        } catch (Exception e) {
//          DebugLog.e("notification", "sound", e);
//        }
//      } else {
//        notification.sound = soundRes;
//      }
	  }

    NotificationManagerCompat mManager = NotificationManagerCompat.from(getApplicationContext());
    mManager.notify(1, notification);
  }

  /** 最普通的通知效果 */
  private void showNotifyOnlyText() {
    NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    PendingIntent contentIntent =
        PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);

    Notification notification =
        new Notification.Builder(this)
            .setContentTitle("My notification")
            .setContentText("Hello World!")
            .setSmallIcon(R.mipmap.lib_push_launcher_icon)
            //            .setContentIntent(contentIntent)
            .build(); // getNotification()

    mNotifyMgr.notify(1, notification);
  }

  private Bitmap scaleBitmap(Bitmap bitmap) {
    if (bitmap == null) return null;

    int width = bitmap.getWidth();
    int height = bitmap.getHeight();
    Matrix matrix = new Matrix();
    Bitmap newbm;
    if (width == height) return null;
    if (width < height) {
      float ratio = (float) width / height;
      matrix.postScale(1, ratio);
    } else {
      float ratio = (float) height / width;
      matrix.postScale(ratio, 1);
    }
    newbm = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);

    return newbm;
  }

  public static String getAudio(String audio) {
    try {
      if (!TextUtils.isEmpty(audio)) {
        return audio.split("\\.")[0];
      }
    } catch (Exception e) {

    }
    return "";
  }
}
