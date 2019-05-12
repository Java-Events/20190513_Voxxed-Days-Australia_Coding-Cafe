package junit.org.rapidpm.event.junit5.ex04.solutions;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;

public class MyArroundClassExtension
		implements BeforeAllCallback,
		AfterAllCallback {


	private Namespace namespace
			= Namespace.create("AroundClassNamespace");

	@Override
	public void beforeAll(ExtensionContext context) throws Exception {
		context.publishReportEntry("beforeAll");
		context.getStore(namespace).put("KEY", "beforeAll - context");
	}

	@Override
	public void afterAll(ExtensionContext context) throws Exception {
		context.publishReportEntry("afterAll");
		context.publishReportEntry((String)context.getStore(namespace).get("KEY"));
	}

}