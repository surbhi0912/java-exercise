import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

public class CreateFile {
    public static void main(String[] args) {
        try {
            File myFile = new File("firstFile.txt"); //eg pathname for Mac : "/Users/20036609/firstFile.txt"
            if (myFile.createNewFile()) { //createNewFile() returns true if file is successfully created
                System.out.println("File created: " + myFile.getName());
            } else { //createNewFile() returns false if file already exists
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}