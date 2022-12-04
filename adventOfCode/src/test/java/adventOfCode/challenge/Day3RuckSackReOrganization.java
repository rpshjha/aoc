package adventOfCode.challenge;

import adventOfCode.utils.ReadCSV;
import adventOfCode.utils.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day3RuckSackReOrganization {

    static String filename = "testdata3.csv";

    public static void main(String[] args) throws IOException {

        List<String> data = ReadCSV.read(filename);

        int totalPriority = 0;

        //part 1
        totalPriority = partOne(data, totalPriority);

        // part 2
        totalPriority = partTwo(data, totalPriority);

        System.out.println("total priority is " + totalPriority);
    }

    private static int partTwo(List<String> data, int totalPriority) {
        for (int i = 0; i < data.size(); i += 3) {

            String[] temp = new String[]{data.get(i), data.get(i + 1), data.get(i + 2)};

            for (String tem : temp) {
                System.out.println("fi " + tem);
            }
            totalPriority += getTotalPriorityFromRucksack(temp);
        }
        return totalPriority;
    }

    private static int partOne(List<String> data, int totalPriority) {
        for (String currentRucksack : data) {

            totalPriority += getTotalPriorityFromRucksack(currentRucksack);
        }
        return totalPriority;
    }

    private static int getTotalPriorityFromRucksack(String[] temp) {
        String chars = StringUtils.findCommonString(temp);
        System.out.println("cha    " + chars);
        String common = String.valueOf(chars);

        int totalPriority = 0;
        for (Character c : common.toCharArray()) {
            int priority = getPriority(String.valueOf(c));

            totalPriority += priority;
        }

        System.out.println("priority for " + temp + " is " + totalPriority);
        return totalPriority;
    }

    private static int getTotalPriorityFromRucksack(String temp) {
        int midLen = temp.length() / 2;
        String first = temp.substring(0, midLen);
        String second = temp.substring(midLen);

        String common = StringUtils.findCommonString(first, second);

        int totalPriority = 0;
        for (Character c : common.toCharArray()) {
            int priority = getPriority(String.valueOf(c));

            totalPriority += priority;
        }

        System.out.println("priority for " + temp + " is " + totalPriority);
        return totalPriority;
    }


    private static Integer getPriority(String character) {
        Map<String, Integer> priority = new HashMap<>();
        priority.put("a", 1);
        priority.put("b", 2);
        priority.put("c", 3);
        priority.put("d", 4);
        priority.put("e", 5);
        priority.put("f", 6);
        priority.put("g", 7);
        priority.put("h", 8);
        priority.put("i", 9);
        priority.put("j", 10);
        priority.put("k", 11);
        priority.put("l", 12);
        priority.put("m", 13);
        priority.put("n", 14);
        priority.put("o", 15);
        priority.put("p", 16);
        priority.put("q", 17);
        priority.put("r", 18);
        priority.put("s", 19);
        priority.put("t", 20);
        priority.put("u", 21);
        priority.put("v", 22);
        priority.put("w", 23);
        priority.put("x", 24);
        priority.put("y", 25);
        priority.put("z", 26);
        priority.put("A", 27);
        priority.put("B", 28);
        priority.put("C", 29);
        priority.put("D", 30);
        priority.put("E", 31);
        priority.put("F", 32);
        priority.put("G", 33);
        priority.put("H", 34);
        priority.put("I", 35);
        priority.put("J", 36);
        priority.put("K", 37);
        priority.put("L", 38);
        priority.put("M", 39);
        priority.put("N", 40);
        priority.put("O", 41);
        priority.put("P", 42);
        priority.put("Q", 43);
        priority.put("R", 44);
        priority.put("S", 45);
        priority.put("T", 46);
        priority.put("U", 47);
        priority.put("V", 48);
        priority.put("W", 49);
        priority.put("X", 50);
        priority.put("Y", 51);
        priority.put("Z", 52);
        return priority.get(character);
    }

}
