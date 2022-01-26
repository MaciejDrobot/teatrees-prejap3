package com.epam.prejap.teatrees.game;

import org.apache.commons.cli.*;


/**
 * Provides methods to customize navigation keys.
 *
 * @author Maciej Drobot
 */
public class CustomNavigation {

	private CommandLine cmd;
	private CommandLineParser parser;

	public CustomNavigation() {
		this.parser = new BasicParser();
	}

	public char getNoneKey(String[] args) {
		char moveNone = ' ';
		Options options = new CommandLineOptions().getAllOptions();
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

	public char getLeftKey(String[] args) {
		char moveLeft = 'h';
		Options options = new CommandLineOptions().getAllOptions();
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

	public char getRightKey(String[] args) {
		char moveRight = 'l';
		Options options = new CommandLineOptions().getAllOptions();
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
