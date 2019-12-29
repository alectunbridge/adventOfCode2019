package advent;


import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

public class DayThreeTest {

    @Test
    public void testWidthAndHeight() {
        DayThree dayThree = new DayThree("R8,U5,L5,D3");
        assertThat(dayThree.getMaxWidth()).isEqualTo(9);
        assertThat(dayThree.getMaxHeight()).isEqualTo(6);

    }

    @Test
    public void printFirstWire() {
        DayThree dayThree = new DayThree("R8,U5,L5,D3");
        assertThat(dayThree.drawCircuitBoard(dayThree.getCircuitBoard1())).isEqualTo(
                        "...+----+\n" +
                        "...|....|\n" +
                        "...|....|\n" +
                        "...|....|\n" +
                        "........|\n" +
                        "o-------+\n"
        );
    }

    @Test
    public void printSecondWire() {
        DayThree dayThree = new DayThree("R8,U5,L5,D3", "U7,R6,D4,L4");
        assertThat(dayThree.drawCircuitBoard(dayThree.getCircuitBoard2())).isEqualTo(
                        "+-----+..\n" +
                        "|.....|..\n" +
                        "|.....|..\n" +
                        "|.....|..\n" +
                        "|.----+..\n" +
                        "|........\n" +
                        "|........\n" +
                        "o........\n");
    }

    @Test
    public void findsIntersections() {
        DayThree dayThree = new DayThree("R8,U5,L5,D3", "U7,R6,D4,L4");
        assertThat(dayThree.findIntersections()).containsExactly(
                new int[]{0,0},
                new int[]{3,3},
                new int[]{6,5});
    }
}