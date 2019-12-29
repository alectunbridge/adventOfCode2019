package advent;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DayThreeTest {

    @Test
    public void testWidthAndHeight() {
        DayThree dayThree = new DayThree("R8,U5,L5,D3");
        assertThat(dayThree.getMaxWidth()).isEqualTo(8);
        assertThat(dayThree.getMaxHeight()).isEqualTo(5);
        assertThat(dayThree.getMinWidth()).isEqualTo(0);
        assertThat(dayThree.getMinHeight()).isEqualTo(0);

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
    public void findDistanceToClosestIntersection1() {
        DayThree dayThree = new DayThree("R8,U5,L5,D3", "U7,R6,D4,L4");
        assertThat(dayThree.findDistanceToClosestIntersection()).isEqualTo(6);
    }

    @Test
    public void findDistanceToClosestIntersection2() {
        DayThree dayThree = new DayThree("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83");
        assertThat(dayThree.getMaxHeight()).isEqualTo(117);
        assertThat(dayThree.findDistanceToClosestIntersection()).isEqualTo(159);
    }
}