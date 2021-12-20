package org.wys.demo.design.factory.ab;

import org.wys.demo.design.factory.simple.Iphone;
import org.wys.demo.design.factory.simple.Phone;

/**
 * @author wys
 * @date 2020/11/16 3:18 下午
 */
public class AppleFactory implements FirmFactory {


    @Override
    public Phone createPhone() {
        return new Iphone();
    }

    @Override
    public NoteBook createNoteBook() {
        return new AppleNoteBook();
    }
}
