package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int TOTAL_NUMBER_COUNT = 3;

    private List<BallNumber> numbers;

    public Player(List<BallNumber> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<BallNumber> numbers) {
        if (numbers.size() != TOTAL_NUMBER_COUNT) {
            throw new IllegalArgumentException("입력된 숫자의 갯수가 3개 초과했습니다.");
        }
    }

    public List<BallNumber> getNumbers() {
        return numbers;
    }
}
