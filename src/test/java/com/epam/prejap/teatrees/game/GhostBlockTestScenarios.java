package com.epam.prejap.teatrees.game;

import com.epam.prejap.teatrees.block.Block;
import com.epam.prejap.teatrees.block.BlockSupplier;
import com.epam.prejap.teatrees.block.SingleBlockFeed;

import java.util.function.Supplier;

/**
 * Scenarios for unit tests in {@link BlockShadowTest}
 */
class GhostBlockTestScenarios {
  record FieldMoveDataset(byte[][] grid, Move move) {}
  record Scenario(BlockSupplier feed, byte[][] initialGrid, FieldMoveDataset[] moves) {
    Playfield createPlayfield() {
      return new Playfield(
        initialGrid.length, initialGrid[0].length,
        feed,
        new Printer(System.out)
      );
    }
  }

  static final Scenario OBLOCK_SCENARIO = new Scenario(
    SingleBlockFeed.O_BLOCK.feed(),
    new byte[][] {
      {0, 1, 1, 0},
      {0, 1, 1, 0},
      {0, 0, 0, 0},
      {0, '.', '.', 0},
      {0, '.', '.', 0}
    },
    new FieldMoveDataset[]{
      new FieldMoveDataset( new byte[][]{
        {0, 0, 0, 0},
        {1, 1, 0, 0},
        {1, 1, 0, 0},
        {'.', '.', 0, 0},
        {'.', '.', 0, 0},
      }, Move.LEFT),
      new FieldMoveDataset( new byte[][]{
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 1, 1, 0},
        {0, 1, 1, 0},
        {0, '.', '.', 0},
      }, Move.RIGHT),
      new FieldMoveDataset( new byte[][]{
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 1, 1},
        {0, 0, 1, 1},
      }, Move.RIGHT)
    }
  );

  static final Scenario ZBLOCK_SCENARIO = new Scenario(
    SingleBlockFeed.Z_BLOCK.feed(),
    new byte[][] {
    {1, 1, 0, 0},
    {0, 1, 1, 0},
    {0, 0, 0, 0},
    {'.', '.', 0, 0},
    {0, '.', '.', 0}
  },
    new FieldMoveDataset[]{
    new FieldMoveDataset( new byte[][]{
      {0, 0, 0, 0},
      {1, 1, 0, 0},
      {0, 1, 1, 0},
      {'.', '.', 0, 0},
      {0, '.', '.', 0},
    }, Move.LEFT),
      new FieldMoveDataset( new byte[][]{
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 1, 1, 0},
        {0, '.', 1, 1},
        {0, 0, '.', '.'},
      }, Move.RIGHT),
      new FieldMoveDataset( new byte[][]{
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 1, 1, 0},
        {0, 0, 1, 1},
      }, Move.RIGHT)
    }
  );

  static final Scenario SBLOCK_SCENARIO = new Scenario(
    SingleBlockFeed.S_BLOCK.feed(),
    new byte[][] {
      {0, 1, 1, 0},
      {1, 1, 0, 0},
      {0, 0, 0, 0},
      {0, '.', '.', 0},
      {'.', '.', 0, 0}
    },
    new FieldMoveDataset[]{
      new FieldMoveDataset( new byte[][]{
        {0, 0, 0, 0},
        {0, 0, 1, 1},
        {0, 1, 1, 0},
        {0, 0, '.', '.'},
        {0, '.', '.', 0},
      }, Move.RIGHT),
      new FieldMoveDataset( new byte[][]{
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 1, 0, 0},
        {0, 1, 1, 0},
        {0, 0, 1, 0},
      }, Move.UP)
    }
  );

  static final Scenario HBLOCK_SCENARIO = new Scenario(
    SingleBlockFeed.H_BLOCK.feed(),
    new byte[][] {
      {0, 1, 0, 1, 0},
      {0, 1, 1, 1, 0},
      {0, 1, 0, 1, 0},
      {0, '.', 0, '.', 0},
      {0, '.', '.', '.', 0},
      {0, '.', 0, '.', 0}
    },
    new FieldMoveDataset[]{
      new FieldMoveDataset( new byte[][]{
        {0, 0, 0, 0, 0},
        {0, 1, 1, 1, 0},
        {0, 0, 1, 0, 0},
        {0, 1, 1, 1, 0},
        {0, 0, '.', 0, 0},
        {0, '.', '.', '.', 0}
      }, Move.UP),
      new FieldMoveDataset( new byte[][]{
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 1, 1, 1},
        {0, 0, '.', 1, '.'},
        {0, 0, 1, 1, 1},
        {0, 0, '.', '.', '.'}
      }, Move.RIGHT),
      new FieldMoveDataset( new byte[][]{
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 1, 1, 1, 0},
        {0, 0, 1, 0, 0},
        {0, 1, 1, 1, 0},
      }, Move.LEFT)
    }
  );

  static final Scenario YBLOCK_SCENARIO = new Scenario(
    SingleBlockFeed.Y_BLOCK.feed(),
    new byte[][] {
      {0, 1, 0, 1, 0},
      {0, 0, 1, 0, 0},
      {0, 0, 1, 0, 0},
      {0, '.', 0, '.', 0},
      {0, 0, '.', 0, 0},
      {0, 0, '.', 0, 0}
    },
    new FieldMoveDataset[]{
      new FieldMoveDataset( new byte[][]{
        {0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0},
        {0, 1, 1, 0, 0},
        {0, 0, 0, 1, 0},
        {0, '.', '.', 0, 0},
        {0, 0, 0, '.', 0},
      }, Move.UP),
      new FieldMoveDataset( new byte[][]{
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 1, '.', 1, 0},
        {0, '.', 0, '.', 0},
      }, Move.UP),
      new FieldMoveDataset( new byte[][]{
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0},
        {0, 1, 0, 0, 0},
        {1, 0, 1, 0, 0}
      }, Move.LEFT)
    }
  );

  static final Scenario LBLOCK_SCENARIO = new Scenario(
    SingleBlockFeed.L_BLOCK.feed(),
    new byte[][] {
      {0, 1, 0, 0},
      {0, 1, 0, 0},
      {0, 1, 1, 0},
      {0, '.', 0, 0},
      {0, '.', 0, 0},
      {0, '.', '.', 0}
    },
    new FieldMoveDataset[]{
      new FieldMoveDataset( new byte[][]{
        {0, 0, 0, 0},
        {1, 0, 0, 0},
        {1, 0, 0, 0},
        {1, 1, 0, 0},
        {'.', 0, 0, 0},
        {'.', '.', 0, 0},
      }, Move.LEFT),
      new FieldMoveDataset( new byte[][]{
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {1, 1, 1, 0},
        {1, 0, 0, 0},
        {'.', '.', '.', 0},
        {'.', 0, 0, 0},
      }, Move.UP),
      new FieldMoveDataset( new byte[][]{
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 1, 1, 1},
        {0, 1, '.', '.'},
        {0, '.', 0, 0},
      }, Move.RIGHT),
      new FieldMoveDataset( new byte[][]{
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 1, 1, 0},
        {0, 0, 1, 0},
        {0, 0, 1, 0},
      }, Move.UP)
    }
  );

}
