package RectangleIntoSquares;

import java.util.ArrayList;
import java.util.List;

public class SqInRect {

    public static List<Integer> sqInRect(int lng, int wdth) {
        if (lng == wdth) {
            return null;
        }

        List<Integer> rectangles  = new ArrayList<>();
        int[] rectangle = (lng > wdth) ? new int[] {lng, wdth} : new int[] {wdth, lng};

        while (rectangle[1] > 1){
            rectangles.add(rectangle[1]);
            rectangle = nextSquare(rectangle);
        }

        if (rectangle[1] == 1){
            for(int i = 0; i < rectangle[0]; ++i) {
                rectangles.add(1);
            }
        }

        return rectangles;
    }


    private static int[] nextSquare(int[] a){
        a[0] = a[0] - a[1];
        if (a[0] < a[1]){
            a[0] = a[0] + a[1];
            a[1] = a[0] - a[1];
            a[0] = a[0] - a[1];
        }
        return a;
    }
}

