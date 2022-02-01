package com.epam.prejap.teatrees.game;

import org.apache.commons.cli.*;

/**
 * @author Maciej Drobot
 */
class ConfigGeneratorCMD {

	private final Option NONE =
			new Option("n", "none", true, "Key for NONE move.");
	private final Option LEFT =
			new Option("l", "left", true, "Key for LEFT move.");
	private final Option RIGHT =
			new Option("r", "right", true, "Key for RIGHT move.");
	private Options options;

	private CommandLine cmd;
	private CommandLineParser parser;

	{
		options = new Options();
		options.addOption(NONE);
		options.addOption(LEFT);
		options.addOption(RIGHT);
	}

	ConfigGeneratorCMD() {
		this.parser = new BasicParser();
	}

	public GameConfig getConfigFromCommandLine(String[] args) {
		var config = new GameConfig(
				getLeftKey(args),
				getRightKey(args),
				getNoneKey(args));
		return config;
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
