package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeGameDto;
import bridge.observer.Observer;
import bridge.service.InputService;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;
import java.util.Map;

public class BridgeController implements Observer {
    private final InputService inputService = new InputService();

    public void run() {
        List<String> bridge = inputService.getBridgeSize(InputView::readBridgeSize, OutputView::printError);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.addObserver(this);
        inputService.getMoving(InputView::readMoving, OutputView::printError, bridgeGame);
    }

    @Override
    public void display(BridgeGameDto dto) {
        OutputView.printMap(dto);
    }
}
