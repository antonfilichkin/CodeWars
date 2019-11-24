package FindTheOddInt;

import java.util.HashMap;
import java.util.Map;

public class FindOdd {
    public static int findIt(int[] a) throws Exception {

        Map<Integer, Integer> countOccurrences = new HashMap<>();

        for (int element : a) {
            countOccurrences.computeIfPresent(element, FindOdd::apply);
            countOccurrences.putIfAbsent(element, 1);
        }

        for (int count : countOccurrences.keySet()) {
            if (countOccurrences.get(count) % 2 != 0) {
                return count;
            }
        }

        throw new Exception("Input Data Wrong");
    }

    private static int apply(int key, int value) {
        return value + 1;
    }
}