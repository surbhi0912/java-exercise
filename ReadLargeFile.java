import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

//optimised as we don't keep the entire large file in memory
public class ReadLargeFile {

    public static void main(String[] args) {
        FileInputStream fis = null;
        Scanner sc = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            long memoryMax = runtime.maxMemory();

            fis = new FileInputStream("largeFileRaw.txt");
            sc = new Scanner(fis, "UTF-8");

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
//                System.out.println(line);
            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }

            long memoryUsed = runtime.totalMemory() - runtime.freeMemory();
            double memoryUsedPercent = (memoryUsed * 100.0) / memoryMax;
            System.out.println("memoryUsedPercent: " + memoryUsedPercent);
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
