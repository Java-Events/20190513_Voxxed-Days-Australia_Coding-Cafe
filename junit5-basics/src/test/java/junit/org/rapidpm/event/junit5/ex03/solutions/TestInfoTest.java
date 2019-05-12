package junit.org.rapidpm.event.junit5.ex03.solutions;

import org.junit.jupiter.api.*;
import org.rapidpm.dependencies.core.logger.HasLogger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("TestInfo Demo")
class TestInfoTest
    implements HasLogger {

//  TestInfoTest(TestInfo testInfo) {
//    assertEquals("TestInfo Demo" , testInfo.getDisplayName());
//    printInfo(testInfo);
//  }

  private void printInfo(TestInfo testInfo) {
    logger().info("testclass " + testInfo.getTestClass().toString());
    logger().info("testmethod " + testInfo.getTestMethod().toString());
    logger().info("tags " + testInfo.getTags().toString());
    logger().info("displayname " + testInfo.getDisplayName());
  }

  @BeforeEach
  void init(TestInfo testInfo) {
    String displayName = testInfo.getDisplayName();
    assertTrue(displayName.equals("TEST 1")
               || displayName.equals("test2(TestInfo)"));
  }

  @Test
  @DisplayName("TEST 1")
  @Tag("my-tag")
  void test1(TestInfo testInfo) {
    printInfo(testInfo);
    assertEquals("TEST 1" , testInfo.getDisplayName());
    assertTrue(testInfo.getTags().contains("my-tag"));
  }

  @Test
    //no DisplayName used .. implicit naming
  void test2(TestInfo testInfo) {
    printInfo(testInfo);
  }

}
