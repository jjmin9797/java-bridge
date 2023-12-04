package bridge.service;

import bridge.*;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class InputService {
    public Bridge getBridgeSize(Supplier<String> inputSupplier,
                                Consumer<String> errorMessagePrinter) {
        while (true) {
            try {
                BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
                BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
                return new Bridge(bridgeMaker.makeBridge(Integer.parseInt(inputSupplier.get())));
            } catch (IllegalArgumentException e) {
                errorMessagePrinter.accept(e.getMessage());
            }
        }
    }

    public BridgeGame getMoving(Supplier<String> inputSupplier,
                                      Consumer<String> errorMessagePrinter, BridgeGame bridgeGame) {
        List<String> bridgeResult = bridgeGame.getCrossResult();
        do {
            try {
                bridgeGame.move(inputSupplier.get());
                bridgeResult = bridgeGame.getCrossResult();
            } catch (IllegalArgumentException e) {
                errorMessagePrinter.accept(e.getMessage());
            }
        } while (!bridgeResult.contains("X") && bridgeResult.size() != bridgeGame.getBridge().size());

        return bridgeGame;
    }

    public void checkGameFinish(BridgeGame bridgeGame) {
        if (bridgeGame.getBridge() == bridgeGame.getCrossResult()) {
        }
    }

    public void retry(Supplier<String> inputSupplier, Runnable retryGame,
                      Consumer<String> errorMessagePrinter) {
        while (true) {
            try {
                String input = inputSupplier.get();
                if (input.equals("R")) {
                    retryGame.run();
                }
                else if (input.equals("Q")) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                errorMessagePrinter.accept(e.getMessage());
            }
        }
    }
}
