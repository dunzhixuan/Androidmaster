package com.dzx.app.retorfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
  public static final String BaseURL = "https://fanyi.youdao.com/";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    call();
  }

  private void call() {
    Retrofit retrofit =
        new Retrofit.Builder()
            .baseUrl(BaseURL)
//          .client()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

    GetRequestInterface request = retrofit.create(GetRequestInterface.class);
    // ---普通网络请求---
    Call<ResponseBody> call = request.getCall("");
    call.enqueue(
        new Callback<ResponseBody>() {
          @Override
          public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {}

          @Override
          public void onFailure(Call<ResponseBody> call, Throwable t) {}
        });

    // ---RxJava网络请求---
    Observable<ResponseBody> observable = request.getObservableCall();
    observable
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            new Observer<ResponseBody>() {
              @Override
              public void onSubscribe(Disposable d) {}

              @Override
              public void onNext(ResponseBody responseBody) {}

              @Override
              public void onError(Throwable e) {}

              @Override
              public void onComplete() {}
            });
  }

}
