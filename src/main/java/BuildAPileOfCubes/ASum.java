package BuildAPileOfCubes;

public class ASum {

    public static void main(String[] args) {

        long test = 0;
        for (int i = 1; i <= 55100; i++){
            test += Math.pow(i,3);
        }

        System.out.println(test);
    }

    public static long findNb(long m) {

        long n = -1;
        long sum = 0;
        for (long i = 1; sum < m; i++){
            sum += i*i*i;
            n = i;
        }

        return (sum == m) ? n : -1;
    }
}