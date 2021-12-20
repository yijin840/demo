package org.wys.demo.design.decoration;

/**
 * @author wys
 * @date 2021/7/19
 */
public class Main {

    public static void main(String[] args) {
        Mobile iphone = new IphoneMobile();
        Mobile miPhone = new MiMobile();

        System.out.println(iphone.getName() + ", 总共"+ iphone.getPrice());
        System.out.println(miPhone.getName() + ", 总共"+ miPhone.getPrice());

        Mobile iPhoneScreen = new Screen(iphone);
        Mobile miPhoneScreen = new Screen(miPhone);

        System.out.println(iPhoneScreen.getName() + ", 总共"+ iPhoneScreen.getPrice());
        System.out.println(miPhoneScreen.getName() + ", 总共"+ miPhoneScreen.getPrice());

        Mobile iPhoneBattery = new Battery(iPhoneScreen);
        Mobile miPhoneBattery = new Battery(miPhoneScreen);

        System.out.println(iPhoneBattery.getName() + ", 总共"+ iPhoneBattery.getPrice());
        System.out.println(miPhoneBattery.getName() + ", 总共"+ miPhoneBattery.getPrice());

    }
}
