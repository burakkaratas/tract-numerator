package net.karatas.altay.tracknumerator.core.context;

import org.apache.logging.log4j.ThreadContext;

import java.util.UUID;

public class Context {
    private static final String TRANSACTION_ID = "TRANSACTION";

    public static void setTx(String tx) {
        ThreadContext.put(TRANSACTION_ID, UUID.randomUUID().toString());
    }

    public static String getTx() {
        return ThreadContext.get(TRANSACTION_ID);
    }

    public static void cleanup() {
        ThreadContext.remove(TRANSACTION_ID);
    }
}
