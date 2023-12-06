package bridge.util;

import bridge.view.OutputView;

import java.util.function.Supplier;

public class RetryHandler {

    private RetryHandler() {
    }

    public static <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
