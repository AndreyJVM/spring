package spring_introduction;
/**
 * Класс "Person" зависит от "Pay" и содержит в себе:
 * - способ с помощью которого человек может произвести оплату;
 * */
public class Person {
    private Pay pay;
    private String name;
    private byte age;

    public Person(Pay pay) {
        this.pay = pay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public void yourPay(){
        System.out.println("Способ оплаты:");
        pay.pay();
    }
}