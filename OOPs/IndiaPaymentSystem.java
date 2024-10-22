package OOPs;

public class IndiaPaymentSystem implements Payment { //implements and overrides Payment interface's method, can have its own method too
    @Override
    public void pay() {
        System.out.println("I am in IndianPaymentSystem");
    }

    public void hiFromIndia(){ //this class has other methods
        System.out.println("Hi from IndiaPaymentSystem");
    }

}
