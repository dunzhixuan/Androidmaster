package com.dunzhixuan.jetpack.complexscene;

import io.reactivex.Observable;

public class HomeNetRepository {

	public static Observable<String> getName() {
		return Observable.just("aaa");
	}

	public static Observable<String> getAge(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Observable.just("10");
	}
}
