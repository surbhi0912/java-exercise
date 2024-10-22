package OOPs;

public class StaticExample {
    public static void main(String[] args) {
        IndiaPaymentSystem p = new IndiaPaymentSystem(); //can create object p of non-static class IndiaPaymentSystem
        p.pay();

        ExperimentClass obj = new ExperimentClass(); //can create an object of ExperimentClass only if it is static
        obj.subtract(); //and add method does not need to be static

        //can directly call add method without an object if add method is static, the class it is defined inside need not be static
//        ExperimentClass.add();
    }

    static class ExperimentClass{
        static void add(){
            System.out.println("Inside add");
        }

        void subtract(){//this is non-static method
            System.out.println("Inside subtract");
            add();//so it can call static method
        }


    }
}

