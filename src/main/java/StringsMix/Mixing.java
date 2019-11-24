package StringsMix;

import java.util.*;

public class Mixing {

    static String mix(String s1, String s2) {
        Map<Character, Integer> firstStringSymbols = countCharsAtString(s1);
        Map<Character, Integer> secondStringSymbols = countCharsAtString(s2);
        Set<String> result = getSortedSetOfLongestSequences(firstStringSymbols, secondStringSymbols);


        if (result.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (String entry : result) {
            sb.append(entry).append("/");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }


    private static Map<Character, Integer> countCharsAtString(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); ++i) {
            if (Character.isLetter(str.charAt(i)) && Character.isLowerCase(str.charAt(i))) {
                if (map.computeIfPresent(str.charAt(i), (key, value) -> value + 1) == null) {
                    map.put(str.charAt(i), 1);
                }
            }
        }

        return map;
    }


    private static SortedSet<String> getSortedSetOfLongestSequences(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        TreeSet<String> resultSet = new TreeSet<>(Comparator.comparingInt(String::length).reversed()
                .thenComparing(Comparator.naturalOrder()));

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            char letter = entry.getKey();
            int numberOfCharactersInFirst = entry.getValue();
            int numberOfCharactersInSecond = 0;
            if (map2.containsKey(letter)) {
                numberOfCharactersInSecond = map2.get(letter);
            }

            char fromWhereLongerSequence = numberOfCharactersInFirst > numberOfCharactersInSecond ? '1' :
                    numberOfCharactersInFirst < numberOfCharactersInSecond ? '2' : '=';

            int letterSequenceLength = Math.max(numberOfCharactersInFirst, numberOfCharactersInSecond);

            if (letterSequenceLength > 1) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < letterSequenceLength; ++i) {
                    sb.append(letter);
                }
                resultSet.add(fromWhereLongerSequence + ":" + sb.toString());
            }

            map2.remove(letter);
        }

        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            char letter = entry.getKey();
            if (entry.getValue() > 1) {

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < entry.getValue(); ++i) {
                    sb.append(letter);
                }

                resultSet.add("2:" + sb.toString());
            }
        }

        return resultSet;
    }
}
