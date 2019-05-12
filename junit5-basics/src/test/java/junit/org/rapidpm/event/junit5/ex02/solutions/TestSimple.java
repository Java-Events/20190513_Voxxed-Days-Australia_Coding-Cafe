package junit.org.rapidpm.event.junit5.ex02.solutions;

import org.junit.jupiter.api.*;

class TestSimple {

	@BeforeAll
	static void beforeAll() {
		System.out.println("Before all tests");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("After all tests");
	}



	@BeforeEach
	void beforeEach() {
		System.out.println("Before each test");
	}

	@AfterEach
	void afterEach() {
		System.out.println("After each test");
	}



	@Test
	@DisplayName("The first test")
	void test001() {
		System.out.println("Test 001");
	}

	@Test
	@DisplayName("The second test")
	void test002() {
		System.out.println("Test 002");
	}

}
