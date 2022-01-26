package com.epam.prejap.teatrees.player;

import com.epam.prejap.teatrees.game.Move;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Maciej Drobot
 */
public class CustomPlayerTest {

	@Test(dataProvider = "argsNoneMove")
	public void nextMoveShouldReturnMoveNone(String[] args, char input, Optional<Move> expected) {
		// given
		CustomPlayer player = new CustomPlayer(args);

		// when
		var actual = player.nextMove(input);

		// then
		assertEquals(actual, expected);
	}

	@Test(dataProvider = "argsLeftMove")
	public void nextMoveShouldReturnMoveLeft(String[] args, char input, Optional<Move> expected) {
		// given
		CustomPlayer player = new CustomPlayer(args);

		// when
		var actual = player.nextMove(input);

		// then
		assertEquals(actual, expected);
	}

	@Test(dataProvider = "argsRightMove")
	public void nextMoveShouldReturnMoveRight(String[] args, char input, Optional<Move> expected) {
		// given
		CustomPlayer player = new CustomPlayer(args);

		// when
		var actual = player.nextMove(input);

		// then
		assertEquals(actual, expected);
	}

	@DataProvider(name = "argsNoneMove")
	public static Object[][] provideDataForNoneMoveTest() {

		String[] args1 = {"-n", "s"};
		String[] args2 = {"-n", "none"};
		String[] args3 = {"-n", "1"};
		String[] args4 = {"-n", " "};
		String[] args5 = {"-w", "none existent option should return default key"};
		String[] args6 = {"-l", "none existent option should return default key"};

		return new Object[][]{
				{args1, 's', Optional.of(Move.NONE)},
				{args2, 'n', Optional.of(Move.NONE)},
				{args3, '1', Optional.of(Move.NONE)},
				{args4, ' ', Optional.of(Move.NONE)},
				{args5, ' ', Optional.of(Move.NONE)},
				{args6, ' ', Optional.of(Move.NONE)},
		};
	}

	@DataProvider(name = "argsLeftMove")
	public static Object[][] provideDataForLeftMoveTest() {

		String[] args1 = {"-l", "s"};
		String[] args2 = {"-l", "left"};
		String[] args3 = {"-l", "1"};
		String[] args4 = {"-l", " "};
		String[] args5 = {"-w", "none existent option should return default key"};
		String[] args6 = {"-r", "none existent option should return default key"};

		return new Object[][]{
				{args1, 's', Optional.of(Move.LEFT)},
				{args2, 'l', Optional.of(Move.LEFT)},
				{args3, '1', Optional.of(Move.LEFT)},
				{args4, ' ', Optional.of(Move.LEFT)},
				{args5, 'h', Optional.of(Move.LEFT)},
				{args6, 'h', Optional.of(Move.LEFT)},
		};
	}

	@DataProvider(name = "argsRightMove")
	public static Object[][] provideDataForRightMoveTest() {

		String[] args1 = {"-r", "s"};
		String[] args2 = {"-r", "right"};
		String[] args3 = {"-r", "1"};
		String[] args4 = {"-r", " "};
		String[] args5 = {"-w", "none existent option should return default key"};
		String[] args6 = {"-l", "none existent option should return default key"};

		return new Object[][]{
				{args1, 's', Optional.of(Move.RIGHT)},
				{args2, 'r', Optional.of(Move.RIGHT)},
				{args3, '1', Optional.of(Move.RIGHT)},
				{args4, ' ', Optional.of(Move.RIGHT)},
				{args5, 'l', Optional.of(Move.RIGHT)},
				{args6, 'l', Optional.of(Move.RIGHT)},
		};
	}

}