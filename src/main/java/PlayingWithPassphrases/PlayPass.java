package PlayingWithPassphrases;

public class PlayPass {
    public static String playPass(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append((char) (105 - c));
            } else if (Character.isLetter(c)) {
                int tChar = c + n;
                if (tChar > 90) {
                    tChar -= 26;
                }
                if (sb.length() % 2 != 0) {
                    tChar += 32;
                }
                sb.append((char)tChar);
            } else {
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }
}
