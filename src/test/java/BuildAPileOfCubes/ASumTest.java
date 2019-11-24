package BuildAPileOfCubes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ASumTest {

    @Test
    void findNb() {
        assertEquals(45, ASum.findNb(1071225));
        assertEquals(55100, ASum.findNb(2304422822859492096L));
        assertEquals(77936, ASum.findNb(9223372036854775807L));
    }
}