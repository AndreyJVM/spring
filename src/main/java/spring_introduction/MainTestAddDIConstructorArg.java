package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Класс предназначенный для проведения "опытов"
 * */
public class MainTestAddDIConstructorArg {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Person person = context.getBean("person", Person.class);
        System.out.println("Name - "+person.getName());
        System.out.println("Age - "+person.getAge());
        person.yourPay();

        context.close();
    }
}
