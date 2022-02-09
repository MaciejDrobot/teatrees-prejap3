package com.epam.prejap.teatrees.block;

public abstract class Block {

    final byte[][] image;
    final int rows;
    final int cols;

    Block(byte[][] dots) {
        rows = dots.length;
        if (dots.length == 0) {
            throw new IllegalArgumentException("Image has height equal to 0");
        }
        cols = dots[0].length;
        image = new byte[rows][cols];
        for (int i = 0; i < dots.length; i++) {
            if (dots[i].length != cols) {
                throw new IllegalArgumentException("Image is not a rectangle");
            }
            for (int j = 0; j < cols; j++) {
                byte dot = dots[i][j];
                if (dot < 0) {
                    throw new IllegalArgumentException("Invalid dot value");
                }
                image[i][j] = dot;
            }
        }
    }

    /**
     * Iterates over all rows and columns and calls action for every brick
     * @param   action
     *          {@link BrickAction} to be called for each brick in block
     * @see com.epam.prejap.teatrees.block.BrickAction
     */
    public void forEachBrick(BrickAction action) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                var dot = image[i][j];
                if (dot > 0) {
                    action.act(i, j, dot);
                }
            }
        }
    }

    public int rows() {
        return rows;
    }

    public int cols() {
        return cols;
    }

    public byte dotAt(int i, int j) {
        return image[i][j];
    }

}
