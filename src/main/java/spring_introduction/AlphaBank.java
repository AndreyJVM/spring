package spring_introduction;

public class AlphaBank implements Pay {
    @Override
    public void pay(){
        System.out.println("Оплачено картой Альфа банка");
    }
}
