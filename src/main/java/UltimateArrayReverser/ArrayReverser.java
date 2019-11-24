package UltimateArrayReverser;

import java.util.ArrayList;
import java.util.List;

public class ArrayReverser {
    public static String[] reverse(String[] a) {
        List<Integer> lengths = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        List<String> out = new ArrayList<>();

        for (String str : a) {
            sb.append(str);
            lengths.add(str.length());
        }

        sb.reverse();

        int currentPos = 0;

        for (Integer len : lengths) {
            out.add(sb.substring(currentPos, currentPos + len));
            currentPos += len;
        }

        return out.toArray(new String[0]);
    }
}
