package baseball.domain;

import java.util.Objects;

public class BallNumber implements Comparable<BallNumber> {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;

    private int number;

    public BallNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    public static BallNumber of(int number) {
        validateNumberRange(number);
        return new BallNumber(number);
    }

    private static void validateNumberRange(int number) {
        if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("입력된 숫자의 범위를 벗어났습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(BallNumber o) {
        return Integer.compare(this.number, o.number);
    }
}
