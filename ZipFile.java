import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFile {

    public static void main(String[] args) throws IOException {
        String fileName = "test1.txt";

        FileOutputStream fos = new FileOutputStream("compressed.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);

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

        zipOut.close();
        fos.close();
    }
}