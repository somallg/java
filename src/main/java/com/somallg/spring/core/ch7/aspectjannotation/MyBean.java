package com.somallg.spring.core.ch7.aspectjannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {

    private MyDependency dep;

    public void execute() {
        dep.foo();
        dep.bar();
        dep.foo(123);
        dep.foo("Hello Lala");
    }

    @Autowired
    public void setDep(MyDependency dep) {
        this.dep = dep;
    }

}
