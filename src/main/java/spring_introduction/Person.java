package spring_introduction;
/**
 * Класс "Person" зависит от "Pay" и содержит в себе:
 * - способ с помощью которого человек может произвести оплату;
 * */
public class Person {
    private Pay pay;

    public Person(Pay pay) {
        this.pay = pay;
    }

    public void yourPay(){
        System.out.println("Способ оплаты:");
        pay.pay();
    }
}