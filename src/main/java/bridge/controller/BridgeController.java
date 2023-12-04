package bridge.controller;

import bridge.service.InputService;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    private final InputService inputService = new InputService();

    public void run() {
        List<String> bridge = inputService.getBridgeSize(InputView::readBridgeSize, OutputView::printError);
    }
}
