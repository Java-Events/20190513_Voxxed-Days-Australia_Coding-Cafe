package junit.org.rapidpm.event.mutationtesting.ex02;

import org.junit.jupiter.api.Test;
import org.rapidpm.event.mutationtesting.ex02.LegacyService;
import org.rapidpm.event.mutationtesting.ex02.RefactoredService;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RefactoredServiceTest {

	@Test
	void test001() {
		String[] result = RefactoredService.discardCommonPrefix("ABC", "ABD");
		assertEquals(result[0], "C");
		assertEquals(result[1], "D");
	}




}
