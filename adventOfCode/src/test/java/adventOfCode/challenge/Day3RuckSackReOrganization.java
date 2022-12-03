package adventOfCode.challenge;

import adventOfCode.utils.ReadCSV;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Day3RuckSackReOrganization {

    public static void main(String[] args) throws IOException {

        List<String> data = ReadCSV.readOne();

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
        String chars = findCommon(temp);
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

        String common = findCommon(first, second);

        int totalPriority = 0;
        for (Character c : common.toCharArray()) {
            int priority = getPriority(String.valueOf(c));

            totalPriority += priority;
        }

        System.out.println("priority for " + temp + " is " + totalPriority);
        return totalPriority;
    }

    private static String findCommon(String first, String second) {

        StringBuilder commonChars = new StringBuilder();

        if (first.length() > 0 & second.length() > 0) {
            // We should iterate the smallest string in length.
            String toBeIterated = (first.length() > second.length() ? second : first);
            // Once string to be iterated is finalized, get string to be checked
            String toBeChecked = toBeIterated.equals(first) ? second : first;
            System.out.println("String to be iterated: " + toBeIterated);
            System.out.println("String to be checked: " + toBeChecked);

            // Iterating a string char by char
            for (int i = 0; i < toBeIterated.length(); i++) {
                // Check for common char
                if (toBeChecked.contains(Character.toString(toBeIterated.charAt(i)))) {
                    // If contains append it to resultant string
                    commonChars.append(toBeIterated.charAt(i));
                }
            }

            System.out.println("common element is " + removeDuplicates(commonChars.toString()));
            return removeDuplicates(commonChars.toString());
        } else
            return "";
    }

    public static String findCommon(String[] words) {

        if (words == null || words.length == 0)
            return "";

        Set<Character> unique = words[0].chars().mapToObj(ch -> (char) ch).collect(Collectors.toCollection(TreeSet::new));

        for (String word : words)
            unique.retainAll(word.chars().mapToObj(ch -> (char) ch).collect(Collectors.toSet()));

        return unique.stream().map(String::valueOf).collect(Collectors.joining());
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


    static String removeDuplicates(String str) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < str.length(); i++)
            set.add(str.charAt(i));

        StringBuilder result = new StringBuilder();
        for (Character ch : set)
            result.append(ch);
        return result.toString();
    }

}
