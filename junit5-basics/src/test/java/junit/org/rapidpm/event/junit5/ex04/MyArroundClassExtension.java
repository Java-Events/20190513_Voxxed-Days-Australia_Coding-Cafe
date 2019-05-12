package junit.org.rapidpm.event.junit5.ex04;

import org.junit.jupiter.api.extension.ExtensionContext.Namespace;

public class MyArroundClassExtension {
  private Namespace namespace
      = Namespace.create("AroundClassNamespace");


}
