package adventOfCode.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {

    static final String fileName = "./adventOfCode/src/test/resources/testdata3.csv";

    public static List<String> readOne() throws IOException {

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

    public static List<String[]> readTwo() throws IOException {

        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
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

        List<String> date = readOne();
        System.out.println(date);
    }
}
