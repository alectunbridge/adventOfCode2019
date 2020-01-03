package advent;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DaySeven {

    private static final int ADD = 1;
    private static final int MULTIPLY = 2;
    private static final int INPUT = 3;
    private static final int OUTPUT = 4;
    private static final int JUMP_IF_FALSE = 5;
    private static final int JUMP_IF_TRUE = 6;
    private static final int LESS_THAN = 7;
    private static final int EQUALS = 8;
    private static final int HALT = 99;
    private List<Integer> memory;
    private int instructionPointer = 0;
    private Deque<Integer> args = new ArrayDeque<>();
    private int output;

    public DaySeven(String input) {
        memory = Arrays.stream(input.split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }

    private boolean executeNextCommand() {
        int instruction = memory.get(instructionPointer) % 100;
        if (instruction == HALT) {
            return true;
        }

        switch (instruction) {
            case ADD: {
                applyBinaryOperator(Integer::sum);
                break;
            }
            case MULTIPLY: {
                applyBinaryOperator((int1, int2) -> int1 * int2);
                break;
            }
            case INPUT: {
                int toAddress = memory.get(instructionPointer + 1);
                memory.set(toAddress, args.removeFirst());
                instructionPointer += 2;
                break;
            }
            case OUTPUT: {
                int parameter1 = memory.get(instructionPointer + 1);
                output = getParameterValue1(parameter1);
                System.out.println(output);
                instructionPointer += 2;
                break;
            }
            case JUMP_IF_FALSE: {
                jump(int11 -> int11 != 0);
                break;
            }
            case JUMP_IF_TRUE: {
                jump(int11 -> int11 == 0);
                break;
            }
            case EQUALS: {
                applyBinaryOperator((int1, int2) -> int1.equals(int2) ? 1 : 0);
                break;
            }
            case LESS_THAN: {
                applyBinaryOperator((int1, int2) -> int1 < int2 ? 1 : 0);
                break;
            }
            default:
                throw new UnsupportedOperationException("OPCODE:" + instruction);
        }
        return false;
    }

    private void jump(Predicate<Integer> condition) {
        int parameter1 = memory.get(instructionPointer + 1);
        int parameter2 = memory.get(instructionPointer + 2);

        int int1 = getParameterValue1(parameter1);
        int int2 = getParameterValue2(parameter2);
        if (condition.test(int1)) {
            instructionPointer = int2;
        } else {
            instructionPointer += 3;
        }
    }

    private void applyBinaryOperator(BinaryOperator<Integer> binaryOperator) {
        int parameter1 = memory.get(instructionPointer + 1);
        int parameter2 = memory.get(instructionPointer + 2);
        int toAddress = memory.get(instructionPointer + 3);

        int int1 = getParameterValue1(parameter1);
        int int2 = getParameterValue2(parameter2);
        memory.set(toAddress, binaryOperator.apply(int1, int2));
        instructionPointer += 4;
    }

    private int getParameterValue1(int parameter) {
        return getParameterValue(parameter, parameterModeBits -> parameterModeBits % 2 == 1);
    }

    private int getParameterValue2(int parameter) {
        return getParameterValue(parameter, parameterModeBits -> parameterModeBits > 1);
    }

    private int getParameterValue(int parameter, Function<Integer, Boolean> isImmediateMode) {
        boolean paramIsImmediate = false;
        int parameterModeBits = memory.get(instructionPointer) / 100;
        if (parameterModeBits > 0) {
            paramIsImmediate = isImmediateMode.apply(parameterModeBits);
        }
        if (paramIsImmediate) {
            return parameter;
        }
        return memory.get(parameter);
    }

    public int execute() {
        boolean terminated = executeNextCommand();
        while (!terminated) {
            terminated = executeNextCommand();
        }
        return output;
    }

    public void addArgument(int argument) {
        args.add(argument);
    }

    static int getThrusterPower(String input, int phase1, int phase2, int phase3, int phase4, int phase5) {

        DaySeven amplifier1 = new DaySeven(input);
        amplifier1.addArgument(phase1);
        amplifier1.addArgument(0);

        DaySeven amplifier2 = new DaySeven(input);
        amplifier2.addArgument(phase2);
        amplifier2.addArgument(amplifier1.execute());

        DaySeven amplifier3 = new DaySeven(input);
        amplifier3.addArgument(phase3);
        amplifier3.addArgument(amplifier2.execute());

        DaySeven amplifier4 = new DaySeven(input);
        amplifier4.addArgument(phase4);
        amplifier4.addArgument(amplifier3.execute());

        DaySeven amplifier5 = new DaySeven(input);
        amplifier5.addArgument(phase5);
        amplifier5.addArgument(amplifier4.execute());

        return amplifier5.execute();
    }

    public static void main(String args[]) throws URISyntaxException, IOException {
        Path path = null;
        String input = null;
        path = Paths.get(DayOne.class.getClassLoader()
                .getResource("input_day7.txt").toURI());
        input = Files.readString(path);

        //TODO
    }
}
