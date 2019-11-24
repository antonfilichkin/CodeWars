package TwoToOne;

import java.util.SortedSet;
import java.util.TreeSet;


public class TwoToOne {

    public static void main(String[] args) {
        System.out.println(longest("azxswedcvfrt", "gaasfkfmrmmr"));
    }


    public static String longest (String s1, String s2) {
        SortedSet<Character> charset = new TreeSet<>();
        for (int i = 0; i < s1.length(); i++) {
            charset.add(s1.charAt(i));
        }

        for (int i = 0; i < s2.length(); i++) {
            charset.add(s2.charAt(i));
        }

        char[] out = new char[charset.size()];

        for (int i = 0; i < out.length; i++) {
            out[i] = ((TreeSet<Character>) charset).pollFirst();
        }

        return new String(out);
    }

}
