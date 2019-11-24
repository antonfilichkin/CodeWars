package TwiceLinear;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoubleLinearTest {

    @Test()
    void dblLinear() {
        assertEquals(22, DoubleLinear.dblLinear(10));
        assertEquals(57, DoubleLinear.dblLinear(20));
        assertEquals(91, DoubleLinear.dblLinear(30));
        assertEquals(175, DoubleLinear.dblLinear(50));
        assertEquals(447, DoubleLinear.dblLinear(100));
    }
}