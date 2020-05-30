package com.dunzhixuan.staticproxy;

public class SubjectProxy implements Subject{

	private RealSubject realSubject;

	@Override
	public void makeSubject() {
		if (realSubject == null) realSubject = new RealSubject();
		preSubject();
		realSubject.makeSubject();
		postSubject();
	}

	private void preSubject(){
		System.out.println("pre");
	}

	private void postSubject(){
		System.out.println("post");
	}
}
