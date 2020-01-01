package advent;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DayFiveTest {

    @Test
    public void inputAndOutput() {
        DayFive dayFive = new DayFive("3,50,4,50" + ",99".repeat(49));
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
        DayFive dayFive = new DayFive("1101,100,-1,7,4,7,99,0");
        assertThat(dayFive.execute(0)).isEqualTo(99);
    }

    @Test
    public void equalsFalse() {
        DayFive dayFive = new DayFive("3,9,8,9,10,9,4,9,99,-1,8");
        assertThat(dayFive.execute(1)).isEqualTo(0);
    }

    @Test
    public void equalsTrue() {
        DayFive dayFive = new DayFive("3,9,8,9,10,9,4,9,99,-1,8");
        assertThat(dayFive.execute(8)).isEqualTo(1);
    }

    @Test
    public void lessThanFalse() {
        DayFive dayFive = new DayFive("3,9,7,9,10,9,4,9,99,-1,8");
        assertThat(dayFive.execute(9)).isEqualTo(0);
    }

    @Test
    public void lessThanTrue() {
        DayFive dayFive = new DayFive("3,9,7,9,10,9,4,9,99,-1,8");
        assertThat(dayFive.execute(7)).isEqualTo(1);
    }

    @Test
    public void equalsImmediateModeFalse() {
        DayFive dayFive = new DayFive("3,3,1108,-1,8,3,4,3,99");
        assertThat(dayFive.execute(9)).isEqualTo(0);
    }

    @Test
    public void equalsImmediateModeTrue() {
        DayFive dayFive = new DayFive("3,3,1108,-1,8,3,4,3,99");
        assertThat(dayFive.execute(8)).isEqualTo(1);
    }

    @Test
    public void lessThanImmediateModeFalse() {
        DayFive dayFive = new DayFive("3,3,1107,-1,8,3,4,3,99");
        assertThat(dayFive.execute(9)).isEqualTo(0);
    }

    @Test
    public void lessThanImmediateModeTrue() {
        DayFive dayFive = new DayFive("3,3,1107,-1,8,3,4,3,99");
        assertThat(dayFive.execute(7)).isEqualTo(1);
    }

    @Test
    public void jumpTestPositionModeFalse() {
        DayFive dayFive = new DayFive("3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9");
        assertThat(dayFive.execute(0)).isEqualTo(0);
    }

    @Test
    public void jumpTestPositionModeTrue() {
        DayFive dayFive = new DayFive("3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9");
        assertThat(dayFive.execute(9)).isEqualTo(1);
    }

    @Test
    public void jumpTestImmediateModeFalse() {
        DayFive dayFive = new DayFive("3,3,1105,-1,9,1101,0,0,12,4,12,99,1");
        assertThat(dayFive.execute(0)).isEqualTo(0);
    }

    @Test
    public void jumpTestImmediateModeTrue() {
        DayFive dayFive = new DayFive("3,3,1105,-1,9,1101,0,0,12,4,12,99,1");
        assertThat(dayFive.execute(9)).isEqualTo(1);
    }

    @Test
    public void largerExampleInputBelowEight() {
        DayFive dayFive = new DayFive("3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31," +
                "1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104," +
                "999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99");
        assertThat(dayFive.execute(7)).isEqualTo(999);
    }

    @Test
    public void largerExampleInputEqualsEight() {
        DayFive dayFive = new DayFive("3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31," +
                "1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104," +
                "999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99");
        assertThat(dayFive.execute(8)).isEqualTo(1000);
    }

    @Test
    public void largerExampleInputAboveEight() {
        DayFive dayFive = new DayFive("3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31," +
                "1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104," +
                "999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99");
        assertThat(dayFive.execute(9)).isEqualTo(1001);
    }
}