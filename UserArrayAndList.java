import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class UserArrayAndList {
    public static void main(String[] args) {
        User user1 = new User("Alex", 28, "12345");
        User user2 = new User("Bob", 92, "67890");
        User user3 = new User("Thomas", 77, "90123");
        User user4 = new User();
        user4.setName("Albert");
        user4.setAge(55);
        user4.setPhoneNumber("34567");

        //Array
        User[] userArray = {user1, user2, user3, user4};

        //using for-each loop
        for(User user : userArray){
            System.out.println(user.getName());
        }

        //using for loop
        for(int i = 0; i < userArray.length; i++){
            System.out.println(userArray[i].getName());
        }

        //************************************

        List<User> userList = new ArrayList<>();
        //making list from array elements
        for(User user : userArray) {
            userList.add(user);
        }

        System.out.println("Iterating through list elements");
        //using for-each loop
        for(User user : userList){
            System.out.println("Name is : "+user.getName());
        }

        //using for loop
        for(int i = 0; i < userList.size(); i++){
            System.out.println(userList.get(i).getName());
        }
    }
}
