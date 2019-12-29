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
    public void findDistanceToClosestIntersection() {
        DayThree dayThree = new DayThree("R8,U5,L5,D3", "U7,R6,D4,L4");
        assertThat(dayThree.findDistanceToClosestIntersection()).isEqualTo(6);
    }
}