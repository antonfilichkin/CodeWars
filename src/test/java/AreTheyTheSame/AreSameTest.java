package AreTheyTheSame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AreSameTest {

    @Test
    void testAreSameReturnTrue() {
        assertTrue(AreSame.comp(new int[]{121, 144, 19, 161, 19, 144, 19, 11},
                new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361}));

        assertTrue(AreSame.comp(new int[]{-1, -5, 10},
                new int[]{100, 25, 1}));
    }

    @Test
    void testAreSameReturnFalse() {
        assertFalse(AreSame.comp(new int[]{120, 144, 19, 161, 19, 144, 19, 11},
                new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361}));

        assertFalse(AreSame.comp(new int[]{}, new int[]{361, 20736, 361}));

        int[] a;
        a = null;
        assertFalse(AreSame.comp(a, new int[]{21, 14641, 20736, 361, 25921, 361, 20736, 361}));
    }
}