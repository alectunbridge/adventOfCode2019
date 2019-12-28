package advent;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DayTwo {

    public static final int WORD_LENGTH = 4;
    private static final int ADD = 1;
    private static final int MULTIPLY = 2;
    private List<Integer> memory;
    private int instructionPointer = 0;

    public DayTwo(String input) {
        parseInput(input);
    }

    public DayTwo() {

    }

    public List<Integer> parseInput(String input) {
        memory = Arrays.stream(input.split(",")).map(Integer::valueOf).collect(Collectors.toList());
        return memory;
    }

    public List<Integer> executeNextCommand() {
        int instruction = memory.get(instructionPointer);
        int fromAddress1 = memory.get(instructionPointer + 1);
        int fromAddress2 = memory.get(instructionPointer + 2);
        int toAddress = memory.get(instructionPointer + 3);
        if(instruction == ADD) {
            memory.set(toAddress, memory.get(fromAddress1) + memory.get(fromAddress2));
        } else if (instruction == MULTIPLY){
            memory.set(toAddress, memory.get(fromAddress1) * memory.get(fromAddress2));
        } else {
            return null;
        }
        instructionPointer += WORD_LENGTH;
        return memory;
    }

    public List<Integer> execute() {
        List<Integer> lastResult = executeNextCommand();
        while(lastResult != null){
            lastResult = executeNextCommand();
        }
        return memory;
    }
}
