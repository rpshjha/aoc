package adventOfCode.challenge;

import adventOfCode.utils.FileReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Day2RockPaperScissor {

    static String filename = "testdata2.csv";


    public static void main(String[] args) throws IOException {


        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);//rock
        map.put("B", 2);//paper
        map.put("C", 3);//scissors
        map.put("X", 1);//rock
        map.put("Y", 2);//paper
        map.put("Z", 3);//scissors

        List<String> data = FileReader.readCSV(filename);

        System.out.println("size of data isx " + data.size());

        long myScore = 0;

        for (String a : data) {

            String opChoice = a.split(" ")[0];
            String myChoice = a.split(" ")[1];

            int opShape = map.get(opChoice);
            int myShape = map.get(myChoice);

            if (opShape > myShape) {
                myScore += myShape;
            } else if (myShape > opShape) {
                myScore += 6 + myShape;
            } else {
                myScore += 3 + myShape;
            }

        }

        System.out.println("myself point is " + myScore);


    }

}
