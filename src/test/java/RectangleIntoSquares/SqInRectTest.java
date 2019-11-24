package RectangleIntoSquares;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SqInRectTest {

    @Test
    public void test1() {
        List<Integer> res = new ArrayList<>(Arrays.asList(4, 1, 1, 1, 1));
        for (int r : res)
            assertEquals(res, SqInRect.sqInRect(5, 4));
    }

    @Test
    public void test2() {
        List<Integer> res = new ArrayList<>(Arrays.asList(2, 2, 2));
        for (int r : res)
            assertEquals(res, SqInRect.sqInRect(6, 2));
    }

    @Test
    public void test3() {
        assertNull(SqInRect.sqInRect(5, 5));
    }
}