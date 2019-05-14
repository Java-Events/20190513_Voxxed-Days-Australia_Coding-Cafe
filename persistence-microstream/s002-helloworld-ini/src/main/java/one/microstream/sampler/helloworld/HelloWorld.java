package one.microstream.sampler.helloworld;


import one.microstream.storage.configuration.Configuration;
import one.microstream.storage.configuration.ConfigurationLoader;
import one.microstream.storage.configuration.ConfigurationParser;
import one.microstream.storage.types.EmbeddedStorageManager;

import java.io.IOException;
import java.io.InputStream;


public class HelloWorld {

  public static final String STORAGE_INI = "/META-INF/microstream/storage.ini";

  public static void main(final String[] args) throws IOException {
    String configurationData;
    try (InputStream inputStream = HelloWorld.class.getResourceAsStream(STORAGE_INI)) {
      configurationData = ConfigurationLoader.FromInputStream(inputStream)
                                             .loadConfiguration();
    }

    final Configuration configuration = ConfigurationParser.Ini()
                                                           .parse(configurationData);

    final EmbeddedStorageManager storageManager = configuration.createEmbeddedStorageFoundation()
                                                               .createEmbeddedStorageManager(new DataRoot())
                                                               .start();

    // Get the root and modify
    final DataRoot root = (DataRoot) storageManager.root()
                                                   .get();

    System.out.println(root);

    root.setName("Hello there! [" + System.currentTimeMillis() + "]");

    // Store modified object
    storageManager.store(root);

    // Save shutdown
    storageManager.shutdown();
  }
}
