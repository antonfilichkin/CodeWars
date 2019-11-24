package SortTheOdd;

import java.util.Arrays;

public class Kata {
    public static int[] sortArray(int[] array) {
        if (array.length == 0) {
            return array;
        }

        int[] tempOdds = new int[array.length];

        for (int i = 0; i < array.length; ++i) {
            if (array[i] % 2 != 0) {
                tempOdds[i] = array[i];
            }
        }

        Arrays.sort(tempOdds);

        int startPos = 0;
        for (int i = 0; i < array.length; ++i) {
            if (tempOdds[i] != 0) {
                startPos = i;
                break;
            }
        }

        for (int i = 0, j = startPos; i < array.length; ++i) {
            if (array[i] % 2 != 0) {
                array[i] = tempOdds[j];
                j++;
            }
        }

        return array;
    }

    public static int[] sortArray2(final int[] array) {

        // Sort the odd numbers only
        final int[] sortedOdd = Arrays.stream(array).filter(e -> e % 2 == 1).sorted().toArray();

        // Then merge them back into original array
        for (int j = 0, s = 0; j < array.length; j++) {
            if (array[j] % 2 == 1) array[j] = sortedOdd[s++];
        }

        return array;
    }

}