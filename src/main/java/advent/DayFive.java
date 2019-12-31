package advent;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DayFive {

    private static final int ADD = 1;
    private static final int MULTIPLY = 2;
    private static final int HALT = 99;
    private static final int INPUT = 3;
    private static final int OUTPUT = 4;
    private List<Integer> memory;
    private int instructionPointer = 0;
    private int input;
    private int output;

    public DayFive(String input) {
        memory = Arrays.stream(input.split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }

    private boolean executeNextCommand() {
        int instruction = memory.get(instructionPointer);
        if (instruction == HALT) {
            return true;
        }

        switch (instruction) {
            case INPUT: {
                int toAddress = memory.get(instructionPointer + 1);
                memory.set(toAddress, input);
                instructionPointer += 2;
                break;
            }
            case OUTPUT: {
                int fromAddress = memory.get(instructionPointer + 1);
                output = memory.get(fromAddress);
                instructionPointer += 2;
                break;
            }
            case ADD: {
                int fromAddress1 = memory.get(instructionPointer + 1);
                int fromAddress2 = memory.get(instructionPointer + 2);
                int toAddress = memory.get(instructionPointer + 3);
                memory.set(toAddress, memory.get(fromAddress1) + memory.get(fromAddress2));
                instructionPointer += 4;
                break;
            }
            case MULTIPLY: {
                int fromAddress1 = memory.get(instructionPointer + 1);
                int fromAddress2 = memory.get(instructionPointer + 2);
                int toAddress = memory.get(instructionPointer + 3);
                memory.set(toAddress, memory.get(fromAddress1) * memory.get(fromAddress2));
                instructionPointer += 4;
                break;
            }
            default:
                throw new UnsupportedOperationException();
        }
        return false;
    }

    public int execute(int input) {
        this.input = input;
        boolean terminated = executeNextCommand();
        while (!terminated) {
            terminated = executeNextCommand();
        }
        return output;
    }

    public void setAddress(int address, int value) {
        memory.set(address, value);
    }

    public static void main(String args[]) throws URISyntaxException, IOException {
        Path path = null;
        String input = null;
        path = Paths.get(DayOne.class.getClassLoader()
                .getResource("input_day2.txt").toURI());
        input = Files.readString(path);

        //TODO complete this for day five
    }
}
