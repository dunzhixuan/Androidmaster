package com.dunzhixuan.android_master;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.view.WindowManager;

import java.io.File;

/** 获取手机基本信息类 Created by tangjixiang on 16/4/21. */
public final class SystemUtils {
  /** 私有构造器 */
  private SystemUtils() {}

  /**
   * 获取屏幕宽高
   *
   * @param context 上下文对象
   * @return 屏幕宽高
   */
  public static int[] getWidthAndHeight(Context context) {
    WindowManager mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    int width = mWindowManager.getDefaultDisplay().getWidth();
    int height = mWindowManager.getDefaultDisplay().getHeight();
    int[] arr = new int[2];
    arr[0] = width;
    arr[1] = height;
    return arr;
  }

  public static String getPackageName(Context context) {
    String packageName;
    try {
      packageName =
          context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
    } catch (PackageManager.NameNotFoundException e) {
      return "";
    }
    return packageName;
  }

  /**
   * 获取版本名称
   *
   * @param context 上下文
   * @return 版本名称
   */
  public static String getVersionName(Context context) {
    String versionName;
    try {
      versionName =
          context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
    } catch (PackageManager.NameNotFoundException e) {
      return "";
    }
    return versionName;
  }

  /**
   * 获取版本号
   *
   * @param context 上下文
   * @return 版本号
   */
  public static int getVersionCode(Context context) {
    int versionCode;
    try {
      versionCode =
          context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
    } catch (PackageManager.NameNotFoundException e) {
      return -1;
    }
    return versionCode;
  }

  /**
   * 获取sd卡总容量
   *
   * @param context
   * @return
   */
  public static long getSDTotalSize(Context context) {
    String path = getSDPath();
    if (TextUtils.isEmpty(path)) {
      return 0;
    }
    try {
      StatFs stat = new StatFs(path);
      long blockSize = stat.getBlockSize();
      long totalBlocks = stat.getBlockCount();
      return blockSize * totalBlocks;
    } catch (IllegalArgumentException e) {
      return 0;
    }
  }

  /**
   * 获取SD卡剩余大小
   *
   * @param context
   * @return
   */
  public static long getSDAvailableSize(Context context) {
    String path = getSDPath();
    if (TextUtils.isEmpty(path)) {
      return 0;
    }
    try {
      StatFs stat = new StatFs(path);
      long blockSize = stat.getBlockSize();
      long availableBlocks = stat.getAvailableBlocks();
      return blockSize * availableBlocks;
    } catch (IllegalArgumentException e) {
      return 0;
    }
  }

  /** 判断sd卡是否存在 */
  private static String getSDPath() {
    File sdDir = null;
    boolean sdCardExist =
        Environment.getExternalStorageState()
            .equals(Environment.MEDIA_MOUNTED); // 判断sd卡是否存在
    if (sdCardExist) {
      sdDir = Environment.getExternalStorageDirectory(); // 获取跟目录
    }
    if (sdDir != null) {
      return sdDir.toString();
    } else {
      return null;
    }
  }

  public static boolean isMIUI() {
    String manufacturer = Build.MANUFACTURER;
    return "xiaomi".equalsIgnoreCase(manufacturer.toLowerCase());
  }

  public static boolean isEMUI() {
    String manufacturer = Build.MANUFACTURER;
    return "huawei".equalsIgnoreCase(manufacturer.toLowerCase());
  }

  public static boolean isOPPO() {
    String manufacturer = Build.MANUFACTURER;
    return "oppo".equalsIgnoreCase(manufacturer.toLowerCase());
  }

  public static boolean isVIVO() {
    String manufacturer = Build.MANUFACTURER;
    return "vivo".equalsIgnoreCase(manufacturer.toLowerCase());
  }
}
