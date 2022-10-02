package baseball;

import baseball.View.PlayView;
import baseball.domain.CheckReport;
import baseball.domain.Player;
import baseball.domain.RandomBallNumberGenerator;

public class Application {
    private static final int RESTART = 1;
    private static final int FINISH = 2;

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        Player computer = new Player(new RandomBallNumberGenerator().generateBallNumbers());
        while (true) {
            PlayView.printInputNumberMessage();

            CheckReport checkReport = computer.checkingBallNumber(PlayView.inputBallNumbers());
            PlayView.printGameReport(checkReport);

            if (checkReport.winningCheck()) {
                PlayView.printFinishMessage();
                PlayView.printEndOrRestartMessage();
                int gameMode = PlayView.inputEndOrRestart();

                if (gameMode == FINISH) {
                    break;
                }

                if (gameMode == RESTART) {
                    computer = new Player(new RandomBallNumberGenerator().generateBallNumbers());
                }
            }
        }
    }
}
