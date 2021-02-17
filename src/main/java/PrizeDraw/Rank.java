package PrizeDraw;

import java.util.AbstractMap;
import java.util.ArrayList;

class Rank {

    private final static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String nthRank(String st, Integer[] we, int n) {
        if (st.isEmpty()) {
            return "No participants";
        }

        final String[] names = st.split(",");

        if (n > names.length) {
            return "Not enough participants";
        }

        ArrayList<AbstractMap.Entry<String, Integer>> rankedNames = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            final String name = names[i];
            final int winningNumber = calculateNameWeight(name) * we[i];
            rankedNames.add(new AbstractMap.SimpleEntry<>(name, winningNumber));
        }

        rankedNames.sort((o1, o2) ->
                (o1.getValue().equals(o2.getValue()))
                        ? o1.getKey().compareTo(o2.getKey())
                        : o1.getValue().compareTo(o2.getValue()));

        return rankedNames.get(n - 1).getKey();
    }

    private static int calculateNameWeight(String name) {
        char[] chars = name.toLowerCase().toCharArray();
        int weight = name.length();
        for (char c : chars) {
            weight += alphabet.indexOf(c) + 1;
        }
        return weight;
    }
}
