package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BallNumberTest {

    @Test
    @DisplayName("1~9 이외의 숫자를 입력할 경우 exception이 발생한다.")
    void input_number_zero_exception_test() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() ->
                BallNumber.of(0)
            ).withMessageMatching("입력된 숫자의 범위를 벗어났습니다.");
    }
}