package ReversedWords;

public class ReversedWords {

    public static String reverseWords(String str){
        StringBuilder sb = new StringBuilder(str);
        String[] strArr = str.split(" ");

        for (int i = strArr.length - 1; i >= 0; i--) {
            sb.append(strArr[i]).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}