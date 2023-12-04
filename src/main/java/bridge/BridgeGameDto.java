package bridge;

import java.util.List;

public class BridgeGameDto {
    private final List<String> crossResult;
    private final List<String> userChoice;

    public BridgeGameDto(List<String> crossResult, List<String> userChoice) {
        this.crossResult = crossResult;
        this.userChoice = userChoice;
    }

    public List<String> userChoice() {
        return userChoice;
    }

    public List<String> crossResult() {
        return crossResult;
    }
}
