package com.epam.prejap.teatrees.player;

import com.epam.prejap.teatrees.game.GameConfig;
import com.epam.prejap.teatrees.game.Move;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Maciej Drobot
 */
public class CustomPlayerTest {

	@Test(dataProvider = "input")
	public void nextReturnCorrectMove(char input, Optional<Move> expected) {
		// given
		GameConfig config = new GameConfig('l', 'r', 'n');
		CustomPlayer player = new CustomPlayer(config);

		// when
		var actual = player.nextMove(input);

		// then
		assertEquals(actual, expected);
	}

	@DataProvider(name = "input")
	public static Object[][] provideDataForNoneMoveTest() {

		return new Object[][]{
				{'l', Optional.of(Move.LEFT)},
				{'r', Optional.of(Move.RIGHT)},
				{'n', Optional.of(Move.NONE)},
				{'1', Optional.of(Move.NONE)},
				{'G', Optional.of(Move.NONE)},
		};
	}
}