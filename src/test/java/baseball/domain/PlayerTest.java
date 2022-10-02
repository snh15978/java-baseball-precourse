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
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        Player player = new Player(numbers);

        assertThat(player.getNumbers()).isEqualTo(new ArrayList<>(numbers));
    }

    @ParameterizedTest
    @DisplayName("중복된 숫자를 입력할 경우 exception이 발생한다.")
    @MethodSource("parameterProviderWhenInputDuplicateNumber")
    void duplicate_number_exception_test(List<Integer> numbers) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() ->
                new Player(numbers)
            ).withMessageMatching("입력된 숫자가 중복입니다.");
    }

    private static Stream<Arguments> parameterProviderWhenInputDuplicateNumber() {
        return Stream.of(
            Arguments.of(Arrays.asList(5, 9, 9)),
            Arguments.of(Arrays.asList(1, 1, 3))
        );
    }

    @ParameterizedTest
    @DisplayName("3자리 이상 입력할 경우 exception이 발생한다.")
    @MethodSource("parameterProviderWhenInputSizeOverThree")
    void number_size_exception_test(List<Integer> numbers) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() ->
                new Player(numbers)
            ).withMessageMatching("입력된 숫자의 갯수가 3개 초과했습니다.");
    }

    private static Stream<Arguments> parameterProviderWhenInputSizeOverThree() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4)),
            Arguments.of(Arrays.asList(1, 9, 3, 7))
        );
    }
}