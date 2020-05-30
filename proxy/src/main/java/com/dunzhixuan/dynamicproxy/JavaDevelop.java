package com.dunzhixuan.dynamicproxy;

public class JavaDevelop implements Develop{
	@Override
	public void makeCode() {
		System.out.println("makeCode");
	}

	@Override
	public void debug() {
		System.out.println("debug");
	}
}
