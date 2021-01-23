package SimpleStringReversal;

class Solution {
    public static String solve(String s) {
        StringBuilder reversedString = new StringBuilder(s.replaceAll(" ", "")).reverse();
        int currentSpacePosition = s.indexOf(" ");
        while (currentSpacePosition > 0) {
            reversedString.insert(currentSpacePosition, " ");
            currentSpacePosition = s.indexOf(" ", currentSpacePosition + 1);
        }
        return reversedString.toString();
    }
}