package adventOfCode.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {

    static final String fileName = "./adventOfCode/src/test/resources/testdata.csv";

    public static List<String> read() throws IOException {

        List<String> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values[0]);
            }
        }
        return data;
    }

    public static void main(String[] args) throws IOException {

        System.out.println(ReadCSV.read().size());
        System.out.println(ReadCSV.read());
    }
}
