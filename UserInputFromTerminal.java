import java.util.Scanner;

public class UserInputFromTerminal {
    public static void main(String[] args) {
        User user = new User();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
//        String name = sc.nextLine();
//        user.setName(name);
        user.setName(sc.nextLine());

        System.out.println("Enter age");
//        int age = sc.nextInt();
//        user.setAge(age);
        user.setAge(sc.nextInt());

        sc.close();

        System.out.println("The entered user name is : " + user.getName() + " and the age is " + user.getAge());

    }
}
