package SimpleAssemblerInterpreter;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static SimpleAssemblerInterpreter.SimpleAssembler.interpret;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

class SimpleAssemblerTest {

    @Nested
    class PositiveTests {

        @Test
        void interpretTest_inc_1() {
            String[] program = {"mov a 0", "inc a"};
            Map<String, Integer> result = new HashMap<>();
            result.put("a", 1);
            assertThat(interpret(program), equalTo(result));
        }

        @Test
        void interpretTest_inc_2() {
            String[] program = {"mov a 0", "inc a", "inc a"};
            Map<String, Integer> result = new HashMap<>();
            result.put("a", 2);
            assertThat(interpret(program), equalTo(result));
        }

        @Test
        void interpretTest_dec_1() {
            String[] program = {"mov b 0", "mov c 0", "dec b", "dec b", "dec b", "dec c"};
            Map<String, Integer> result = new HashMap<>();
            result.put("b", -3);
            result.put("c", -1);
            assertThat(interpret(program), equalTo(result));
        }

        @Test
        void interpretTest_mov_1_integer() {
            String[] program = {"mov b 20", "mov a 0", "mov a -1000000",};
            Map<String, Integer> result = new HashMap<>();
            result.put("a", -1_000_000);
            result.put("b", 20);
            assertThat(interpret(program), equalTo(result));
        }

        @Test
        void interpretTest_mov_2_register() {
            String[] program = {"mov a 0", "inc a", "inc a", "mov b a", "mov c 0", "inc c", "mov a c"};
            Map<String, Integer> result = new HashMap<>();
            result.put("a", 1);
            result.put("b", 2);
            result.put("c", 1);
            assertThat(interpret(program), equalTo(result));
        }

        @Test
        void interpretTest_jnz_backward() {
            String[] program = {"mov b 10", "mov a -30", "mov c b", "dec c", "inc a", "jnz a -2"};
            Map<String, Integer> result = new HashMap<>();
            result.put("a", 0);   //    -30      -29   -28   ...
            result.put("c", -20); //        10 9     8     7     ...
            result.put("b", 10);  // 10
            assertThat(interpret(program), equalTo(result));
        }

        @Test
        void interpretTest_jnz_forward() {
            String[] program = {"mov a -200", "mov b a", "inc b", "jnz a 2", "inc c", "jnz b -3", "inc b"};
            Map<String, Integer> result = new HashMap<>();
            result.put("a", -200);
            result.put("b", 1);
            assertThat(interpret(program), equalTo(result));
        }

        @Test
        void interpretTest_jnz_zero() {
            String[] program = {"mov c 0", "mov a -2", "inc a", "jnz a -1", "jnz 0 2", "inc c", "jnz c 3", "mov b 0", "inc b"};
            Map<String, Integer> result = new HashMap<>();
            result.put("a", 0);
            result.put("c", 1);
            assertThat(interpret(program), equalTo(result));
        }
    }

    @Nested
    class OriginalTests {

        @Test
        void interpretTest_1() {
            String[] program = {"mov a 1", "mov b 1", "mov c 0", "mov d 26", "jnz c 2", "jnz 1 5", "mov c 7", "inc d",
                    "dec c", "jnz c -2", "mov c a", "inc a", "dec b", "jnz b -2", "mov b c", "dec d", "jnz d -6",
                    "mov c 18", "mov d 11", "inc a", "dec d", "jnz d -2", "dec c", "jnz c -5"};
            Map<String, Integer> result = new HashMap<>();
            result.put("a", 318009);
            result.put("b", 196418);
            result.put("c", 0);
            result.put("d", 0);
            assertThat(interpret(program), equalTo(result));
        }
    }
}