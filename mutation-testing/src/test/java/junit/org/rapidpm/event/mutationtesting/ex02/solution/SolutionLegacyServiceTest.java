package junit.org.rapidpm.event.mutationtesting.ex02.solution;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.rapidpm.event.mutationtesting.ex02.LegacyService;

class SolutionLegacyServiceTest {

	@Test
	void test001() {
		String[] result = LegacyService.discardCommonPrefix("ABC", "ABD");

		assertEquals(result[0], "C");
		assertEquals(result[1], "D");
	}

	@Test
	void test002() {
		String[] result = LegacyService.discardCommonPrefix("ABC", "DEF");

		assertEquals(result[0], "ABC");
		assertEquals(result[1], "DEF");
	}

	@Test
	void test003() {
		String[] result = LegacyService.discardCommonPrefix("DEF", "ABC");

		assertEquals(result[0], "DEF");
		assertEquals(result[1], "ABC");
	}
	
	@Test
	void test004() {
		String[] result = LegacyService.discardCommonPrefix("ABD", "ABC");

		assertEquals(result[0], "D");
		assertEquals(result[1], "C");
	}
	
	@Test
	void test005() {
		String[] result = LegacyService.discardCommonPrefix("", "ABC");

		assertEquals(result[0], "");
		assertEquals(result[1], "ABC");
	}
	
	@Test
	void test006() {
		String[] result = LegacyService.discardCommonPrefix("", "");

		assertEquals(result[0], "");
		assertEquals(result[1], "");
	}
	
	@Test
	void test007() {
		String[] result = LegacyService.discardCommonPrefix("ABC", "ABC");

		assertEquals(result[0], "");
		assertEquals(result[1], "");
	}
}
