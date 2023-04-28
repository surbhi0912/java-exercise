import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.nextLine();
        System.out.println("Enter age");
        int age = sc.nextInt();
        System.out.println("The entered user name is : " + name + " and the age is "+age);
        sc.close();
    }
}
