import java.util.HashMap;
import java.util.Scanner;

public class UserHashMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, User> userHashMap = new HashMap<String, User>();
        User user1 = new User("Alex", 28, "12345");
        User user2 = new User("Bob", 92, "67890");
        User user3 = new User("Thomas", 77, "90123");
        userHashMap.put(user1.getPhoneNumber(), user1);
        userHashMap.put(user2.getPhoneNumber(), user2);
        userHashMap.put(user3.getPhoneNumber(), user3);

        System.out.println("Enter phone number for which you want user details : ");
        String phone = sc.nextLine();
        sc.close();

        //retrieve user value from HashMap for the phone key
        User user = userHashMap.get(phone);
        if(user == null){
            System.out.println("No user exists for given phone number");
        }
        else {
            System.out.println("User details for the phone number are - " + "Name : " + user.getName() + ", " + "Age : " + user.getAge() +
                    ", " + "Phone Number : " + user.getPhoneNumber());
        }
    }
}
