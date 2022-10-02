package baseball.domain;

import java.util.List;

public class Player {
    private static final int TOTAL_NUMBER_COUNT = 3;

    private List<BallNumber> numbers;

    public Player(List<BallNumber> numbers) {
        setNumber(numbers);
    }

    public void changeNumber(List<BallNumber> numbers) {
        setNumber(numbers);
    }

    private void setNumber(List<BallNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<BallNumber> numbers) {
        if (numbers.size() != TOTAL_NUMBER_COUNT) {
            throw new IllegalArgumentException("입력된 숫자의 갯수가 3개 초과했습니다.");
        }
    }

    public List<BallNumber> getNumbers() {
        return numbers;
    }

    public CheckReport checkingBallNumber(List<BallNumber> competitorNumbers) {
        int totalCount = containsCount(competitorNumbers);
        int strikeCount = strikeCount(competitorNumbers);
        int ballCount = totalCount - strikeCount;
        return new CheckReport(totalCount, strikeCount, ballCount);
    }

    private int containsCount(List<BallNumber> competitorNumbers) {
        int containsCount = 0;
        for (BallNumber competitorNumber : competitorNumbers) {
            containsCount = checkingContains(containsCount, competitorNumber);
        }
        return containsCount;
    }

    private int checkingContains(int totalCount, BallNumber competitorNumber) {
        if (numbers.contains(competitorNumber)) {
            totalCount++;
        }
        return totalCount;
    }

    private int strikeCount(List<BallNumber> competitorNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < competitorNumbers.size(); i++) {
            strikeCount = checkingStrike(competitorNumbers, strikeCount, i);
        }
        return strikeCount;
    }

    private int checkingStrike(List<BallNumber> competitorNumbers, int strikeCount, int i) {
        if (competitorNumbers.get(i).equals(numbers.get(i))) {
            strikeCount++;
        }
        return strikeCount;
    }
}
