package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PlayerTest {

    @Test
    @DisplayName("숫자 3개가 입력되는지 확인한다")
    void add_number_test() {
        List<BallNumber> numbers = new ArrayList<>();
        numbers.add(BallNumber.of(1));
        numbers.add(BallNumber.of(2));
        numbers.add(BallNumber.of(3));

        Player player = new Player(numbers);

        assertThat(player.getNumbers()).isEqualTo(new ArrayList<>(numbers));
    }

    @ParameterizedTest
    @DisplayName("3자리 이상 입력할 경우 exception이 발생한다.")
    @MethodSource("parameterProviderWhenInputSizeOverThree")
    void number_size_exception_test(List<BallNumber> numbers) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() ->
                new Player(numbers)
            ).withMessageMatching("입력된 숫자의 갯수가 3개 초과했습니다.");
    }

    private static Stream<Arguments> parameterProviderWhenInputSizeOverThree() {
        return Stream.of(
            Arguments.of(Arrays.asList(BallNumber.of(1), BallNumber.of(2), BallNumber.of(3), BallNumber.of(4))),
            Arguments.of(Arrays.asList(BallNumber.of(1), BallNumber.of(9), BallNumber.of(3), BallNumber.of(7)))
        );
    }

    @Test
    @DisplayName("1~9 이외의 숫자를 입력할 경우 exception이 발생한다.")
    void input_number_zero_exception_test() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() ->
                new Player(Arrays.asList(BallNumber.of(0), BallNumber.of(1), BallNumber.of(2)))
            ).withMessageMatching("입력된 숫자의 범위를 벗어났습니다.");
    }
}