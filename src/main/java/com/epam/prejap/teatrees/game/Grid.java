package com.epam.prejap.teatrees.game;

import java.util.Arrays;

/**
 * Keeps state of playing grid and manipulates it.
 * Verifies and removes complete lines in playfield grid.
 *
 * @author Piotr Chowaniec
 */
class Grid {
    private final byte[][] grid;

    Grid(byte[][] grid) {
        this.grid = grid;
    }

    /**
     * Grid is being checked from bottom to top one by one. While complete line is found then it is being removed,
     * lines above are being moved one position down, empty line is being added on the top.
     */
    void removeCompleteLines() {
        for (int i = grid.length - 1; i > 0; i--) {
            if (isLineComplete(grid[i])) {
                moveLinesAboveOnePositionDown(i++);
                addEmptyLineOnTop();
            }
        }
        if (isLineComplete(grid[0])) {
            addEmptyLineOnTop();
        }
    }

    private boolean isLineComplete(byte[] line) {
        return line.length == sumLineValues(line);
    }

    /**
     * If given {@code byte[] line} sum of fields with values grater than 0 is equal to its length, then return true.
     *
     * @param line single byte array from grid.
     * @return sum of fields with values grater than 0 in given line.
     */
    private int sumLineValues(byte[] line) {
        int counter = 0;
        for (byte b : line) {
            if (b > 0) {
                counter++;
            }
        }
        return counter;
    }

    private void moveLinesAboveOnePositionDown(int lineCounter) {
        for (int i = lineCounter; i > 0; i--) {
            grid[i] = grid[i - 1];
        }
    }

    private void addEmptyLineOnTop() {
        grid[0] = new byte[grid[0].length];
    }

    /**
     * Verifies if cell with given indexes is empty.
     *
     * @param newRow first index of element.
     * @param newCol second index of element.
     * @return true if value == 0, false otherwise.
     */
    boolean isCellEmpty(int newRow, int newCol) {
        return grid[newRow][newCol] == 0;
    }

    /**
     * Sets element with given indexes to 0.
     *
     * @param row first index of element.
     * @param col second index of element.
     */
    void cleanCell(int row, int col) {
        grid[row][col] = 0;
    }

    /**
     * Sets element with given indexes to representation of {@link BrickRepresentation#SHADOW}.
     *
     * @param row first index of element.
     * @param col second index of element.
     */
    void shadowCell(int row, int col) {
        grid[row][col] = BrickRepresentation.SHADOW.asByte();
    }

    /**
     * Sets passed value to element with given indexes.
     *
     * @param row first index of element.
     * @param col second index of element.
     * @param dot value to be set.
     */
    void fillCell(int row, int col, byte dot) {
        grid[row][col] = dot;
    }

    /**
     * Returns grid array. Used by {@link Printer#draw(byte[][])}
     *
     * @return return current state of byte array.
     */
    byte[][] getGrid() {
        return grid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grid grid1 = (Grid) o;
        return Arrays.deepEquals(grid, grid1.grid);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(grid);
    }
}
