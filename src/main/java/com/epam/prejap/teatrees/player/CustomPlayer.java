package com.epam.prejap.teatrees.player;

import com.epam.prejap.teatrees.game.GameConfig;
import com.epam.prejap.teatrees.game.Move;

import java.util.Optional;

/**
 *
 * @author Maciej Drobot
 */
public class CustomPlayer implements Player {

	public char leftKey;
	public char rightKey;
	public char noneKey;

	public CustomPlayer(GameConfig gameConfig) {
		this.leftKey = gameConfig.leftKey;
		this.rightKey = gameConfig.rightKey;
		this.noneKey = gameConfig.noneKey;
	}

	@Override
	public Optional<Move> nextMove() {
		return Optional.of(Move.NONE);
	}

	public Optional<Move> nextMove(char key) {
		if (key == leftKey) {
			return Optional.of(Move.LEFT);
		} else if (key == rightKey) {
			return Optional.of(Move.RIGHT);
		} else {
			return Optional.of(Move.NONE);
		}
	}
}
