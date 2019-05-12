package junit.org.rapidpm.event.junit5.ex04;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LifecycleExtensionTest {

  @Test
  void test001(TestReporter reporter) {
    reporter.publishEntry("The test");
  }


  @BeforeEach
  void beforeEach(TestReporter reporter) throws Exception {
    reporter.publishEntry("beforeEach");
  }

  @AfterEach
  void afterEach(TestReporter reporter) throws Exception {
    reporter.publishEntry("afterEach");
  }


  @BeforeAll
  void beforeAll(TestReporter reporter) throws Exception {
    reporter.publishEntry("beforeAll");
  }

  @AfterAll
  void afterAll(TestReporter reporter) throws Exception {
    reporter.publishEntry("afterAll");
  }
}
