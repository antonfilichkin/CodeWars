package ConwayLife;

import java.util.stream.IntStream;

public class ConwayLife {

    public static int[][] getGeneration(int[][] cells, int generations) {
        return generations == 0 ? cells : getGeneration(trimBoard(newGeneration(addBrim(cells))), generations - 1);
    }

    private static int[][] addBrim(int[][] cells) {
        int ySize = cells.length;
        int xSize = cells[0].length;

        int[][] newCells = new int[ySize + 2][xSize + 2];

        int newCellsIndex = 1;
        for (int[] cell : cells) {
            System.arraycopy(cell, 0, newCells[newCellsIndex++], 1, xSize);
        }

        return newCells;
    }

    private static int[][] newGeneration(int[][] cells) {
        int ySize = cells.length;
        int xSize = cells[0].length;

        int[][] newGeneration = new int[ySize][xSize];
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                newGeneration[y][x] = calculateState(x, y, cells);
            }
        }

        return newGeneration;
    }

    private static int calculateState(int x, int y, int[][] cells) {
        int boardSizeY = cells.length;
        int boardSizeX = cells[0].length;
        int neighbours = 0;

        for (int currentNeighbourY = y - 1; currentNeighbourY <= y + 1; currentNeighbourY++) {
            if (currentNeighbourY >= 0 && currentNeighbourY < boardSizeY) {
                for (int currentNeighbourX = x - 1; currentNeighbourX <= x + 1; currentNeighbourX++) {
                    if (currentNeighbourX >= 0 && currentNeighbourX < boardSizeX) {
                        if (currentNeighbourY != y || currentNeighbourX != x) {
                            neighbours += cells[currentNeighbourY][currentNeighbourX];
                        }
                    }
                }
            }
        }

        return neighbours < 2 || neighbours > 3 ? 0 : neighbours == 3 || isLive(y, x, cells) ? 1 : 0;
    }

    private static int[][] trimBoard(int[][] cells) {
        int yStartTrimIndex = 0;
        int yEndTrimIndex = cells.length;
        int xStartTrimIndex = 0;
        int xEndTrimIndex = cells[0].length;

        for (int y = 0; y < cells.length; y++) {
            if (rowContainsLiveCell(y, cells)) {
                break;
            }
            yStartTrimIndex++;
        }

        for (int y = cells.length - 1; y >= yStartTrimIndex; y--) {
            if (rowContainsLiveCell(y, cells)) {
                break;
            }
            yEndTrimIndex--;
        }

        for (int x = 0; x < cells[0].length; x++) {
            if (columnContainsLiveCell(x, cells)) {
                break;
            }
            xStartTrimIndex++;
        }

        for (int x = cells[0].length - 1; x >= xStartTrimIndex; x--) {
            if (columnContainsLiveCell(x, cells)) {
                break;
            }
            xEndTrimIndex--;
        }

        int newSizeY = yEndTrimIndex - yStartTrimIndex;
        int newSizeX = xEndTrimIndex - xStartTrimIndex;

        int[][] trimmedArray = new int[newSizeY][newSizeX];
        int trimmedArrayIndex = 0;
        for (int y = yStartTrimIndex; y < yEndTrimIndex; y++) {
            System.arraycopy(cells[y], xStartTrimIndex, trimmedArray[trimmedArrayIndex++], 0, newSizeX);
        }

        return trimmedArray;
    }

    private static boolean rowContainsLiveCell(int rowIndex, int[][] cells) {
        return IntStream.range(0, cells[rowIndex].length).anyMatch(x -> isLive(rowIndex, x, cells));
    }

    private static boolean columnContainsLiveCell(int columnIndex, int[][] cells) {
        return IntStream.range(0, cells.length).anyMatch(y -> isLive(y, columnIndex, cells));
    }

    private static boolean isLive(int y, int x, int[][] cells) {
        return cells[y][x] == 1;
    }
}