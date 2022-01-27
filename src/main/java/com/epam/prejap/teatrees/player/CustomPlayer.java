package com.epam.prejap.teatrees.player;

import com.epam.prejap.teatrees.game.Move;
import org.apache.commons.cli.*;

import java.util.Optional;

/**
 * Implementation of Player which allows using customized navigation.
 * Command line options are passed during initialization.
 * If correct options provided - overloaded nextMove() should respond according to the customized keys.
 * In case of no options/incorrect options default keys are used.
 *
 *
 * @author Maciej Drobot
 */
public class CustomPlayer implements Player {

	private final Option NONE =
			new Option("n", "none", true, "Key for NONE move.");
	private final Option LEFT =
			new Option("l", "left", true, "Key for LEFT move.");
	private final Option RIGHT =
			new Option("r", "right", true, "Key for RIGHT move.");
	private Options options;

	{
		options = new Options();
		options.addOption(NONE);
		options.addOption(LEFT);
		options.addOption(RIGHT);
	}

	private char moveNoneKey;
	private char moveLeftKey;
	private char moveRightKey;

	private CommandLine cmd;
	private CommandLineParser parser;

	public CustomPlayer(String[] args) {
		this.parser = new BasicParser();
		this.moveNoneKey = getNoneKey(args);
		this.moveLeftKey = getLeftKey(args);
		this.moveRightKey = getRightKey(args);
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

	private char getNoneKey(String[] args) {
		char moveNone = ' ';
		try {
			cmd = parser.parse(options, args);
			if(cmd.hasOption("n")) {
				moveNone = cmd.getOptionValue("n").charAt(0);
			}
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		} finally {
			return moveNone;
		}
	}

	private char getLeftKey(String[] args) {
		char moveLeft = 'h';
		try {
			cmd = parser.parse(options, args);
			if(cmd.hasOption("l")) {
				moveLeft = cmd.getOptionValue("l").charAt(0);
			}
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		} finally {
			return moveLeft;
		}
	}

	private char getRightKey(String[] args) {
		char moveRight = 'l';
		try {
			cmd = parser.parse(options, args);
			if (cmd.hasOption("r")) {
				moveRight = cmd.getOptionValue("r").charAt(0);
			}
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		} finally {
			return moveRight;
		}
	}
}
