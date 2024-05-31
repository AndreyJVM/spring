package spring_introduction;

public class PayPal implements Pay {
    @Override
    public void pay(){
        System.out.println("Оплачено через PayPal");
    }
}
