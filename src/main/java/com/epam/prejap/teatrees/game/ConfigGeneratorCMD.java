package com.epam.prejap.teatrees.game;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Generates game configuration based on provided command line options.
 * In case of no options provided returns default values.
 *
 * @author Maciej Drobot
 */
class ConfigGeneratorCMD {

	private CommandLine cmd;
	private CommandLineParser parser;

	ConfigGeneratorCMD(CommandLineParser parser) {
		this.parser = parser;
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
			System.err.println(e.getMessage());
		} finally {
			return defaultKey;
		}
	}

	private Options generateOptions() {
		var options = new Options();
		options.addOption(OptionsCMD.NONE.returnOption());
		options.addOption(OptionsCMD.LEFT.returnOption());
		options.addOption(OptionsCMD.RIGHT.returnOption());
		return options;
	}
}
