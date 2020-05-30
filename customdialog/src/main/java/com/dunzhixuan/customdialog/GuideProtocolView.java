package com.dunzhixuan.customdialog;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GuideProtocolView extends View {

	private TextView textView1,textView2,textView3,textView4,textView5;

	public GuideProtocolView(Context context) {
		super(context);

		View view = LinearLayout.inflate(context, R.layout.m_guide_protocol_view,null);
		initView(view);
	}

	public GuideProtocolView(Context context, AttributeSet attrs) {
		super(context, attrs);

		View view = LinearLayout.inflate(context, R.layout.m_guide_protocol_view,null);
		initView(view);
	}

	private void initView(View view) {
		textView1 = view.findViewById(R.id.txv_content1);
		textView2 = view.findViewById(R.id.txv_content2);
		textView3 = view.findViewById(R.id.txv_content3);
		textView4 = view.findViewById(R.id.txv_content4);
		textView5 = view.findViewById(R.id.txv_content5);



	}

	/** 用户协议、隐私政策 */
	private void initPrivasy() {
		SpannableString agreementText = new SpannableString("感谢您下载并使用VIPKID应用程序，我们非常重视您的个人信息和隐私保护。在您使用VIPKID产品或服务前，请您仔细阅读、充分理解协议中的条款内容后再点击同意（尤其是以粗体标识的条款，因为这些条款可能会明确您应履行以的义务或对您的权利有所限制）：");
		agreementText.setSpan(
						new ClickableSpan() {

							@Override
							public void updateDrawState(TextPaint ds) {
								super.updateDrawState(ds);
								ds.setColor(Color.parseColor("#666666"));
								ds.setUnderlineText(false); // 不显示下划线
							}

							@Override
							public void onClick(View widget) {}
						},
						0,
						8,
						Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//		agreementText.setSpan(
//						new AgreementSpan(this, UrlConstant.sParentSignupUserAgreement),
//						8,
//						20,
//						Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//		agreementText.setSpan(
//						new AgreementSpan(this, UrlConstant.sParentSignupPrivacyAgreement),
//						20,
//						agreementText.length(),
//						Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

//		textView1.setMovementMethod(LinkMovementMethod.getInstance()); // 不设置没有点击事件
//		textView1.setHighlightColor(Color.TRANSPARENT); // 设置点击后的颜色为透明
		textView1.setText(agreementText);
	}
}
