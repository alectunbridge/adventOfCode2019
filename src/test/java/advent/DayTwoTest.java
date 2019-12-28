package advent;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DayTwoTest {
    @Test
    public void testCase1() {
        DayTwo dayTwo = new DayTwo("1,9,10,3,2,3,11,0,99,30,40,50");
        assertThat(dayTwo.execute()).containsExactly(3500,9,10,70, 2,3,11,0, 99, 30,40,50);
    }

    @Test
    public void testCase2() {
        DayTwo dayTwo = new DayTwo("1,0,0,0,99");
        assertThat(dayTwo.execute()).containsExactly(2,0,0,0,99);
    }

    @Test
    public void testCase3() {
        DayTwo dayTwo = new DayTwo("2,3,0,3,99");
        assertThat(dayTwo.execute()).containsExactly(2,3,0,6,99);
    }

    @Test
    public void testCase4() {
        DayTwo dayTwo = new DayTwo("2,4,4,5,99,0");
        assertThat(dayTwo.execute()).containsExactly(2,4,4,5,99,9801);
    }

    @Test
    public void testCase5() {
        DayTwo dayTwo = new DayTwo("1,1,1,4,99,5,6,0,99");
        assertThat(dayTwo.execute()).containsExactly(30,1,1,4,2,5,6,0,99);
    }

}