import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//optimised
public class ReadLargeFileUnoptimised {

    public static void main(String[] args) {
        try {
            Runtime runtime = Runtime.getRuntime();
            long memoryMax = runtime.maxMemory();

            final List<String> lines = Files.readAllLines(Paths.get("largeFile.txt"), StandardCharsets.UTF_8);

            long memoryUsed = runtime.totalMemory() - runtime.freeMemory();
            double memoryUsedPercent = (memoryUsed * 100.0) / memoryMax;
            System.out.println("memoryUsedPercent: " + memoryUsedPercent);

        } catch (IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
}
