package java103;

//Extending thread class
//public class HelloWordFromThread_Assignment1 extends Thread{
//    public void run(){
//        System.out.println("Hello World from class extending Thread class");
//    }
//    public static void main(String[] args) {
//        HelloWordFromThread_Assignment1 t = new HelloWordFromThread_Assignment1();
//        t.start();
//    }
//}

//Implementing runnable interface
//public class HelloWordFromThread_Assignment1 implements Runnable{
//    public void run(){
//        System.out.println("Hello World from class implementing Runnable interface");
//    }
//    public static void main(String[] args) {
//        Thread t = new Thread(new HelloWordFromThread_Assignment1());
//        t.start();
//    }
//}

//Multithreading
//public class HelloWordFromThread_Assignment1 implements Runnable{
//    public static void main(String[] args) {
//        Thread t1 = new Thread(new HelloWordFromThread_Assignment1(), "Demo1");
//        t1.start();
//        Thread t2 = new Thread(new HelloWordFromThread_Assignment1(), "Demo2");
//        t2.start();
//        System.out.println("Thread names : " + t1.getName() + "," + t2.getName());
//    }
//
//    @Override
//    public void run(){
//        System.out.println("Thread output by overriding run");
//    }
//}