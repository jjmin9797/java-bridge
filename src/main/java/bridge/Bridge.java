package bridge;

import bridge.dto.BridgeDto;

import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private int tryCount;
    private String correct = "실패";

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        tryCount = 0;
    }

    public BridgeDto toDto() {
        return new BridgeDto(bridge, tryCount, correct);
    }

    public void plusOneTryCount() {
        tryCount += 1;
    }

    public void answerCorrect() {
        correct = "성공";
    }
}
