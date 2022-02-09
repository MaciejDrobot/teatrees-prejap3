package com.epam.prejap.teatrees.game;

import org.apache.commons.cli.Option;

/**
 * Holding definitions of options available through the command line.
 *
 * @author Maciej Drobot
 */
public enum Options {

	NONE ("n", true, "Key for NONE move."){
	},
	LEFT ("l", true, "Key for LEFT move."){
	},
	RIGHT ("r", true, "Key for RIGHT move."){
	};

	private String option;
	private boolean hasArg;
	private  String description;

	Options(String option, boolean hasArg, String description) {
		this.option = option;
		this.hasArg = hasArg;
		this.description = description;
	}

	public Option returnOption() {
		return new Option(option, hasArg, description);
	}
}
