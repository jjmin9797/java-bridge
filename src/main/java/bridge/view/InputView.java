package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final Pattern bridgeSizePattern =  Pattern.compile("^([3-9]|1[0-9]|20)$");
    private static final Pattern movingPattern = Pattern.compile("^[UD]$");
    private static final Pattern gameCommandPattern = Pattern.compile("^[RQ]$");

    /**
     * 다리의 길이를 입력받는다.
     */
    public static String readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = getUserInput();
        if (!bridgeSizePattern.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return input;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = getUserInput();
        if (!movingPattern.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D만 입력할 수 있습니다.");
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = getUserInput();
        if (!gameCommandPattern.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 재시작 여부 입력은 R 또는 Q만 입력할 수 있습니다.");
        }
        return input;
    }

    private static String getUserInput() {
        return Console.readLine();
    }
}
