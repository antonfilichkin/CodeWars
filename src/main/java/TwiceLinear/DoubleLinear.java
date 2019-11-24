package TwiceLinear;

import java.util.TreeSet;

class DoubleLinear {

    public static int dblLinear(int n) {
        TreeSet<Integer> sequence = new TreeSet<>();

        sequence.add(1);

        for (int i = 0; i < n; ++i) {
            int x = sequence.pollFirst();
            sequence.add(2 * x + 1);
            sequence.add(3 * x + 1);
        }

        return sequence.first();
    }
}