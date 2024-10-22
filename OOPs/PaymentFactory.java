package OOPs;

//This is known as factory design pattern
public class PaymentFactory {
    public static void doPayment(String country){
        Payment payment = null; //since IndiaPaymentSystem and KoreaPaymentSystem implement Payment interface, this is how we can create its instance
        switch(country){
            case "India":
                payment = new IndiaPaymentSystem();
                payment.pay();
                break;
            case "Korea":
                payment = new KoreaPaymentSystem();
                payment.pay();
                break;
        }
    }
}
