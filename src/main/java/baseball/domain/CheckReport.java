package baseball.domain;

public class CheckReport {
    private int totalCount;
    private int strikeCount;
    private int ballCount;

    public CheckReport(int totalCount, int strikeCount, int ballCount) {
        this.totalCount = totalCount;
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
