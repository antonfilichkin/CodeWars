package SumOfIntervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Interval {

    public static int sumIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int sum = 0;

        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        int leftToAnalyse = intervals.length;
        int[] analysedIntervals = new int[leftToAnalyse];

        while (leftToAnalyse > 0) {
            int start = 0;
            int end = 0;
            boolean startingAnalyse = true;
            for (int i = 0; i < intervals.length; ++i) {
                if (analysedIntervals[i] == 0) {
                    if (startingAnalyse) {
                        start = intervals[i][0];
                        end = intervals[i][1];

                        leftToAnalyse--;
                        analysedIntervals[i] = 1;
                        startingAnalyse = false;
                    } else {
                        int nextStart = intervals[i][0];
                        if (nextStart <= end) {
                            int nextEnd = intervals[i][1];
                            start = Math.min(start, nextStart);
                            end = Math.max(end, nextEnd);
                            leftToAnalyse--;
                            analysedIntervals[i] = 1;
                        }
                    }
                }
            }
            sum += Math.abs(end - start);
        }

        return sum;
    }

    public static int sumIntervals2(int[][] intervals) {
        return intervals == null ? 0 : (int) Arrays.stream(intervals)
                .flatMapToInt(interval -> IntStream.range(interval[0], interval[1]))
                .distinct()
                .count();
    }

    public static void main(String[] args) {
        long start, start1;
        long finish, finish1;

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            sumIntervals(new int[][]{{1, 4}, {3, 6}, {2, 8}});
            sumIntervals(new int[][]{{1, 2}, {3, 5}});
            sumIntervals(new int[][]{{10, 20}, {1, 6}, {16, 19}, {5, 11}});
            sumIntervals(new int[][]{{-9806, -7393}, {-8754, 2586}, {-8593, -562}, {-8509, -3341},
                    {-8462, -6916}, {-7940, -2220}, {-6706, 47}, {-6462, -3471}, {-6034, -1295}, {-5706, -3154},
                    {-4412, 236}, {-4071, 393}, {-3804, -2021}, {-2697, 2863}, {-2219, 4864}, {500, 1427}, {3018, 5055},
                    {3492, 5760}, {6196, 7284}, {7314, 8838}, {8167, 9856}});
            sumIntervals(new int[][]{});
            sumIntervals(null);
        }
        finish = System.nanoTime();
        start1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            sumIntervals2(new int[][]{{1, 4}, {3, 6}, {2, 8}});
            sumIntervals2(new int[][]{{1, 2}, {3, 5}});
            sumIntervals2(new int[][]{{10, 20}, {1, 6}, {16, 19}, {5, 11}});
            sumIntervals2(new int[][]{{-9806, -7393}, {-8754, 2586}, {-8593, -562}, {-8509, -3341},
                   {-8462, -6916}, {-7940, -2220}, {-6706, 47}, {-6462, -3471}, {-6034, -1295}, {-5706, -3154},
                    {-4412, 236}, {-4071, 393}, {-3804, -2021}, {-2697, 2863}, {-2219, 4864}, {500, 1427}, {3018, 5055},
                    {3492, 5760}, {6196, 7284}, {7314, 8838}, {8167, 9856}});
            sumIntervals2(new int[][]{});
            sumIntervals2(null);
        }
        finish1 = System.nanoTime();
        System.out.println("1 - " + (finish-start)/1_000_000);
        System.out.println("2 - " + (finish1-start1)/1_000_000);
    }
}