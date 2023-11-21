package baseball.model;

public class CompareDto {

    private final int strike;
    private final int ball;

    public CompareDto(int strike, int ball) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

}
