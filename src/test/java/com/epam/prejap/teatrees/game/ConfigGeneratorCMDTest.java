package com.epam.prejap.teatrees.game;

import org.apache.commons.cli.BasicParser;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ConfigGeneratorCMDTest {

	private ConfigGeneratorCMD configGenerator;

	@BeforeTest
	public void setup() {
		configGenerator = new ConfigGeneratorCMD(new BasicParser());
	}

	@Test(dataProvider = "argsNoneMove")
	public void shouldCreateConfigWithCorrectNoneKey(String[] args, char expected) {
		// given
		// when
		var config = configGenerator.getConfigFromCommandLine(args);
		// then
		assertEquals(config.moveNone(), expected);
	}

	@Test(dataProvider = "argsLeftMove")
	public void shouldCreateConfigWithCorrectLeftKey(String[] args, char expected) {
		// given
		// when
		var config = configGenerator.getConfigFromCommandLine(args);
		// then
		assertEquals(config.moveLeft(), expected);
	}

	@Test(dataProvider = "argsRightMove")
	public void shouldCreateConfigWithCorrectRightKey(String[] args, char expected) {
		// given
		// when
		var config = configGenerator.getConfigFromCommandLine(args);
		// then
		assertEquals(expected, config.moveRight());
	}

	@DataProvider(name = "argsNoneMove")
	public static Object[][] provideDataForNoneMoveTest() {

		String[] args1 = {"-n", "s"};
		String[] args2 = {"-n", "none"};
		String[] args3 = {"-n", "1"};
		String[] args4 = {"-n", " "};
		String[] args5 = {"-w", "none existent option should return default key"};
		String[] args6 = {"-l", "none existent option should return default key"};

		return new Object[][]{
				{args1, 's'},
				{args2, 'n'},
				{args3, '1'},
				{args4, ' '},
				{args5, ' '},
				{args6, ' '},
		};
	}

	@DataProvider(name = "argsLeftMove")
	public static Object[][] provideDataForLeftMoveTest() {

		String[] args1 = {"-l", "s"};
		String[] args2 = {"-l", "left"};
		String[] args3 = {"-l", "1"};
		String[] args4 = {"-l", " "};
		String[] args5 = {"-w", "none existent option should return default key"};
		String[] args6 = {"-r", "none existent option should return default key"};

		return new Object[][]{
				{args1, 's'},
				{args2, 'l'},
				{args3, '1'},
				{args4, ' '},
				{args5, 'h'},
				{args6, 'h'},
		};
	}

	@DataProvider(name = "argsRightMove")
	public static Object[][] provideDataForRightMoveTest() {

		String[] args1 = {"-r", "s"};
		String[] args2 = {"-r", "right"};
		String[] args3 = {"-r", "1"};
		String[] args4 = {"-r", " "};
		String[] args5 = {"-w", "none existent option should return default key"};
		String[] args6 = {"-l", "none existent option should return default key"};

		return new Object[][]{
				{args1, 's'},
				{args2, 'r'},
				{args3, '1'},
				{args4, ' '},
				{args5, 'l'},
				{args6, 'l'},
		};
	}
}
