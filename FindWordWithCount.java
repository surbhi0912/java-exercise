import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindWordWithCount {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in); //to read the word to be found
            System.out.println("Enter the word to be found : ");
            String word = sc.next();
            boolean wordFound = false;
            int wordCount = 0;
            //to read contents of the file
            Scanner myReader = new Scanner(new FileInputStream("firstFile.txt"));
            while (myReader.hasNextLine()) {
                String fileLine = myReader.nextLine();
                System.out.println(fileLine);
                String s = fileLine;
                s = s.replaceAll("[^a-zA-Z0-9]", " ");
                String[] lineWords = s.split(" ");
                for(String w : lineWords){
                    if(w.equals(word)){
                        wordFound = true;
                        wordCount++;
                    }
                }
            }
            if(wordFound){
                System.out.println("File contains the word " + word + " " + wordCount + " times.");
            } else{
                System.out.println("File does not contain the word " + word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}