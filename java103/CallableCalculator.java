package java103;

import java.util.concurrent.Callable;

public class CallableCalculator implements Callable {
    private int a, b;

    public CallableCalculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(" A is "+a);
        Thread.sleep(10000);
        return this.a + this.b;
    }
}
