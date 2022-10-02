package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomBallNumberGeneratorTest {

    @Test
    @DisplayName("임의의 수 3개 생성을 한다.")
    void generate_three_number_test() {
        List<BallNumber> ballNumbers = new RandomBallNumberGenerator().generateBallNumbers();
        assertThat(ballNumbers.size()).isEqualTo(3);
    }
}