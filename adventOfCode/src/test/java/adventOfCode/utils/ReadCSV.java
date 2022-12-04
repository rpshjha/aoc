package adventOfCode.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {

    static final String filePath = "./adventOfCode/src/test/resources/";

    public static List<String> read(String fileName) throws IOException {

        List<String> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath + fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values[0]);
            }
        }
        return data;
    }

    public static List<String[]> readAllCoulumn(String fileName) throws IOException {

        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath + fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        }
        return data;
    }

    public static void main(String[] args) throws IOException {

//        System.out.println(ReadCSV.readTwo().size());
//        for(String[] temp : readTwo()){
//            for(String a : temp){
//                System.out.print(a);
//            }
//            System.out.println();
//        }

        String filename = "testdata2.csv";
        List<String> date = read(filename);
        System.out.println(date);
    }
}
