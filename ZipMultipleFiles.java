import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipMultipleFiles {
    public static void main(String[] args) throws IOException {
        String fileName1 = "test1.txt";
        String fileName2 = "test2.txt";
        final List<String> srcFileNames = Arrays.asList(fileName1, fileName2);

        final FileOutputStream fos = new FileOutputStream("compressedMultiple.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        for(String fileName : srcFileNames){
            File fileToZip = new File(fileName);
            //create this file if it doesn't exist
            if (fileToZip.createNewFile()) { //createNewFile() returns true if file is successfully created
                System.out.println(fileName + " created");
            } else { //createNewFile() returns false if file already exists
                System.out.println(fileName + " already exists.");
            }

            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
        zipOut.close();
        fos.close();
    }
}
