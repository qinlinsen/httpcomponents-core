package org.apache.http.qinhttp;

import java.lang.reflect.Method;
import java.nio.charset.Charset;

public class Test {
    public static void main(String[] args) throws Exception{
        Class<Charset> charsetClass = Charset.class;

        Method lookup = charsetClass.getDeclaredMethod("lookup", String.class);
        if(! lookup.isAccessible()){
            lookup.setAccessible(true);
        }
        Object renmin = lookup.invoke(null, "renmin");
        System.out.println(renmin);
        Class<?> mathClass = Class.forName("java.lang.Math");
        Method abs = mathClass.getDeclaredMethod("abs", int.class);
        Object a = abs.invoke(null, -3);
        System.out.println("a="+a);
    }
}
