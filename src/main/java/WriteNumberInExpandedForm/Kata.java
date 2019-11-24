package WriteNumberInExpandedForm;

import java.util.ArrayList;
import java.util.List;

public class Kata {
    public static String expandedForm(int num) {

        List<Integer> digits = new ArrayList<>();

        boolean lastZero = (num%10 == 0);

        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = digits.size()-1; i > 0; --i) {
            if (digits.get(i) != 0) {
                sb.append(digits.get(i) * (int) Math.pow(10, i)).append(" + ");
            }
        }

        if (lastZero) {
            sb.delete(sb.lastIndexOf("+") - 1, sb.length());
        } else {
            sb.append(digits.get(0));
        }

        return sb.toString();
    }
}

class Kata2
{
    public static String expandedForm(int num)
    {
        String outs = "";
        for (int i = 10; i < num; i *= 10) {
            int rem = num % i;
            outs = (rem > 0) ? " + " + rem + outs : outs;
            num -= rem;
        }
        outs = num + outs;

        return outs;
    }
}