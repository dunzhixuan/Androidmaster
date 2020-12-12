package com.dzx.app.retorfit;

import android.security.identity.ResultData;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetRequestInterface {
    @GET("openapi.do?keyfrom=Yanzhikai&key=2032414398&type=data&doctype=json&version=1.1&q=car")
    Call<ResponseBody> getCall(@Query("d") String d);

    @GET("openapi.do?keyfrom=Yanzhikai&key=2032414398&type=data&doctype=json&version=1.1&q=car")
    Observable<ResponseBody> getObservableCall();

    @GET("openapi.do?keyfrom=Yanzhikai&key=2032414398&type=data&doctype=json&version=1.1&q=car")
    Call<ResponseBody> getItem(@Query("student") String student, @Query("type") String type);

}
