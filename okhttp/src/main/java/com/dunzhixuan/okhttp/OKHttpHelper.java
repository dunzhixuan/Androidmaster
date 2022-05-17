package com.dunzhixuan.okhttp;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OKHttpHelper {

	private static final String TAG = "OKHttpHelper";

	public void get(){
		String url = "http://wwww.baidu.com";
		OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
		OkHttpClient okHttpClient = builder.addInterceptor(new Interceptor() {
			@Override
			public Response intercept(@NotNull Chain chain) throws IOException {
				return chain.proceed(chain.request());
			}
		}).build();

		final Request request = new Request.Builder()
						.url(url)
						.get()//默认就是GET请求，可以不写
						.build();
		Call call = okHttpClient.newCall(request);
		//异步请求回调onResponse方法是在子线程中
		call.enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				Log.d(TAG, "onFailure: ");
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				Log.d(TAG, "onResponse: " + response.body().string());
			}
		});

		//同步请求--主线程请求
		try {
			Response response = call.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void postString(){
		MediaType mediaType = MediaType.parse("text/x-markdown; charset=utf-8");
		String requestBody = "I am Jdqm.";
		Request request = new Request.Builder()
						.url("https://api.github.com/markdown/raw")
						.post(RequestBody.create(mediaType, requestBody))
						.build();
		OkHttpClient okHttpClient = new OkHttpClient();
		okHttpClient.newCall(request).enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				Log.d(TAG, "onFailure: " + e.getMessage());
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				Log.d(TAG, response.protocol() + " " +response.code() + " " + response.message());
				Headers headers = response.headers();
				for (int i = 0; i < headers.size(); i++) {
					Log.d(TAG, headers.name(i) + ":" + headers.value(i));
				}
				Log.d(TAG, "onResponse: " + response.body().string());
			}
		});

	}
}
