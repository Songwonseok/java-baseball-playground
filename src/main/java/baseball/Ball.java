package baseball;

import java.util.Objects;

public class Ball {
	private final int position;
	private final int number;

	public Ball(int position, int value) {
		this.position = position;
		this.number = value;
	}

	public BallStatus play(Ball ball) {
		if(this.equals(ball)) {
			return BallStatus.STRIKE;
		}

		if(ball.number == this.number){
			return BallStatus.BALL;
		}

		return BallStatus.NOTHING;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Ball ball = (Ball)o;
		return position == ball.position && number == ball.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position, number);
	}
}
