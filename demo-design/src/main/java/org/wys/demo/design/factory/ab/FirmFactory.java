package org.wys.demo.design.factory.ab;

import org.wys.demo.design.factory.simple.Phone;

/**
 * @author wys
 * @date 2020/11/16 2:41 下午
 */
public interface FirmFactory {

    Phone createPhone();

    NoteBook createNoteBook();

}
