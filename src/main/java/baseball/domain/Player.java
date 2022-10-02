package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Player {
    private static final int TOTAL_NUMBER_COUNT = 3;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;

    private List<Integer> numbers;

    public Player(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != TOTAL_NUMBER_COUNT) {
            throw new IllegalArgumentException("입력된 숫자의 갯수가 3개 초과했습니다.");
        }

        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException("입력된 숫자가 중복입니다.");
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
