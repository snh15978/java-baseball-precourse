package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CheckReportTest {

    @Test
    @DisplayName("숫자 채킹 결과가 저장된다")
    void save_check_report_test() {
        CheckReport checkReport = new CheckReport(0, 1, 2);

        assertThat(checkReport.getTotalCount()).isEqualTo(0);
        assertThat(checkReport.getStrikeCount()).isEqualTo(1);
        assertThat(checkReport.getBallCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("스트라이크가 3인경우 winningCheck true를 리턴한다.")
    void winning_check_true_test() {
        CheckReport checkReport = new CheckReport(0, 3, 0);
        assertThat(checkReport.winningCheck()).isTrue();
    }

    @Test
    @DisplayName("스트라이크가 3이 아닌경우 winningCheck false를 리턴한다.")
    void winning_check_false_test() {
        CheckReport checkReport = new CheckReport(0, 2, 1);
        assertThat(checkReport.winningCheck()).isFalse();
    }
}