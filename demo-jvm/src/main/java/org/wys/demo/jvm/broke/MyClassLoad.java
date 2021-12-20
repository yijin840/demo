package org.wys.demo.jvm.broke;

/**
 * @author wys
 * @date 2021/9/1
 */
public class MyClassLoad extends ClassLoader{

    @Override
    public Class<?> loadClass(java.lang.String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(java.lang.String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
