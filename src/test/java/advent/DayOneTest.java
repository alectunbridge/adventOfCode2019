package advent;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DayOneTest {

    private DayOne dayOne;

    @Before
    public void setUp() throws Exception {
        dayOne = new DayOne();
    }

    @Test
    public void calculateFuelForMassOf12() {
        int fuel = dayOne.calculateFuelRequired(12);
        assertThat(fuel).isEqualTo(2);
    }

    @Test
    public void calculateFuelForMassOf14() {
        int fuel = dayOne.calculateFuelRequired(14);
        assertThat(fuel).isEqualTo(2);
    }

    @Test
    public void calculateFuelForMassOf1969() {
        int fuel = dayOne.calculateFuelRequired(1969);
        assertThat(fuel).isEqualTo(654);
    }

    @Test
    public void calculateFuelForMassOf100756() {
        int fuel = dayOne.calculateFuelRequired(100756);
        assertThat(fuel).isEqualTo(33583);
    }
}
