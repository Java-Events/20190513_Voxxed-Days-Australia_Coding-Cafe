package junit.org.rapidpm.event.junit5.ex02;

import org.junit.jupiter.api.*;


class TestNonStatic {

  // was static at jUnit4, no choice
  //@BeforeAll
  void beforeAll() {
    System.out.println("Before all tests");
  }

  //@AfterAll
  void afterAll() {
    System.out.println("After all tests");
  }


  // non static as before (junit4)
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
  @Disabled
  void test001() {
    System.out.println("Test 001");
  }

  @Test
  @DisplayName("The second test")
  @Disabled
  void test002() {
    System.out.println("Test 002");
  }

}
