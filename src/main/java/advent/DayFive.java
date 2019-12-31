package advent;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
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
        int instruction = memory.get(instructionPointer) % 100;
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
                int parameter1 = memory.get(instructionPointer + 1);

                int parameterModeBits = memory.get(instructionPointer) / 100;
                boolean immediateMode1 = false;
                if (parameterModeBits > 0) {
                    if (parameterModeBits % 2 == 1) {
                        immediateMode1 = true;
                    }
                }
                output = immediateMode1 ? parameter1 : memory.get(parameter1);
                System.out.println(output);
                instructionPointer += 2;
                break;
            }
            case ADD: {
                applyBinaryOperator(Integer::sum);
                break;
            }
            case MULTIPLY: {
                applyBinaryOperator((int1, int2) -> int1 * int2);
                break;
            }
            default:
                throw new UnsupportedOperationException();
        }
        return false;
    }

    private void applyBinaryOperator(BinaryOperator<Integer> binaryOperator) {
        int parameter1 = memory.get(instructionPointer + 1);
        int parameter2 = memory.get(instructionPointer + 2);
        int toAddress = memory.get(instructionPointer + 3);

        int parameterModeBits = memory.get(instructionPointer) / 100;
        boolean immediateMode1 = false;
        boolean immediateMode2 = false;
        if (parameterModeBits > 0) {
            if (parameterModeBits % 2 == 1) {
                immediateMode1 = true;
            }
            if (parameterModeBits > 1) {
                immediateMode2 = true;
            }
        }

        int int1 = immediateMode1 ? parameter1 : memory.get(parameter1);
        int int2 = immediateMode2 ? parameter2 : memory.get(parameter2);
        memory.set(toAddress, binaryOperator.apply(int1, int2));
        instructionPointer += 4;
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
                .getResource("input_day5.txt").toURI());
        input = Files.readString(path);

        DayFive dayFive = new DayFive(input);
        dayFive.execute(1);
    }
}
