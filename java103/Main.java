package java103;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(10); //class that has 10 threads, so it can be assigned 10 tasks
        CallableCalculator c1 = new CallableCalculator(10, 15);
        Future<Integer> future1 = executor.submit(c1); //assigning a task to one worker thread


        CallableCalculator c2 = new CallableCalculator(145, 15);
        Future<Integer> future2 = executor.submit(c2); //assigning a task to one worker thread

        //when we do future.get(), then program counter stops to fetch the result and it does not move ahead till result is fetched
        Integer result2 = future2.get();

        Integer result1 = future1.get();
        System.out.println("Result :: "+result1);

        System.out.println("Result :: "+result2);
    }
}
