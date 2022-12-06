package adventOfCode.utils;

import java.util.*;
import java.util.stream.Collectors;

public class StringUtils {

    public static List<Character> checkIfDuplicates(String str) {

        LinkedHashMap<Character, Integer> oMap = new LinkedHashMap<>();

        for (char ch : str.toCharArray())
            if (oMap.containsKey(ch))
                oMap.put(ch, oMap.get(ch) + 1);
            else
                oMap.put(ch, 1);

        return oMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static String removeDuplicates(String str) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < str.length(); i++)
            set.add(str.charAt(i));

        StringBuilder result = new StringBuilder();
        for (Character ch : set)
            result.append(ch);
        return result.toString();
    }

    public static String findCommonString(String[] words) {

        if (words == null || words.length == 0)
            return "";

        Set<Character> unique = words[0].chars().mapToObj(ch -> (char) ch).collect(Collectors.toCollection(TreeSet::new));

        for (String word : words)
            unique.retainAll(word.chars().mapToObj(ch -> (char) ch).collect(Collectors.toSet()));

        return unique.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static String findCommonString(String first, String second) {

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

            System.out.println("common element is " + StringUtils.removeDuplicates(commonChars.toString()));
            return StringUtils.removeDuplicates(commonChars.toString());
        } else
            return "";
    }
}
