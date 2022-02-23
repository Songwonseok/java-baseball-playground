package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
com / user
1,4  1,4 => strike
1,4  2,4 => ball
1,4  1,2 => nothing

*/
public class BallTest {
	static Ball ball;

	@BeforeEach
	void setUp() {
		ball = new Ball(1, 4);
	}

	@Test
	void strike() {
		assertThat(ball.play(new Ball(1, 4))).isEqualTo(BallStatus.STRIKE);
	}

	@Test
	void ball() {
		assertThat(ball.play(new Ball(2, 4))).isEqualTo(BallStatus.BALL);
	}

	@Test
	void nothing() {
		assertThat(ball.play(new Ball(1, 6))).isEqualTo(BallStatus.NOTHING);
	}
}
