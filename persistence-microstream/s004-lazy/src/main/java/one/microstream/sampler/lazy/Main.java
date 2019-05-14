package one.microstream.sampler.lazy;


import com.github.javafaker.Commerce;
import com.github.javafaker.Company;
import com.github.javafaker.Faker;
import one.microstream.storage.types.EmbeddedStorage;
import one.microstream.storage.types.EmbeddedStorageManager;

import java.io.File;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Lazy loading example. Lazy part is in {@link Order}.
 */
public class Main {

  public static final String DATA_PATH = "data-s004";

  public static void main(final String[] args) {
    final EmbeddedStorageManager storageManager = EmbeddedStorage.start(new File(DATA_PATH));
    if (storageManager.root()
                      .get() == null) {
      storageManager.root()
                    .set(createSampleData());
      storageManager.storeRoot();
    }

    calcSumOfAllOrders(storageManager);
    calcSumOfAllOrders(storageManager);

    storageManager.shutdown();
  }


  private static void calcSumOfAllOrders(final EmbeddedStorageManager storageManager) {
    final DataRoot root = (DataRoot) storageManager.root()
                                                   .get();

    final long now = System.currentTimeMillis();

    final double sumOfAllOrders = root.getOrders()
                                      .stream()
                                      .mapToDouble(order -> order.getItems()
                                                                 .parallelStream()
                                                                 .mapToDouble(
                                                                     item -> item.getPrice() * item.getAmount())
                                                                 .sum())
                                      .sum();

    System.out.println();
    System.out.println("Sum of all orders: " + NumberFormat.getCurrencyInstance()
                                                           .format(sumOfAllOrders));
    System.out.println("Took " + (System.currentTimeMillis() - now) + " ms");
  }


  private static DataRoot createSampleData() {
    System.out.println("Creating sample data...");

    final Random   random       = new Random();
    final Faker    faker        = new Faker();
    final Commerce fakeCommerce = faker.commerce();
    final Company  fakeCompany  = faker.company();

    final List<Order> orders = new ArrayList<>();

    int itemCount = 0;

    for (int o = 0; o < 1000; o++) {
      final List<Item> items = new ArrayList<>();
      final int        c     = random.nextInt(500) + 1;
      itemCount += c;
      for (int i = 0; i < c; i++) {
        items.add(new Item(fakeCommerce.productName(), random.nextInt(10), random.nextDouble()));
      }

      orders.add(new Order(fakeCompany.name(), items));
    }

    final NumberFormat numberFormat = NumberFormat.getIntegerInstance();
    System.out.println(
        "Created " + numberFormat.format(orders.size()) + " orders with " + numberFormat.format(itemCount) + " items.");

    return new DataRoot(orders);
  }
}
