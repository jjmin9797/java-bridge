package bridge;

import bridge.BridgeGameDto;
import bridge.observer.Observer;
import bridge.observer.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame implements Subject {
    private final List<String> bridge;
    private final List<String> crossResult = new ArrayList<>();
    private final List<String> userChoice = new ArrayList<>();
    private final Map<Integer, List<String>> crossResult2 = new HashMap<>();
    private int moveCount;
    private final List<Observer> observers = new ArrayList<>();

    public BridgeGame(List<String> bridge) {
        moveCount = 0;
        this.bridge = bridge;
    }

    public void move(String input) {
        String answer = bridge.get(moveCount);
        userChoice.add(input);
        if (input.equals(answer)) {
            crossResult.add("O");
            moveCount++;
            notifyObservers();
            return;
        }
        crossResult.add("X");
        moveCount++;
        notifyObservers();
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getCrossResult() {
        return crossResult;
    }

    public List<String> getUserChoice() {
        return userChoice;
    }

    public BridgeGameDto toDto() {
        return new BridgeGameDto(bridge, crossResult, userChoice, createResultMap());
    }

    private String createResultMap() {
        StringBuilder line1 = new StringBuilder("[");
        StringBuilder line2 = new StringBuilder("[");


        for (int i = 0; i < crossResult.size(); i++) {
            if (userChoice.get(i).equals("U")) {
                line1.append(" ").append(crossResult.get(i)).append(" ");
                line2.append("   ");
            }
            else if (userChoice.get(i).equals("D")) {
                line1.append("   ");
                line2.append(" ").append(crossResult.get(i)).append(" ");
            }
            if (i < crossResult.size() - 1) {
                line1.append("|");
                line2.append("|");
            }
        }

        line1.append("]");
        line2.append("]");

        StringBuilder result = new StringBuilder();
        result.append(line1).append("\n").append(line2);
        return result.toString();
    }



    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.display(toDto());
        }
    }
}
