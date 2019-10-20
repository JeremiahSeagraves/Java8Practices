package becomeateasewithjava8.lambda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionLambda implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(TransactionLambda.class);
    private boolean consumed = false;

    public boolean isConsumed() {
        return consumed;
    }

    @Override
    public void run() {
        logger.debug("Transaction lambda ran");
        consumed = true;
        logger.debug("Transaction lambda ended");
    }
}
