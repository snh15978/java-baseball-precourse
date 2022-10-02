package baseball;

import baseball.View.PlayView;
import baseball.domain.Player;
import baseball.domain.RandomBallNumberGenerator;

public class Application {
    private static final int RESTART = 1;

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        Player computer = makeComputer();
        playing(computer, null);
    }

    private static void playing(Player computer, Player user) {
        boolean isWin = true;
        while (isWin) {
            user = inputNumbers(user);
            isWin = isWin(computer, user, isWin);
        }
        if (PlayView.inputEndOrRestart() == RESTART) {
            startGame();
        }
    }

    private static boolean isWin(Player computer, Player user, boolean isWin) {
        if (PlayView.printGameReport(computer.checkingBallNumber(user.getNumbers()))) {
            isWin = false;
        }
        return isWin;
    }

    private static Player inputNumbers(Player user) {
        PlayView.printInputNumberMessage();
        if (user == null) {
            return new Player(PlayView.inputBallNumbers());
        }
        user.changeNumber(PlayView.inputBallNumbers());
        return user;
    }

    private static Player makeComputer() {
        return new Player(new RandomBallNumberGenerator().generateBallNumbers());
    }
}
