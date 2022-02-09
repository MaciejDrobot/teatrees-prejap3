package com.epam.prejap.teatrees.block;

/**
 * Holds action to be performed on every brick in {@link Block} rectangle
 * passed as parameter to {@link Block#forEachBrick(BrickAction) forEachBrick} method
 * @see com.epam.prejap.teatrees.block.Block
 */
@FunctionalInterface
public interface BrickAction {
    /**
     * Action called by {@link Block#forEachBrick(BrickAction) forEachBrick} method
     * @param   row
     *          row in {@link Block} rectangle
     * @param   col
     *          column in {@link Block} rectangle
     * @param   dotValue
     *          value of brick in {@link Block} with coordinates {row, col}
     * @see com.epam.prejap.teatrees.block.Block
     */
    void act(int row, int col, byte dotValue);
}
