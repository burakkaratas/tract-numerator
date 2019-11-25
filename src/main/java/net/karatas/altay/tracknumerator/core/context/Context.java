package net.karatas.altay.tracknumerator.core.context;

import java.util.UUID;
import org.apache.logging.log4j.ThreadContext;

public class Context {

  private static final String TRANSACTION_ID = "TRANSACTION";

  public static String getTx() {
    return ThreadContext.get(TRANSACTION_ID);
  }

  public static void setTx(String tx) {
    ThreadContext.put(TRANSACTION_ID, UUID.randomUUID().toString());
  }

  public static void cleanup() {
    ThreadContext.remove(TRANSACTION_ID);
  }
}
