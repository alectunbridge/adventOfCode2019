package advent;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DayTwoTest {
    @Test
    public void readInputIntoArray() {
        DayTwo dayTwo = new DayTwo();
        List<Integer> input = dayTwo.parseInput("1,9,10,3,2,3,11,0,99,30,40,50");
        assertThat(input).containsExactly(1,9,10,3,2,3,11,0,99,30,40,50);
        List<Integer> output1 = dayTwo.executeNextCommand();
        assertThat(output1).containsExactly(1,9,10,70, 2,3,11,0, 99, 30,40,50);
        List<Integer> output2 = dayTwo.executeNextCommand();
        assertThat(output2).containsExactly(3500,9,10,70, 2,3,11,0, 99, 30,40,50);
        List<Integer> output3 = dayTwo.executeNextCommand();
        assertThat(output3).isNull();
    }

    @Test
    public void execute() {
        DayTwo dayTwo = new DayTwo("1,9,10,3,2,3,11,0,99,30,40,50");
        assertThat(dayTwo.execute()).containsExactly(3500,9,10,70, 2,3,11,0, 99, 30,40,50);
    }
}