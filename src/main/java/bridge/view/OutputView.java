package bridge.view;

import bridge.BridgeGameDto;

import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printError(String message) {
        System.out.println(message);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(BridgeGameDto dto) {
        StringBuilder line1 = new StringBuilder("[");
        StringBuilder line2 = new StringBuilder("[");


        for (int i = 0; i < dto.crossResult().size(); i++) {
            if (dto.userChoice().get(i).equals("U")) {
                line1.append(" ").append(dto.crossResult().get(i)).append(" ");
                line2.append("   ");
            }
            else if (dto.userChoice().get(i).equals("D")) {
                line1.append("   ");
                line2.append(" ").append(dto.crossResult().get(i)).append(" ");
            }
            if (i < dto.crossResult().size() - 1) {
                line1.append("|");
                line2.append("|");
            }
        }

        line1.append("]");
        line2.append("]");
        System.out.println(line1);
        System.out.println(line2);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult() {
    }
}
