package ss17_io_binary_file_serialization.bai_tap.copy_binary_file;

import java.io.*;

public class CopyBinaryFile {
    public static void main(String[] args) {
        File source = new File("src\\ss17_io_binary_file_serialization\\bai_tap\\copy_binary_file\\source.csv");
        File target = new File("src\\ss17_io_binary_file_serialization\\bai_tap\\copy_binary_file\\target.csv");
        if (!source.exists()) {
            System.out.println("Source file not found.");
        } else if (target.exists()) {
            System.out.println("Target file is exist.");
        } else {
            int count = 0;
            try (FileInputStream inputStream = new FileInputStream(source);
                 BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                 FileOutputStream outputStream = new FileOutputStream(target);
                 BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = bufferedInputStream.read(buffer)) > 0) {
                    bufferedOutputStream.write(buffer, 0, length);
                    count++;
                }
                System.out.println("Number of bytes used: " + count + " byte.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
