package bridge.service;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class InputService {
    public List<String> getBridgeSize(Supplier<String> inputSupplier,
                                      Consumer<String> errorMessagePrinter) {
        while (true) {
            try {
                BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
                BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
                return bridgeMaker.makeBridge(Integer.parseInt(inputSupplier.get()));
            } catch (IllegalArgumentException e) {
                errorMessagePrinter.accept(e.getMessage());
            }
        }
    }

    public void getMoving(Supplier<String> inputSupplier,
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
    }
}
