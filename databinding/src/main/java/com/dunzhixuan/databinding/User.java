package com.dunzhixuan.databinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

public class User extends BaseObservable {

	private String name;

	@Bindable//public 修饰的字段直接在字段上加该注解
	public int age;

	public String value = "dzx";

	public ObservableField<String> nickname2 = new ObservableField<>();
	public String nickname;

	public void setAge(int age) {
		notifyChange();//更新全部的值域
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
		notifyPropertyChanged(BR.name);//只更新BR对应的flage，该 BR 的生成通过注释 @Bindable 生成，可以通过 BR notify 特定属性关联的视图
	}

	@Bindable//private 修饰的字段在get方法上加该注解
	public String getName() {
		return name;
	}
}
