package org.wys.demo.design.decoration.origin;

/**
 * @author wys
 * @date 2020/11/11 2:59 下午
 */
public class AddBigScreenDecorator extends Decorator {

    private final String description = "加了个大屏幕";

    private final Phone phone;

    public AddBigScreenDecorator(Phone phone){
        this.phone = phone;
    }


    @Override
    public String getName() {
        return phone.getName()+description;
    }

    @Override
    public Long getPrice() {
        return this.phone.getPrice()+1000L;
    }


}
