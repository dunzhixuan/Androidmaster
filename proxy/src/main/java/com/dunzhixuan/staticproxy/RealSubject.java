package com.dunzhixuan.staticproxy;

public class RealSubject implements Subject{
	@Override
	public void makeSubject() {
		System.out.println("aaa");
	}
}
