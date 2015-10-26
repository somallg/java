package com.somallg.spring.core.ch7.aopnamespace;

public class MyBean {

    private MyDependency dep;

    public void execute() {
        dep.foo();
        dep.bar();
        dep.foo(123);
        dep.foo("Hello Lala");
    }

    public void setDep(MyDependency dep) {
        this.dep = dep;
    }

}
