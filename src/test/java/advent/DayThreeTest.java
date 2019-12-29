package advent;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DayThreeTest {

    @Test
    public void testWidthAndHeight() {
        DayThree dayThree = new DayThree("R8,U5,L5,D3");
        assertThat(dayThree.getMaxWidth()).isEqualTo(9);
        assertThat(dayThree.getMaxHeight()).isEqualTo(6);

    }

    @Test
    public void printWire() {
        DayThree dayThree = new DayThree("R8,U5,L5,D3");
        assertThat(dayThree.toString()).isEqualTo(
                        "...+----+\n" +
                        "...|....|\n" +
                        "...|....|\n" +
                        "...|....|\n" +
                        "........|\n" +
                        "+-------+\n"
        );

    }
}