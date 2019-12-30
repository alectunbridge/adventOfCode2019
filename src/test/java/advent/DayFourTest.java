package advent;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DayFourTest {

    @Test
    public void checkPasswordRules() {
        DayFour dayFour = new DayFour();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(dayFour.isValid(122345)).isTrue();
        softly.assertThat(dayFour.isValid(123789)).isFalse();
        softly.assertThat(dayFour.isValid(111123)).isFalse();
        softly.assertThat(dayFour.isValid(112233)).isTrue();
        softly.assertThat(dayFour.isValid(123444)).isFalse();
        softly.assertThat(dayFour.isValid(111122)).isTrue();
        softly.assertThat(dayFour.isValid(223450)).isFalse();
        softly.assertAll();
    }
}