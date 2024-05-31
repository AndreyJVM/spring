package spring_introduction;

/**
 * Класс представляющий Альфа банк
 */
public class AlphaBank implements Pay {
    @Override
    public void pay(){
        System.out.println("Оплачено картой Альфа банка");
    }
}
