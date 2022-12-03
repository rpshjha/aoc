package adventOfCode.challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class Day2CodeRockPaper {
    public static Map<String, Integer> test = Map.of(
                                            "A X", 3,
                                            "A Y", 4,
                                            "A Z", 8,
                                            "B X", 1,
                                            "B Y", 5,
                                            "B Z", 9,
                                            "C X", 2,
                                            "C Y", 6,
                                            "C Z", 7
                                            );

    public static int score = 0;
    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(new File("adventOfCode/src/test/resources/input.txt"));
            while(sc.hasNextLine()){
                String line = sc.nextLine();            
                score += test.get(line);
            }   
            sc.close();
            System.out.println(score);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}