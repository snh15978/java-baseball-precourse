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

    public static void printGameReport(CheckReport checkReport) {
        String resultMessage = "";
        if (checkReport.getTotalCount() == 0) {
            System.out.println("낫싱");
            return;
        }
        resultMessage = createBallMessage(checkReport, resultMessage);
        resultMessage = createStrikeMessage(checkReport, resultMessage);
        System.out.println(resultMessage);
    }

    private static String createBallMessage(CheckReport checkReport, String resultMessage) {
        if (checkReport.getBallCount() != 0) {
            resultMessage += checkReport.getBallCount() + "볼";
        }
        return resultMessage;
    }

    private static String createStrikeMessage(CheckReport checkReport, String resultMessage) {
        if (checkReport.getStrikeCount() != 0) {
            if (resultMessage.length() > 0) {
                resultMessage += " ";
            }
            resultMessage += checkReport.getStrikeCount() + "스트라이크";
        }
        return resultMessage;
    }

    public static void printFinishMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printEndOrRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static int inputEndOrRestart() {
        return Integer.parseInt(Console.readLine());
    }
}
