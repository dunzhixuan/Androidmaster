package com.dunzhixuan.toastproblem;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;

/** Created by VIPKID on 2016/3/3. */
public final class ToastUtil {
  /** 自定义view */
  private static TextView view;

  /** 构造函数 */
  private ToastUtil() {}

  /** toast对象 */
  private static Toast toast;

  private static Field sField_TN;
  private static Field sField_TN_Handler;

  static {
    try {
      sField_TN = Toast.class.getDeclaredField("mTN");
      sField_TN.setAccessible(true);
      sField_TN_Handler = sField_TN.getType().getDeclaredField("mHandler");
      sField_TN_Handler.setAccessible(true);
    } catch (Exception e) {
    }
  }

  private static void hook(Toast toast) {
    try {
      Object tn = sField_TN.get(toast);
      Handler preHandler = (Handler) sField_TN_Handler.get(tn);
      sField_TN_Handler.set(tn, new SafelyHandlerWarpper(preHandler));
    } catch (Exception e) {
    }
  }

  /**
   * 获取Toast对象
   *
   * @param con 上下文
   */
  private static void getInstance(Context con) {
    Context applicationContext = con.getApplicationContext();
    if (toast == null && view == null) {
      toast = Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT);
      creatView(con);
      toast.setView(view);
    }
  }

  /**
   * showToast 默认Toast
   *
   * @param context 上下文
   * @param msg 显示信息
   */
  public static void showOriginalToast(Context context, String msg) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      Toast toast = Toast.makeText(context.getApplicationContext(), "", Toast.LENGTH_SHORT);
      if (view == null) creatView(context);
      toast.setView(view);
      view.setText(msg);
      hook(toast);
      toast.show();
      return;
    }
    try {
      getInstance(context);
    } catch (IllegalStateException e) {
      // empty
    }
    view.setText(msg);
    hook(toast);
    toast.show();
  }

  /**
   * 居中Toast
   *
   * @param context 上下文
   * @param msg 显示信息
   */
  public static void showCenterToast(Context context, String msg) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      Toast toast = Toast.makeText(context.getApplicationContext(), "", Toast.LENGTH_SHORT);
      if (view == null) creatView(context);
      toast.setView(view);
      view.setText(msg);
      toast.setGravity(Gravity.CENTER, 0, 0);
      toast.show();
      return;
    }
    try {
      getInstance(context);
    } catch (IllegalStateException e) {
      // empty
    }
    view.setText(msg);
    toast.setGravity(Gravity.CENTER, 0, 0);
    hook(toast);
    toast.show();
  }

  private static void creatView(Context context) {
    view = new TextView(context.getApplicationContext());
    view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
    view.setBackgroundResource(R.drawable.lib_utils_round_rect_toast_shape);
    int paddingTopOrBottom =
        (int)
            context
                .getApplicationContext()
                .getResources()
                .getDimension(R.dimen.lib_utils_round_rect_toast_padding_top_bottom);
    int paddingLeftOrRight =
        (int)
            context
                .getApplicationContext()
                .getResources()
                .getDimension(R.dimen.lib_utils_round_rect_toast_padding_left_right);
    view.setPadding(paddingLeftOrRight, paddingTopOrBottom, paddingLeftOrRight, paddingTopOrBottom);
    view.setTextColor(
        context
            .getApplicationContext()
            .getResources()
            .getColor(R.color.lib_utils_round_rect_toast_text_color));
  }


}
