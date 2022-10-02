package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {

    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
    void set_size_test() {
        Set<Integer> numberSet = new HashSet<>();

        numberSet.add(1);
        numberSet.add(1);
        numberSet.add(2);
        numberSet.add(3);

        assertThat(numberSet.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현한다.")
    @ValueSource(ints = {1, 2, 3})
    void set_contains_test(int input) {
        Set<Integer> numberSet = new HashSet<>();

        numberSet.add(1);
        numberSet.add(1);
        numberSet.add(2);
        numberSet.add(3);

        assertThat(numberSet.contains(input)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void set_contains_test2(int input, boolean expect) {
        Set<Integer> numberSet = new HashSet<>();

        numberSet.add(1);
        numberSet.add(1);
        numberSet.add(2);
        numberSet.add(3);
        assertEquals(numberSet.contains(input), expect);
    }
}
