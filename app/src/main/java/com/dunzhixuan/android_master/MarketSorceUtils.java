package com.dunzhixuan.android_master;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

/*
 * 跳转到应用市场helper
 * 规则：先跳各自厂商自己的市场，其它的跳应用宝，无应用宝再跳市场选择页面
 * */
public class MarketSorceUtils {
  public static void toMarket(Context context) {
    String marketPkg = "";
    if (SystemUtils.isEMUI()) {
      marketPkg = "com.huawei.appmarket";
    } else if (SystemUtils.isMIUI()) {
      marketPkg = "com.xiaomi.market";
    } else if (SystemUtils.isOPPO()) {
      marketPkg = "com.oppo.market";
    } else if (SystemUtils.isVIVO()) {
      marketPkg = "com.bbk.appstore";
    } else {
      marketPkg = "com.tencent.android.qqdownloader";
    }
    launchAppDetail(context, SystemUtils.getPackageName(context), marketPkg);
  }

  /**
   * 跳转到应用市场app详情界面
   *
   * @param appPkg App的包名
   * @param marketPkg 应用市场包名
   */
  public static void launchAppDetail(Context context, String appPkg, String marketPkg) {
    try {
      if (TextUtils.isEmpty(appPkg)) return;
      Uri uri = Uri.parse("market://details?id=" + appPkg);
      Intent intent = new Intent(Intent.ACTION_VIEW, uri);
      if (!TextUtils.isEmpty(marketPkg)) {
        intent.setPackage(marketPkg);
      }
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      context.startActivity(intent);
    } catch (Exception e) {
      toMarketList(context);
    }
  }

  private static void toMarketList(Context context) {
    try {
      Uri uri = Uri.parse("market://details?id=" + SystemUtils.getPackageName(context));
      Intent intent = new Intent(Intent.ACTION_VIEW, uri);
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      context.startActivity(intent);
    } catch (Exception e) {
    }
  }
}
