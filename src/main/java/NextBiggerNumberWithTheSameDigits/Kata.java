package NextBiggerNumberWithTheSameDigits;

public class Kata {

    public static long nextBiggerNumber(long n) {
        if (n < 12) {
            return -1;
        }

        int headLastDigit = (int) (n % 10);
        long head = n / 10;

        int[] tail = new int[10];
        tail[headLastDigit] = 1;

        int tailPrevDigit = headLastDigit;
        headLastDigit = (int) (head % 10);

        while (head > 0) {
            if (headLastDigit >= tailPrevDigit) {
                tailPrevDigit = headLastDigit;
                tail[headLastDigit] += 1;
                head = head / 10;
                headLastDigit = (int) (head % 10);
            } else {
                tail[headLastDigit] += 1;
                for (int i = headLastDigit + 1; i < 10; ++i) {
                    if (tail[i] > 0) {
                        tail[i] = tail[i] - 1;
                        head = head - headLastDigit + i;
                        break;
                    }
                }

                long resultTail = 0;
                int multiplicationCoefficient = 1;
                for (int i = 9; i >= 0; i--) {
                    for (int j = 0; j < tail[i]; j++) {
                        resultTail += i * multiplicationCoefficient;
                        multiplicationCoefficient *= 10;
                    }
                }

                return head * multiplicationCoefficient + resultTail;
            }
        }

        return -1;
    }
}
