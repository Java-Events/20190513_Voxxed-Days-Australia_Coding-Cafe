package junit.org.rapidpm.event.junit5.ex04.solutions;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;

import static java.lang.String.valueOf;

public class MyArroundMethodExtension implements AfterEachCallback, BeforeEachCallback {

	private Namespace namespace = Namespace.create("AroundMethodNamespace");

	@Override
	public void beforeEach(ExtensionContext context) throws Exception {
		context.publishReportEntry("beforeEach");
		context.getStore(namespace).put("KEY", "beforeEach - context");
	}

	@Override
	public void afterEach(ExtensionContext context) throws Exception {
		context.publishReportEntry("afterEach");
		ExtensionContext.Store store = context.getStore(namespace);
		Object key = store.get("KEY");
		context.publishReportEntry(valueOf(key));
	}

}