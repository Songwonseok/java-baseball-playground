package baseball;

public class PlayResult {
	private int strike;
	private int ball;

	public PlayResult() {
		this.strike = 0;
		this.ball = 0;
	}

	public int getStrike() {
		return this.strike;
	}

	public int getBall() {
		return this.ball;
	}

	public void report(BallStatus status) {
		if(status.isStrike()) {
			this.strike++;
			return;
		}

		if(status.isBall()) {
			this.ball++;
			return;
		}
	}

	public boolean isNothing() {
		return this.strike == 0 && this.ball == 0;
	}

	public boolean isEnd() {
		return this.strike == 3;
	}

	public boolean hasBall() {
		return this.ball > 0;
	}

	public boolean hasStrike() {
		return this.strike > 0;
	}
}
