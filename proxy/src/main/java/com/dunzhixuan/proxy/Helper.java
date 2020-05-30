package com.dunzhixuan.proxy;

import com.dunzhixuan.dynamicproxy.Develop;
import com.dunzhixuan.dynamicproxy.JavaDevelop;
import com.dunzhixuan.staticproxy.SubjectProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Helper {

  public static void main(String[] args) {
    // 静态代理
    SubjectProxy subjectProxy = new SubjectProxy();
    subjectProxy.makeSubject();

    // 动态代理
    final JavaDevelop dzx = new JavaDevelop();
    final Develop dzxProxy =
        (Develop)
            Proxy.newProxyInstance(
                dzx.getClass().getClassLoader(),
                dzx.getClass().getInterfaces(),
                new InvocationHandler() {
                  @Override
                  public Object invoke(Object proxy, Method method, Object[] args)
                      throws Throwable {
                    if ("makeCode".equals(method.getName())) {
                      System.out.println("preMakeCode");
                      return method.invoke(dzx, args);
                    }
                    if ("debug".equals(method.getName())) {
                      System.out.println("preDebug");
                      return method.invoke(dzx, args);
                    }
                    return null;
                  }
                });

    dzxProxy.makeCode();
    dzxProxy.debug();
  }
}
