package PangramChecker;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class PangramChecker {
    public static void main(String[] args) {
        String pangram = "The quick brown fox jumps over the lazy dog.";
        PangramChecker pc = new PangramChecker();

        long start, stop;

        start = System.nanoTime();
        System.out.print(pc.check1(pangram));
        stop = System.nanoTime();
        System.out.println(" - " + (stop - start) / 1000);

        start = System.nanoTime();
        System.out.print(pc.check2(pangram));
        stop = System.nanoTime();
        System.out.println(" - " + (stop - start) / 1000);

        start = System.nanoTime();
        System.out.print(pc.check3(pangram));
        stop = System.nanoTime();
        System.out.println(" - " + (stop - start) / 1000);

        start = System.nanoTime();
        System.out.print(pc.check4(pangram));
        stop = System.nanoTime();
        System.out.println(" - " + (stop - start) / 1000);

    }

    public boolean check1(String sentence){
        char[] charArray = sentence.toLowerCase().replaceAll("[^\\w]","").toCharArray();
        TreeSet<Character> setOfChars = new TreeSet<>();

        for (char c: charArray){
            setOfChars.add(c);
        }

        return setOfChars.size() == 26;
    }

    public boolean check2(String sentence){
            for (char c = 'a'; c<='z'; c++)
                if (!sentence.toLowerCase().contains("" + c))
                    return false;
            return true;

    }

    public boolean check3(String sentence){
        return sentence.chars().map(Character::toLowerCase).filter(Character::isAlphabetic).distinct().count() == 26;
    }

    public boolean check4(String s){
        return new HashSet<>(Arrays.asList(s.toUpperCase().replaceAll("[^A-Z]","").split(""))).size() == 26;
    }
}