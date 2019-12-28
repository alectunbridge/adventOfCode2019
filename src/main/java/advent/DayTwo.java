package advent;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DayTwo {

    public static final int WORD_LENGTH = 4;
    private static final int ADD = 1;
    private static final int MULTIPLY = 2;
    private static final int HALT = 99;
    private List<Integer> memory;
    private int instructionPointer = 0;

    public DayTwo(String input) {
        memory = Arrays.stream(input.split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }

    private boolean executeNextCommand() {
        int instruction = memory.get(instructionPointer);
        if(instruction == HALT){
            return true;
        }
        int fromAddress1 = memory.get(instructionPointer + 1);
        int fromAddress2 = memory.get(instructionPointer + 2);
        int toAddress = memory.get(instructionPointer + 3);
        if(instruction == ADD) {
            memory.set(toAddress, memory.get(fromAddress1) + memory.get(fromAddress2));
        } else if (instruction == MULTIPLY){
            memory.set(toAddress, memory.get(fromAddress1) * memory.get(fromAddress2));
        }
        instructionPointer += WORD_LENGTH;
        return false;
    }

    public List<Integer> execute() {
        boolean terminated = executeNextCommand();
        while(!terminated){
            terminated = executeNextCommand();
        }
        return memory;
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
        DayTwo dayTwo = new DayTwo(input);
        dayTwo.setAddress(1,12);
        dayTwo.setAddress(2,2);
        System.out.println(dayTwo.execute().get(0));
    }
}
