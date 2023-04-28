import java.io.*;
import java.util.Scanner;

public class ReplaceWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter word to be replaced : ");
        String oldWord = sc.next();
        System.out.println("Enter new word to be replaced : ");
        String newWord = sc.next();
        sc.close();
        BufferedReader myReader = null;
        FileWriter myWriter = null;
        String newContent = "";
        try {
            File myFile = new File("firstFile.txt");
            myReader = new BufferedReader(new FileReader(myFile)); //BufferedReader to read input txt file line by line
            String fileLine = myReader.readLine();
            while (fileLine != null) {//Reading all lines of input txt file into oldContent one by one
                String s = fileLine;
                s = s.replaceAll("[^a-zA-Z0-9]", " ");
                System.out.println(fileLine.length() + " " + s.length());
                String[] lineWords = s.split(" ");
                for(int i = 0; i < lineWords.length; i++){
                    if(lineWords[i].equals(oldWord)){
                        lineWords[i] = newWord;
                    }
                }
                for(String w  : lineWords){
                    newContent = newContent + w + " ";
                }
                newContent = newContent + System.lineSeparator();
                fileLine = myReader.readLine();
            }
            myWriter = new FileWriter(myFile);
            myWriter.write(newContent);
        } catch (IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
        finally{ //finally block is executed whether an exception occurs or not, and if occurs irrespective of whether it is handled or not
            try{
                myReader.close();
                myWriter.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
