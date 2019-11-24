package SimpleAssemblerInterpreter;

import java.util.HashMap;
import java.util.Map;

public class SimpleAssembler {

    public static Map<String, Integer> interpret(String[] program) {
        Map<String, Integer> registersConditions = new HashMap<>();

        int i = 0;

        while (i < program.length) {
            String[] instruction = program[i].split(" ");
            String register = instruction[1];

            switch (instruction[0]) {
                case "inc":
                    registersConditions.put(register, registersConditions.get(register) + 1);
                    ++i;
                    break;

                case "dec":
                    registersConditions.put(register, registersConditions.get(register) - 1);
                    ++i;
                    break;

                case "mov":
                    registersConditions.put(register, instruction[2].matches("-?\\d+") ?
                            Integer.parseInt(instruction[2]) : registersConditions.get(instruction[2]));
                    ++i;
                    break;

                case "jnz":
                    int moveTo = instruction[1].matches("(-?\\d+)") ?
                            Integer.parseInt(instruction[1]) : registersConditions.get(register);
                    i += (moveTo == 0) ? 1 : Integer.parseInt(instruction[2]);
                    break;
            }
        }

        return registersConditions;
    }
}