package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomBallNumberGenerator {
    private static final int TOTAL_NUMBER_COUNT = 3;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;

    public List<BallNumber> generateBallNumbers() {
        List<BallNumber> ballNumbers = new ArrayList<>();
        while (ballNumbers.size() < TOTAL_NUMBER_COUNT) {
            BallNumber ballNumber = BallNumber.of(pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER));
            addNumber(ballNumbers, ballNumber);
        }
        return ballNumbers;
    }

    private static void addNumber(List<BallNumber> ballNumbers, BallNumber ballNumber) {
        if (!ballNumbers.contains(ballNumber)) {
            ballNumbers.add(ballNumber);
        }
    }
}
