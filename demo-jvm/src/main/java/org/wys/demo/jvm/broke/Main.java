package org.wys.demo.jvm.broke;

/**
 * @author wys
 * @date 2021/9/1
 */
public class Main {

    public static void main(java.lang.String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        MyClassLoad myClassLoad = new MyClassLoad();
        Class<?> str = myClassLoad.loadClass("org.wys.demo.jvm.broke.String");
        System.out.println(str.getName());

    }
}
