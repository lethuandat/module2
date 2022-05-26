package ss16_io_text_file.bai_tap.doc_file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCSV {
    public static void main(String[] args) {
        File file = new File("src\\ss16_io_text_file\\bai_tap\\doc_file_csv\\countries.csv");
        List<String[]> list = new ArrayList<>();
        List<Country> countryList = new ArrayList<>();
        if (!file.exists()) {
            System.out.println("File is not exists.");
        } else {
            String line;
            String[] arr;
            try (FileReader fileReader = new FileReader(file);
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {

                while ((line = bufferedReader.readLine()) != null) {
                    arr = line.split(",");
                    list.add(arr);
                }

                for (String[] item : list) {
                    Country country = new Country(Integer.parseInt(item[0]), item[1], item[2]);
                    countryList.add(country);
                }

                System.out.println("List of countries: ");
                for (Country country : countryList) {
                    System.out.println(country);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
