package adventOfCode.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    static final String filePath = "./adventOfCode/src/test/resources/";

    public static List<String> readCSV(String fileName) throws IOException {

        List<String> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(filePath + fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values[0]);
            }
        }
        return data;
    }

    public static List<String[]> readCSVallColumn(String fileName) throws IOException {

        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(filePath + fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        }
        return data;
    }

    public static List<String> readTextFile(String fileName) {
        File file = new File(filePath + fileName);

        BufferedReader reader;
        try {
            reader = new BufferedReader(new java.io.FileReader(file));
        } catch (FileNotFoundException e) {
            System.err.println("File not found!!");
            return null;
        }

        List<String> inputLines = new ArrayList<>();
        try {
            String line;
            while ((line = reader.readLine()) != null)
                inputLines.add(line);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputLines;
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
        List<String> date = readCSV(filename);
        System.out.println(date);

        System.out.println(readTextFile("day6.txt"));
    }
}
