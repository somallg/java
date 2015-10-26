package com.somallg.spring.core.ch7.aspectjannotation;

import org.springframework.stereotype.Component;

/**
 * Created by somallg on 11/10/14.
 */

@Component("inputWrapper")
public class InputWrapper {
    private int inputInt;

    private String inputString;

    public int getInputInt() {
        return inputInt;
    }

    public void setInputInt(int inputInt) {
        this.inputInt = inputInt;
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String toString() {
        return "InputWrapper{" +
                "inputInt=" + inputInt +
                ", inputString='" + inputString + '\'' +
                '}';
    }
}
