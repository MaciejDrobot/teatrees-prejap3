package com.epam.prejap.teatrees.game;

import org.apache.commons.cli.Option;

/**
 * Holding definitions of options available through the command line.
 *
 * @author Maciej Drobot
 */
public enum OptionsCMD {

	NONE {
		@Override
		public Option returnOption() {
			return new Option("n", "none", true, "Key for NONE move.");
		}
	},
	LEFT {
		@Override
		public Option returnOption() {
			return new Option("l", "left", true, "Key for LEFT move.");
		}
	},
	RIGHT {
		@Override
		public Option returnOption() {
				return new Option("r", "right", true, "Key for RIGHT move.");
			}
	};

	public abstract Option returnOption();
}
