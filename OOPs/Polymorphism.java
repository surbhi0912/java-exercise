package OOPs;

public class Polymorphism {
    public static void main(String[] args) {
        //Here even if we take input from user, we know how many parameters we will give,
        //so we know at compile time which method will be called
        //thus overloading is static polymorphism or compile time polymorphism
        System.out.println(add(10, 12));
        System.out.println(add(10, 12, 45));

        //here which method is called depends on the value of the argument that we input - India or Korea
        //So runtime polymorphism
        PaymentFactory.doPayment(args[0]);
        PaymentFactory.doPayment("India");
    }
     static int add(int a, int b){
        return a+b;
    }
    static int add(int a, int b, int c){
        return a+b+c;
    }
}
