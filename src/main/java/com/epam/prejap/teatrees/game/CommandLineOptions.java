package com.epam.prejap.teatrees.game;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * Holds definitions of all options available through the command line.
 * Can be extended with more option definitions.
 *
 * @author Maciej Drobot
 */
class CommandLineOptions {

	private final Option NONE =
			new Option("n", "none", true, "Key for NONE move.");

	private final Option LEFT =
			new Option("l", "left", true, "Key for LEFT move.");

	private final Option RIGHT =
			new Option("r", "right", true, "Key for RIGHT move.");


	Options getAllOptions() {
		Options options = new Options();
		options.addOption(NONE);
		options.addOption(LEFT);
		options.addOption(RIGHT);
		return options;
	}
}
