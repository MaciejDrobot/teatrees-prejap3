package com.epam.prejap.teatrees.game;

import com.epam.prejap.teatrees.game.GhostBlockTestScenarios.Scenario;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;

public class BlockShadowTest {
  private ByteArrayOutputStream expected;
  private ByteArrayOutputStream actual;
  private Printer printer;

  @BeforeMethod
  private void setup() {
    expected = new ByteArrayOutputStream();
    actual = new ByteArrayOutputStream();
    printer = new Printer(new PrintStream(actual, true));
    System.setOut(new PrintStream(expected, true));
  }

  @AfterMethod
  private void cleanup() {
    System.setOut(System.out);
  }

  @DataProvider
  private static Object[][] shadowBlockTestScenarios() {
    return new Object[][]{
      { GhostBlockTestScenarios.HBLOCK_SCENARIO },
      { GhostBlockTestScenarios.LBLOCK_SCENARIO },
      { GhostBlockTestScenarios.OBLOCK_SCENARIO },
      { GhostBlockTestScenarios.SBLOCK_SCENARIO },
      { GhostBlockTestScenarios.YBLOCK_SCENARIO },
      { GhostBlockTestScenarios.ZBLOCK_SCENARIO }
    };
  }

  @Test(groups = "game", dataProvider = "shadowBlockTestScenarios")
  public void initialGridValidShadow(Scenario scenario) {
    // Given dp

    // When
    var field = scenario.createPlayfield();
    field.nextBlock();
    printer.draw(scenario.initialGrid(), scenario.feed().nextBlock());

    // Then
    assertEquals(actual.toString(), expected.toString());
  }

  @Test(groups = "game", dataProvider = "shadowBlockTestScenarios")
  public void blockMovesValidShadow(Scenario scenario) {
    // Given

    // When
    var field = scenario.createPlayfield();
    field.nextBlock();
    printer.draw(scenario.initialGrid(), scenario.feed().nextBlock());
    for (var move : scenario.moves()) {
      field.move(move.move());
      printer.draw(move.grid(), scenario.feed().nextBlock());
    }

    // Then
    assertEquals(actual.toString(), expected.toString());
  }
}
