package bridge.view;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";

    public void showGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return 0;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
