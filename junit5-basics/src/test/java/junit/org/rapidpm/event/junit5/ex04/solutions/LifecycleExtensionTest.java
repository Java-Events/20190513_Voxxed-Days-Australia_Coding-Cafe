package junit.org.rapidpm.event.junit5.ex04.solutions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MyArroundClassExtension.class)
@ExtendWith(MyArroundMethodExtension.class)
class LifecycleExtensionTest {
	
	@Test
	void test001(TestReporter reporter) {
		reporter.publishEntry("The test");
	}
}
