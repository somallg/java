package com.somallg.spring.core.ch7.proxyfactorybean;

public class MyDependency {

    public void foo() {
        System.out.println("foo()");
    }

    public void foo(int i) {
        System.out.println("foo(int)");
    }

    public void foo(String s) {
        System.out.printf("foo(String)");
    }

    public void bar() {
        System.out.println("bar()");
    }

}
