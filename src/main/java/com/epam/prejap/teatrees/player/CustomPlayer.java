package com.epam.prejap.teatrees.player;

import com.epam.prejap.teatrees.game.CustomNavigation;
import com.epam.prejap.teatrees.game.Move;

import java.util.Optional;

/**
 * Implementation of Player with overloaded nextMove() method.
 * Overloaded method allows using input.
 *
 * @author Maciej Drobot
 */
public class CustomPlayer implements Player {

	private char moveNoneKey;
	private char moveLeftKey;
	private char moveRightKey;

	private CustomNavigation customNavigation;

	public CustomPlayer(String[] args) {
		this.customNavigation = new CustomNavigation();
		this.moveNoneKey = customNavigation.getNoneKey(args);
		this.moveLeftKey = customNavigation.getLeftKey(args);
		this.moveRightKey = customNavigation.getRightKey(args);
	}

	@Override
	public Optional<Move> nextMove() {
		return Optional.of(Move.NONE);
	}

	public Optional<Move> nextMove(char key) {
		if (key == moveLeftKey) {
			return Optional.of(Move.LEFT);
		} else if (key == moveRightKey) {
			return Optional.of(Move.RIGHT);
		} else {
			return Optional.of(Move.NONE);
		}
	}
}
