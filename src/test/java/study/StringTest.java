package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
