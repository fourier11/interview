import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class UnzipFiles {
    public static void main(String[] args) {
        String zipFilePath = "test.zip";
        String uncompressedDirectory = "uncompressed/";
        long startTime = System.currentTimeMillis();
        unzipFiles(zipFilePath, uncompressedDirectory);
        System.out.println("unzip3 time cost: " + (System.currentTimeMillis() - startTime));
    }

    public static void unzipFiles(String zipFilePath, String uncompressedDirectory) {
        try (ZipFile file = new ZipFile(zipFilePath)) {
            FileSystem fileSystem = FileSystems.getDefault();
            // Get file entries
            Enumeration<? extends ZipEntry> entries = file.entries();

            Files.createDirectory(fileSystem.getPath(uncompressedDirectory));

            // Iterate over entries
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                if (entry.isDirectory()) {
                    System.out.println("Creating Directory:" + uncompressedDirectory + entry.getName());
                    Files.createDirectories(fileSystem.getPath(uncompressedDirectory + entry.getName()));
                } else {
                    InputStream is = file.getInputStream(entry);
                    BufferedInputStream bis = new BufferedInputStream(is);
                    String uncompressedFileName = uncompressedDirectory + entry.getName();
                    Path uncompressedFilePath = fileSystem.getPath(uncompressedFileName);
                    Files.createFile(uncompressedFilePath);
                    FileOutputStream fileOutput = new FileOutputStream(uncompressedFileName);
                    byte[] bytes = new byte[4096];
                    int length;
                    while ((length = bis.read(bytes)) >= 0) {
                        fileOutput.write(bytes, 0, length);
                    }
                    fileOutput.close();
                    System.out.println("Written :" + entry.getName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}