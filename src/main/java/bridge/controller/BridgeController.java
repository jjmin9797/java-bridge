package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeGameDto;
import bridge.observer.Observer;
import bridge.service.InputService;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController implements Observer {
    private final InputService inputService = new InputService();
    private List<String> bridge;

    public void run() {
        bridge = initGame();
        playGame();
        inputService.retry(InputView::readGameCommand, this::playGame, OutputView::printError);
    }

    private List<String> initGame() {
        return inputService.getBridgeSize(InputView::readBridgeSize, OutputView::printError);
    }

    private void playGame() {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.addObserver(this);
        inputService.getMoving(InputView::readMoving, OutputView::printError, bridgeGame);
    }

    @Override
    public void display(BridgeGameDto dto) {
        OutputView.printMap(dto);
    }
}
