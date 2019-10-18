package becomeateasewithjava8;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Transaction {

    Logger logger = LoggerFactory.getLogger(Transaction.class);

    public void start() {
        logger.debug("Transaction started");
    }

    public void stop() {
        logger.debug("Transaction ended");
    }

}
