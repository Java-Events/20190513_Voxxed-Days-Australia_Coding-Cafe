package one.microstream.sampler.helloworld;


import one.microstream.storage.types.EmbeddedStorage;
import one.microstream.storage.types.EmbeddedStorageManager;

import java.io.File;


public class HelloWorld {

  public static final String DATA_PATH = "data-s001";

  public static void main(final String[] args) {
    // Init storage manager
    final EmbeddedStorageManager storageManager = EmbeddedStorage.start(new DataRoot(),
                                                                        new File(DATA_PATH));

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
