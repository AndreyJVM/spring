package spring_introduction;

public class MainTest {
    public static void main(String[] args) {
        Pay alpha = new PayPal();
        alpha.pay();
        Pay payPal = new AlphaBank();
        payPal.pay();
    }
}
