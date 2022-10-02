package baseball.View;

import baseball.domain.BallNumber;
import baseball.domain.CheckReport;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class PlayView {

    public static void printInputNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static List<BallNumber> inputBallNumbers() {
        String[] inputBallNumberSplit = Console.readLine().split("");
        List<BallNumber> ballNumbers = new ArrayList<>();
        for (String ballNumber : inputBallNumberSplit) {
            ballNumbers.add(BallNumber.of(Integer.parseInt(ballNumber)));
        }
        return ballNumbers;
    }

    public static boolean printGameReport(CheckReport checkReport) {
        String resultMessage = "";
        if (checkReport.getTotalCount() == 0) {
            System.out.println("낫싱");
            return false;
        }
        resultMessage = createBallMessage(checkReport, resultMessage);
        resultMessage = createStrikeMessage(checkReport, resultMessage);
        System.out.println(resultMessage);
        return checkReport.winningCheck();
    }

    private static String createBallMessage(CheckReport checkReport, String resultMessage) {
        if (checkReport.getBallCount() != 0) {
            resultMessage += checkReport.getBallCount() + "볼";
        }
        return resultMessage;
    }

    private static String createStrikeMessage(CheckReport checkReport, String resultMessage) {
        if (checkReport.getStrikeCount() != 0) {
            resultMessage = addSpace(resultMessage);
            resultMessage += checkReport.getStrikeCount() + "스트라이크";
        }
        return resultMessage;
    }

    private static String addSpace(String resultMessage) {
        if (resultMessage.length() > 0) {
            resultMessage += " ";
        }
        return resultMessage;
    }

    public static int inputEndOrRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }
}
