package com.epam.prejap.teatrees.game;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.ParseException;

import java.io.PrintStream;

/**
 * Generates game configuration based on provided command line options.
 * In case of no options provided returns default values.
 *
 * @author Maciej Drobot
 */
public class ConfigGenerator {

	private CommandLine cmd;
	private CommandLineParser parser;
	private final Printer printer;

	public ConfigGenerator(CommandLineParser parser, PrintStream out) {
		this.parser = parser;
		this.printer = new Printer(out);
	}

	/**
	 * Returns game configuration.
	 *
	 * @param args
	 * @return GameConfig
	 */
	public GameConfig getConfigFromCommandLine(String[] args) {
		var config = new GameConfig(
				getKey(args, 'n',' '),
				getKey(args, 'l','h'),
				getKey(args, 'r','l'));
		return config;
	}

	private char getKey(String[] args, char option, char defaultKey) {
		var options = generateOptions();
		try {
			cmd = parser.parse(options, args);
			if(cmd.hasOption(option)) {
				defaultKey = cmd.getOptionValue(option).charAt(0);
			}
		} catch (ParseException e) {
			printer.out.println(e.getMessage());
		}
		return defaultKey;
	}

	private org.apache.commons.cli.Options generateOptions() {
		var options = new org.apache.commons.cli.Options();
		options.addOption(Options.NONE.returnOption());
		options.addOption(Options.LEFT.returnOption());
		options.addOption(Options.RIGHT.returnOption());
		return options;
	}
}
