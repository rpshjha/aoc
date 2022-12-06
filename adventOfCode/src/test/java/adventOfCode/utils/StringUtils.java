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
            String toBeIterated = (first.length() > second.length() ? second : first);
            String toBeChecked = toBeIterated.equals(first) ? second : first;

            for (int i = 0; i < toBeIterated.length(); i++)
                if (toBeChecked.contains(Character.toString(toBeIterated.charAt(i))))
                    commonChars.append(toBeIterated.charAt(i));

            return StringUtils.removeDuplicates(commonChars.toString());
        } else
            return "";
    }
}
