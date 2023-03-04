package pro.xstore.api.message.error;

import java.io.Serial;

public class APICommandConstructionException extends Exception {

    @Serial
    private static final long serialVersionUID = -7824221547649611706L;

    /**
     * Creates a new instance of
     * <code>APICommandConstructionException</code> without detail message.
     */
    public APICommandConstructionException() {
    }

    /**
     * Constructs an instance of
     * <code>APICommandConstructionException</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public APICommandConstructionException(String msg) {
        super(msg);
    }
}