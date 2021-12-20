package org.wys.demo.design.factory.ab;

/**
 * @author wys
 * @date 2020/11/16 2:52 下午
 */
public class Main {
    public static void main(String[] args) {
        FirmFactory mi = new MiFactory();
        mi.createPhone().getName();
        mi.createNoteBook().getName();

        FirmFactory apple = new AppleFactory();
        apple.createNoteBook().getName();
        apple.createPhone().getName();
    }
}
