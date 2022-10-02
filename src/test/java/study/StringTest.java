package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    @DisplayName("1,2를 ,로 split 했을 때 잘 분리 되는지 확인한다.")
    void string_split_test() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1,를 ,로 split 했을 때 잘 분리 되는지 확인한다.")
    void string_split_test2() {
        assertThat("1,".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 1,2를 반환하도록 구현한다.")
    void string_substring_test() {
        String input = "(1,2)";
        assertThat(input.substring(1, input.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습테스트를 구현한다.")
    void string_char_at_test() {
        String input = "abc";
        assertThat(input.charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("위치 값을 벗어나면 IndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    void string_char_at_exception_test() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() ->
                "abc".charAt(4)
            ).withMessageMatching("String index out of range: 4");
    }
}
