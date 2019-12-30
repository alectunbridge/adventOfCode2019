package advent;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.abs;

public class DayThree {
    private int maxHeight;
    private int maxWidth;
    private int minHeight;
    private int minWidth;
    private char[][] circuitBoard1;
    private char[][] circuitBoard2;
    private String[] pathSegments1;
    private String[] pathSegments2;

    public int getMinHeight() {
        return minHeight;
    }

    public int getMinWidth() {
        return minWidth;
    }

    public char[][] getCircuitBoard1() {
        return circuitBoard1;
    }

    public char[][] getCircuitBoard2() {
        return circuitBoard2;
    }

    public DayThree(String wire1, String wire2) {
        pathSegments1 = wire1.split(",");
        pathSegments2 = wire2.split(",");
        calculateCircuitBoardDimensions(pathSegments1);
        calculateCircuitBoardDimensions(pathSegments2);
        circuitBoard1 = createEmptyCircuitBoard();
        circuitBoard2 = createEmptyCircuitBoard();
        addWireToCircuit(pathSegments1, circuitBoard1);
        addWireToCircuit(pathSegments2, circuitBoard2);
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public DayThree(String input) {
        String[] pathSegments = input.split(",");
        calculateCircuitBoardDimensions(pathSegments);
        circuitBoard1 = createEmptyCircuitBoard();
        addWireToCircuit(pathSegments, circuitBoard1);
    }

    private void addWireToCircuit(String[] pathSegments, char[][] circuitBoard) {
        int x = abs(minWidth);
        int y = abs(minHeight);

        for (String segment : pathSegments) {
            circuitBoard[y][x] = '+';
            int segmentLength = Integer.parseInt(segment.substring(1));
            switch (segment.charAt(0)) {
                case 'R':
                    for(int i=0; i<segmentLength; i++){
                        x++;
                        circuitBoard[y][x] = '-';
                    }
                    break;
                case 'L':
                    for(int i=0; i<segmentLength; i++){
                        x--;
                        circuitBoard[y][x] = '-';
                    }
                    break;
                case 'U':
                    for(int i=0; i<segmentLength; i++){
                        y++;
                        circuitBoard[y][x] = '|';
                    }
                    break;
                case 'D':
                    for(int i=0; i<segmentLength; i++){
                        y--;
                        circuitBoard[y][x] = '|';
                    }
                    break;
            }
        }
        circuitBoard[abs(minHeight)][abs(minWidth)] = 'o';
    }

    private char[][] createEmptyCircuitBoard() {
        char[][] circuitBoard = new char[abs(minHeight)+maxHeight+1][abs(minWidth)+maxWidth+1];
        for (char[] row : circuitBoard) {
            Arrays.fill(row, '.');
        }
        return circuitBoard;
    }

    private void calculateCircuitBoardDimensions(String[] pathSegments) {
        int width = 0;
        int height = 0;
        for (String segment : pathSegments) {
            int segmentLength = Integer.parseInt(segment.substring(1));
            switch (segment.charAt(0)) {
                case 'R':
                    width += segmentLength;
                    if(width > maxWidth){
                        maxWidth = width;
                    }
                    break;
                case 'L':
                    width -= segmentLength;
                    if(width < minWidth){
                        minWidth = width;
                    }
                    break;
                case 'U':
                    height += segmentLength;
                    if(height > maxHeight){
                        maxHeight = height;
                    }
                    break;
                case 'D':
                    height -= segmentLength;
                    if(height < minHeight){
                        minHeight = height;
                    }
                    break;
            }
        }
    }

    private List<int[]> findIntersections() {
        List<int[]> intersections = new ArrayList<>();
        for(int y=0; y < circuitBoard1.length; y++){
            for (int x = 0; x < circuitBoard1[0].length; x++) {
                if(circuitBoard1[y][x] != 'o' && circuitBoard1[y][x] != '.' && circuitBoard2[y][x] != '.'){
                    intersections.add(new int[]{x,y});
                }
            }
        }
        return intersections;
    }

    private int findLengthOfWireToIntersection(String[] pathSegments, int[] intersection) {
        int x = abs(minWidth);
        int y = abs(minHeight);
        int length = 0;
        for (String segment : pathSegments) {
            int segmentLength = Integer.parseInt(segment.substring(1));
            switch (segment.charAt(0)) {
                case 'R':
                    for(int i=0; i<segmentLength; i++){
                        x++;
                        length++;
                        if(x==intersection[0] && y==intersection[1]){
                            return length;
                        }
                    }
                    break;
                case 'L':
                    for(int i=0; i<segmentLength; i++){
                        x--;
                        length++;
                        if(x==intersection[0] && y==intersection[1]){
                            return length;
                        }
                    }
                    break;
                case 'U':
                    for(int i=0; i<segmentLength; i++){
                        y++;
                        length++;
                        if(x==intersection[0] && y==intersection[1]){
                            return length;
                        }
                    }
                    break;
                case 'D':
                    for(int i=0; i<segmentLength; i++){
                        y--;
                        length++;
                        if(x==intersection[0] && y==intersection[1]){
                            return length;
                        }
                    }
                    break;
            }
        }
        return -1;
    }

    public String drawCircuitBoard(char[][] circuitBoard) {
        StringBuilder output = new StringBuilder();
        for(int rowNo = circuitBoard.length-1; rowNo >= 0; rowNo--) {
            for (char cell : circuitBoard[rowNo]) {
                output.append(cell);
            }
            output.append("\n");
        }
        return output.toString();
    }

    public int findDistanceToClosestIntersection() {
        List<int[]> intersections = findIntersections();

        int closestIntersection = Integer.MAX_VALUE;
        for (int[] intersection : intersections) {
            int manhattanDistance = abs(-minWidth - intersection[0]) + abs(-minHeight - intersection[1]);
            if(manhattanDistance < closestIntersection){
                closestIntersection = manhattanDistance;
            }
        }

        return closestIntersection;
    }

    public int findShortestSignalDelay() {
        List<int[]> intersections = findIntersections();
        int shortestDistance = Integer.MAX_VALUE;
        for (int[] intersection : intersections) {
            int distance = findLengthOfWireToIntersection(pathSegments1, intersection) +
                    findLengthOfWireToIntersection(pathSegments2, intersection);
            if(distance<shortestDistance){
                shortestDistance = distance;
            }
        }
        return shortestDistance;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> input = null;

        Path path = Paths.get(DayThree.class.getClassLoader()
                .getResource("input_day3.txt").toURI());
        input = Files.readAllLines(path);

        DayThree dayThree = new DayThree(input.get(0),input.get(1));
        System.out.println(dayThree.findDistanceToClosestIntersection());
        System.out.println(dayThree.findShortestSignalDelay());
    }
}
