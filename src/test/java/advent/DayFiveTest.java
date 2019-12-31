package advent;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DayFiveTest {

    @Test
    public void inputAndOutput() {
        StringBuilder input  = new StringBuilder("3,50,4,50");
        for (int i = 0; i < 49; i++) {
            input.append(",99");
        }
        DayFive dayFive = new DayFive(input.toString());
        assertThat(dayFive.execute(1)).isEqualTo(1);
    }

    @Test
    public void firstTestCase() {
        DayFive dayFive = new DayFive("3,0,4,0,99");
        assertThat(dayFive.execute(7)).isEqualTo(7);
    }

    @Test
    public void parameterModesFirstTestCase() {
        DayFive dayFive = new DayFive("1002,7,3,7,4,7,99,33");
        assertThat(dayFive.execute(0)).isEqualTo(99);
    }

    @Test
    public void parameterModesSecondTestCase() {
        DayFive dayFive = new DayFive("1101,100,-1,6,4,6,0,99");
        assertThat(dayFive.execute(0)).isEqualTo(99);
    }

}