package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Player {
    private static final int TOTAL_NUMBER_COUNT = 3;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;

    private List<Integer> numbers;

    public Player(Set<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(Set<Integer> numbers) {
        if (numbers.size() != TOTAL_NUMBER_COUNT) {
            throw new IllegalArgumentException("입력된 숫자의 갯수가 3개가 아니거나 중복된 숫자가 있습니다.");
        }

        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    private void validateNumberRange(Integer number) {
        if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("입력된 숫자의 범위를 벗어났습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
