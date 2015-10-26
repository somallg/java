package java.scjp6.exams.practice.dump;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

    public static void main(String[] args) {
        String s = "&)!{&_&&%@[+f&)#+_(+]%^@+[%%}}&@)($)^i)[^)+{&+](+@^*^%_}!{{}_+$@#]Z*%#%!}*$}_+}(}(U]_^h@*+@])@{!##@^^#(^W@}{$$((@^]+[&#$#_}*+!)%%Q{))&@&((&)]{{&*()_%[}#}}#(}^&&(@^b&^](!](+&&Q^!@][{+{}!(!![&+#_]+_#[a{%#@#+)_]^{@*@_)_@[)_]$(]@+}!{@y*{K[&#+#+@&%($#@_[$(#!{!&}&!&@&!{)(@+${]]^[@)+!&&#(}!(_[[@}+@+^+#[][]$_{*+}+^!{*#";
        Pattern p = Pattern.compile("[a-zA-Z0-9]");
        Matcher m = p.matcher(s);

        StringBuilder res = new StringBuilder();
        while (m.find())
            res.append(m.group());

        System.out.println(res);
    }

}
