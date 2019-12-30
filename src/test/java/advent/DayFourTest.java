package advent;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DayFourTest {

    @Test
    public void twoAdjacentDigits() {
        DayFour dayFour = new DayFour();
        assertThat(dayFour.isValid(122345)).isTrue();
        assertThat(dayFour.isValid(123789)).isFalse();
    }

    @Test
    public void numbersNeverDecrease() {
        DayFour dayFour = new DayFour();
        assertThat(dayFour.isValid(111123)).isTrue();
        assertThat(dayFour.isValid(223450)).isFalse();
    }
}