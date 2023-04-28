import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {
    public static void main(String[] args) {
        try {
            File myFile = new File("firstFile.txt");
            Scanner myReader = new Scanner(myFile);
            System.out.println("File contents are :");
            while (myReader.hasNextLine()) {
                String fileLine = myReader.nextLine();
                System.out.println(fileLine);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}