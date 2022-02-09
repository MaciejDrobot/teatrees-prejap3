package com.epam.prejap.teatrees.block;

import java.util.Random;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.testng.Assert.fail;

public class BrickActionTest {
  @DataProvider
  private static Object[][] allBlocks() {
    return new Object[][]{
      { new OBlock() },
      { new SBlock() },
      { new HBlock() },
      { new LBlock() },
      { new YBlock() },
      { new ZBlock() }
    };
  }

  @Test(groups = "blocks", dataProvider = "allBlocks")
  public void allNonZeroBricksSetToGivenSymbolWithForEachBrickMethod(Block block) {
    // Given
    final var SYM = (byte) new Random().nextInt(Byte.MAX_VALUE);
    final var grid = new byte[block.rows][block.cols];

    // When
    block.forEachBrick((i, j, dot) -> grid[i][j] = SYM);

    // Then
    var sa = new SoftAssert();
    for(int i = 0; i < grid.length; ++i) {
      for(int j = 0; j < grid[i].length; ++j) {
        if (0 == block.image[i][j]) {
          sa.assertEquals(0, grid[i][j], String.format("Value at row %d, col %d", i, j));
        } else {
          sa.assertEquals(SYM, grid[i][j], String.format("Value at row %d, col %d", i, j));
        }
      }
    }
    sa.assertAll();
  }

  @Test(groups = "blocks", dataProvider = "allBlocks", expectedExceptions = ArrayIndexOutOfBoundsException.class)
  public void forEachBrickDoesNotHandleExceptions(Block block) {
    // Given
    final var sym = (byte) new Random().nextInt(Byte.MAX_VALUE);
    final var grid = new byte[block.rows][block.cols];

    // When
    block.forEachBrick((i, j, dot) -> grid[i - grid.length][j - grid[i].length] = sym);

    // Then
    fail();
  }
}
