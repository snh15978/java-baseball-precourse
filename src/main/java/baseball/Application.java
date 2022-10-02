package baseball;

import baseball.View.PlayView;
import baseball.domain.Player;
import baseball.domain.RandomBallNumberGenerator;

public class Application {
    private static final int FINISH = 2;

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        Player computer = makeComputer();
        playing(computer, null);
    }

    private static void playing(Player computer, Player user) {
        while (true) {
            user = inputNumbers(user);
            if (PlayView.printGameReport(computer.checkingBallNumber(user.getNumbers()))) {
                if (PlayView.inputEndOrRestart() == FINISH) {
                    break;
                }
                computer = makeComputer();
            }
        }
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
