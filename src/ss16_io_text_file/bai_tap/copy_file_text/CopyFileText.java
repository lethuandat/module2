package ss16_io_text_file.bai_tap.copy_file_text;

import java.io.*;

public class CopyFileText {
    public static void main(String[] args) {
        File fileSource = new File("src\\ss16_io_text_file\\bai_tap\\copy_file_text\\source.txt");
        File fileTarget = new File("src\\ss16_io_text_file\\bai_tap\\copy_file_text\\target.txt");

        if (!fileSource.exists()) {
            System.out.println("Source file is not exists.");
        } else if (fileTarget.exists()) {
            System.out.println("Target file is exists.");
        } else {
            String line;
            int count = 0;
            try (FileReader fileReader = new FileReader(fileSource);
                 BufferedReader bufferedReader = new BufferedReader(fileReader);
                 FileWriter fileWriter = new FileWriter(fileTarget);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                while ((line = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                    count += line.length();
                }
                bufferedWriter.write("Number of characters: " + count);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
