package advent;

import java.util.Arrays;

public class DayThree {
    private char[][] circuitBoard;
    private int maxHeight;
    private int maxWidth;

    public int getMaxWidth() {
        return maxWidth;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public DayThree(String input) {
        String[] pathSegments = input.split(",");
        calculateCircuitBoardDimensions(pathSegments);
        createEmptyCircuitBoard();
        addWireToCircuit(pathSegments);
    }

    private void addWireToCircuit(String[] pathSegments) {
        int x = 0;
        int y = 0;

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
        circuitBoard[0][0] = 'o';
    }

    private void createEmptyCircuitBoard() {
        circuitBoard = new char[maxHeight][maxWidth];
        for (char[] row : circuitBoard) {
            Arrays.fill(row, '.');
        }
    }

    private void calculateCircuitBoardDimensions(String[] pathSegments) {
        int width = 1;
        int height = 1;
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
                    break;
                case 'U':
                    height += segmentLength;
                    if(height > maxHeight){
                        maxHeight = height;
                    }
                case 'D':
                    height -= segmentLength;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for(int rowNo = circuitBoard.length-1; rowNo >= 0; rowNo--) {
            for (char cell : circuitBoard[rowNo]) {
                output.append(cell);
            }
            output.append("\n");
        }
        return output.toString();
    }
}
