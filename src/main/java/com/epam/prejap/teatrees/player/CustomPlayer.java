package com.epam.prejap.teatrees.player;

import com.epam.prejap.teatrees.game.GameConfig;
import com.epam.prejap.teatrees.game.Move;

import java.util.Optional;

/**
 * Implementation of Player with overloaded nextMove() method.
 * Overloaded method allows using input.
 * Initialized with game config - allowing for customized navigation.
 *
 * @author Maciej Drobot
 */
public class CustomPlayer implements Player {

	private char leftKey;
	private char rightKey;
	private char noneKey;

	public CustomPlayer(GameConfig gameConfig) {
		this.leftKey = gameConfig.moveLeft();
		this.rightKey = gameConfig.moveRight();
		this.noneKey = gameConfig.moveNone();
	}

	@Override
	public Optional<Move> nextMove() {
		return Optional.of(Move.NONE);
	}

	/**
	 * Returns Optional of Move depending on the input.
	 *
	 * @param key
	 * @return Optional of Move
	 */
	public Optional<Move> nextMove(char key) {
		if (key == leftKey) {
			return Optional.of(Move.LEFT);
		} else if (key == rightKey) {
			return Optional.of(Move.RIGHT);
		} else {
			return nextMove();
		}
	}
}
