import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class WriteLargeFileRaw {
    private static final int RECORD_COUNT = 12000000;
    private static final String RECORD = "Help I am trapped in a fortune cookie factory\n";
    private static final int RECSIZE = RECORD.getBytes().length;

    public static void main(String[] args) throws Exception {
        Runtime runtime = Runtime.getRuntime();
        long memoryMax = runtime.maxMemory();

        List<String> records = new ArrayList<String>(RECORD_COUNT);
        int size = 0;
        for (int i = 0; i < RECORD_COUNT; i++) {
            records.add(RECORD);
            size += RECSIZE;
        }

        writeRaw(records);

        long memoryUsed = runtime.totalMemory() - runtime.freeMemory();
        double memoryUsedPercent = (memoryUsed * 100.0) / memoryMax;
        System.out.println("memoryUsedPercent: " + memoryUsedPercent);
    }

    private static void writeRaw(List<String> records) throws IOException {
//        File file = File.createTempFile("largeFileRaw", ".txt");
        File myLargeFile = new File("largeFileRaw.txt");
        try {
            FileWriter writer = new FileWriter(myLargeFile);
            System.out.print("Writing raw... ");
            write(records, writer);
        } finally {
//            comment this out if you want to inspect the files afterward
            myLargeFile.delete();
        }
    }

    private static void write(List<String> records, Writer writer) throws IOException {
//        long start = System.currentTimeMillis();
        for (String record: records) {
            writer.write(record);
        }
        // writer.flush(); // close() should take care of this
        writer.close();
//        long end = System.currentTimeMillis();
//        System.out.println((end - start) / 1000f + " seconds");
    }
}