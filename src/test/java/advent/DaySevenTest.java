package advent;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DaySevenTest {

    @Test
    public void inputAndOutput() {
        DaySeven daySeven = new DaySeven("3,50,4,50" + ",99".repeat(49));
        daySeven.addArgument(1);
        assertThat(daySeven.execute()).isEqualTo(1);
    }

    @Test
    public void firstTestCaseFromDayFive() {
        DaySeven daySeven = new DaySeven("3,0,4,0,99");
        daySeven.addArgument(7);
        assertThat(daySeven.execute()).isEqualTo(7);
    }

    @Test
    public void parameterModesFirstTestCase() {
        DaySeven daySeven = new DaySeven("1002,7,3,7,4,7,99,33");
        daySeven.addArgument(0);
        assertThat(daySeven.execute()).isEqualTo(99);
    }

    @Test
    public void parameterModesSecondTestCase() {
        DaySeven daySeven = new DaySeven("1101,100,-1,7,4,7,99,0");
        daySeven.addArgument(0);
        assertThat(daySeven.execute()).isEqualTo(99);
    }

    @Test
    public void equalsFalse() {
        DaySeven daySeven = new DaySeven("3,9,8,9,10,9,4,9,99,-1,8");
        daySeven.addArgument(1);
        assertThat(daySeven.execute()).isEqualTo(0);
    }

    @Test
    public void equalsTrue() {
        DaySeven daySeven = new DaySeven("3,9,8,9,10,9,4,9,99,-1,8");
        daySeven.addArgument(8);
        assertThat(daySeven.execute()).isEqualTo(1);
    }

    @Test
    public void lessThanFalse() {
        DaySeven daySeven = new DaySeven("3,9,7,9,10,9,4,9,99,-1,8");
        daySeven.addArgument(9);
        assertThat(daySeven.execute()).isEqualTo(0);
    }

    @Test
    public void lessThanTrue() {
        DaySeven daySeven = new DaySeven("3,9,7,9,10,9,4,9,99,-1,8");
        daySeven.addArgument(7);
        assertThat(daySeven.execute()).isEqualTo(1);
    }

    @Test
    public void equalsImmediateModeFalse() {
        DaySeven daySeven = new DaySeven("3,3,1108,-1,8,3,4,3,99");
        daySeven.addArgument(9);
        assertThat(daySeven.execute()).isEqualTo(0);
    }

    @Test
    public void equalsImmediateModeTrue() {
        DaySeven daySeven = new DaySeven("3,3,1108,-1,8,3,4,3,99");
        daySeven.addArgument(8);
        assertThat(daySeven.execute()).isEqualTo(1);
    }

    @Test
    public void lessThanImmediateModeFalse() {
        DaySeven daySeven = new DaySeven("3,3,1107,-1,8,3,4,3,99");
        daySeven.addArgument(9);
        assertThat(daySeven.execute()).isEqualTo(0);
    }

    @Test
    public void lessThanImmediateModeTrue() {
        DaySeven daySeven = new DaySeven("3,3,1107,-1,8,3,4,3,99");
        daySeven.addArgument(7);
        assertThat(daySeven.execute()).isEqualTo(1);
    }

    @Test
    public void jumpTestPositionModeFalse() {
        DaySeven daySeven = new DaySeven("3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9");
        daySeven.addArgument(0);
        assertThat(daySeven.execute()).isEqualTo(0);
    }

    @Test
    public void jumpTestPositionModeTrue() {
        DaySeven daySeven = new DaySeven("3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9");
        daySeven.addArgument(9);
        assertThat(daySeven.execute()).isEqualTo(1);
    }

    @Test
    public void jumpTestImmediateModeFalse() {
        DaySeven daySeven = new DaySeven("3,3,1105,-1,9,1101,0,0,12,4,12,99,1");
        daySeven.addArgument(0);
        assertThat(daySeven.execute()).isEqualTo(0);
    }

    @Test
    public void jumpTestImmediateModeTrue() {
        DaySeven daySeven = new DaySeven("3,3,1105,-1,9,1101,0,0,12,4,12,99,1");
        daySeven.addArgument(9);
        assertThat(daySeven.execute()).isEqualTo(1);
    }

    @Test
    public void largerExampleInputBelowEight() {
        DaySeven daySeven = new DaySeven("3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31," +
                "1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104," +
                "999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99");
        daySeven.addArgument(7);
        assertThat(daySeven.execute()).isEqualTo(999);
    }

    @Test
    public void largerExampleInputEqualsEight() {
        DaySeven daySeven = new DaySeven("3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31," +
                "1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104," +
                "999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99");
        daySeven.addArgument(8);
        assertThat(daySeven.execute()).isEqualTo(1000);
    }

    @Test
    public void largerExampleInputAboveEight() {
        DaySeven daySeven = new DaySeven("3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31," +
                "1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104," +
                "999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99");
        daySeven.addArgument(9);
        assertThat(daySeven.execute()).isEqualTo(1001);
    }

    @Test
    public void firstTestCase() {
        int output = DaySeven.getThrusterPower("3,15,3,16,1002,16,10,16,1,16,15,15,4,15,99,0,0",
                4,3,2,1,0);
        assertThat(output).isEqualTo(43210);
    }

    @Test
    public void testCase2() {
        int output = DaySeven.getThrusterPower("3,23,3,24,1002,24,10,24,1002,23,-1,23,101,5,23,23,1,24,23,23,4,23,99,0,0",
                0, 1, 2, 3, 4);
        assertThat(output).isEqualTo(54321);
    }

    @Test
    public void testCase3() {
        int output = DaySeven.getThrusterPower("3,31,3,32,1002,32,10,32,1001,31,-2,31,1007,31,0,33," +
                "1002,33,7,33,1,33,31,31,1,32,31,31,4,31,99,0,0,0",
                1,0,4,3,2
                );
        assertThat(output).isEqualTo(65210);
    }

}