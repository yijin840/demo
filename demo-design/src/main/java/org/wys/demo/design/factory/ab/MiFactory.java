package org.wys.demo.design.factory.ab;

import org.wys.demo.design.factory.simple.MiPhone;
import org.wys.demo.design.factory.simple.Phone;

/**
 * @author wys
 * @date 2020/11/16 3:23 下午
 */
public class MiFactory implements FirmFactory{


    @Override
    public Phone createPhone() {
        return new MiPhone();
    }

    @Override
    public NoteBook createNoteBook() {
        return new MiNoteBook();
    }
}
