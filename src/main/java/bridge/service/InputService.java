package bridge.service;

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
}
