import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDirectory {
    public static void createDummyFiles() throws IOException {
        Files.createDirectories(Paths.get("/Users/20036609/projects-personal/java-exercise/test2/test3/test4/test5/"));
        Files.write(Paths.get("/Users/20036609/projects-personal/java-exercise/test2/test2.log"), "hello".getBytes());
        Files.write(Paths.get("/Users/20036609/projects-personal/java-exercise/test2/test3/test3.log"), "hello".getBytes());
    }
    public static void main(String[] args) throws IOException {
        createDummyFiles();

        String sourceDir = "test2";

        FileOutputStream fos = new FileOutputStream("dirCompressed.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);

        File fileToZip = new File(sourceDir);
        zipFile(fileToZip, fileToZip.getName(), zipOut);

        zipOut.close();
        fos.close();
    }

    private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }

        //if fileToZip is a directory
        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("/") == false) {
                fileName = fileName + "/";
            }
            zipOut.putNextEntry(new ZipEntry(fileName));
            zipOut.closeEntry();

            File[] children = fileToZip.listFiles();
            for (File childFile : children) {
                zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
            }
            return;
        }

        //if fileToZip is not a directory
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        fis.close();
    }
}
