package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
* Класс предназначенный для проведения "опытов"
* */
public class MainTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Pay payAlphaBank = context.getBean("payAlphaBank", Pay.class);
        payAlphaBank.pay();

        // закрываем context
        context.close();
    }
}