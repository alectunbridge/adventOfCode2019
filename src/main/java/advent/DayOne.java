package advent;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DayOne {

    public int calculateFuelRequired(int mass) {
        return (int) Math.floor(mass / 3.0) - 2;
    }

    public static void main(String[] args) {
        DayOne dayOne = new DayOne();
        Path path = null;
        Stream<String> lines = null;
        try {
            path = Paths.get(DayOne.class.getClassLoader()
                    .getResource("input_day1.txt").toURI());
            lines = Files.lines(path);
            int result = lines.mapToInt(s->dayOne.calculateFuelRequired(Integer.parseInt(s))).sum();
            System.out.println(result);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            lines.close();
        }

    }
}
