package WriteNumberInExpandedForm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {
    @Test
    public void testSomething() {
        assertEquals("10 + 2", Kata2.expandedForm(12));
        assertEquals("40 + 2", Kata.expandedForm(42));
        assertEquals("70000 + 300 + 4", Kata2.expandedForm(70304));
        assertEquals("9000000", Kata.expandedForm(9000000));
        assertEquals("2000000000 + 1", Kata.expandedForm(2000000001));
        System.out.println(Integer.MAX_VALUE);
        assertEquals("2000000000 + 100000000 + 40000000 + 7000000 + 400000" +
                " + 80000 + 3000 + 600 + 40 + 7", Kata.expandedForm(Integer.MAX_VALUE));
    }
}
