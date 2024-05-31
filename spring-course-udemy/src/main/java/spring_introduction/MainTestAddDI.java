package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Класс предназначенный для проведения "опытов"
 * */
public class MainTestAddDI {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Pay pay = context.getBean("payAlphaBank", Pay.class);

        Person person = new Person(pay);
        person.yourPay();

        context.close();
    }
}