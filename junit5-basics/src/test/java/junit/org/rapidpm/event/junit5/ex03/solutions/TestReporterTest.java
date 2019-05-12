package junit.org.rapidpm.event.junit5.ex03.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.nanoTime;
import static java.util.stream.IntStream.rangeClosed;

class TestReporterTest {

  @BeforeEach
  void beforeEach(TestReporter reporter){
    reporter.publishEntry("beforeEach..");
  }

  @Test
  void test001(TestReporter reporter) {
    reporter.publishEntry("Hello Reporter..");
  }

  @Test
  void test002(TestReporter reporter) {
    reporter.publishEntry("Key", "Value");
  }


  @Test
  void test003(TestReporter reporter) {

    final Map<String, String> map = rangeClosed(0, 3)
        .collect(HashMap::new,
                 (m, v) -> m.put(v + "", nanoTime() + ""),
                 Map::putAll);

    reporter.publishEntry(map);
  }
}
