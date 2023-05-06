import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadLargeFile {
    public static void main(String[] args) {
        FileInputStream fis = null;
        Scanner sc = null;
        try {
            fis = new FileInputStream("firstFile.txt");
            sc = new Scanner(fis, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }

            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }

        } catch (IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        } finally {
            try{
                if (fis != null) {
                    fis.close();
                }
                if (sc != null) {
                    sc.close();
                }
            } catch (IOException e){
                System.out.println("An error occured");
                e.printStackTrace();
            }
        }
    }
}
