package com.epam.prejap.teatrees.game;

/**
 * @author Maciej Drobot
 */
public class GameConfig {

	public char leftKey;
	public char rightKey;
	public char noneKey;

	public GameConfig(char leftKey, char rightKey, char noneKey) {
		this.leftKey = leftKey;
		this.rightKey = rightKey;
		this.noneKey = noneKey;
	}
}
