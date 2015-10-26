package com.somallg.spring.core.ch7.aspectjannotation;

import org.springframework.stereotype.Component;

@Component("myDependency")
public class MyDependency {

    public void foo() {
        System.out.println("foo()");
        foo("call foo String indirectly");
    }

    public void foo(int i) {
        System.out.println("foo(int) " + i);
    }

    public void foo(String s) {
        System.out.println("foo(string) " + s);
    }

    public void bar() {
        System.out.println("bar()");
    }

}
