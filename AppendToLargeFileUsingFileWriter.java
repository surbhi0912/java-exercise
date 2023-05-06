import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppendToLargeFileUsingFileWriter {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        long memoryMax = runtime.maxMemory();

        File myLargeFile = new File("largeFileBuffered.txt");
        try {
            FileWriter myWriter = new FileWriter(myLargeFile, true);
            String dataToAppend = "Appending new data";
            myWriter.write(dataToAppend + "\n");
            myWriter.close();

            long memoryUsed = runtime.totalMemory() - runtime.freeMemory();
            double memoryUsedPercent = (memoryUsed * 100.0) / memoryMax;
            System.out.println("memoryUsedPercent: " + memoryUsedPercent);
        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
}
