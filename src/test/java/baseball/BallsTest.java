package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baseball.BallStatus;

/*
com / user
456  1,4 => strike
456  2,4 => ball
456  1,2 => nothing

*/
public class BallsTest {
	private Balls balls;

	@BeforeEach
	void setUp() {
		balls = new Balls(Arrays.asList(1,2,3));
	}

	@Test
	void strike() {
		assertThat(balls.play(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
	}

	@Test
	void ball() {
		assertThat(balls.play(new Ball(1, 2))).isEqualTo(BallStatus.BALL);
	}

	@Test
	void nothing() {
		assertThat(balls.play(new Ball(1, 4))).isEqualTo(BallStatus.NOTHING);
	}

	@Test
	void play_nothing() {
		Balls userBalls = new Balls(Arrays.asList(4,5,6));
		PlayResult playResult = balls.play(userBalls);

		assertThat(playResult.getStrike()).isEqualTo(0);
		assertThat(playResult.getBall()).isEqualTo(0);
	}

	@Test
	void play_1ball() {
		Balls userBalls = new Balls(Arrays.asList(3,5,6));
		PlayResult playResult = balls.play(userBalls);

		assertThat(playResult.getStrike()).isEqualTo(0);
		assertThat(playResult.getBall()).isEqualTo(1);
	}

	@Test
	void play_2ball() {
		Balls userBalls = new Balls(Arrays.asList(2,3,6));
		PlayResult playResult = balls.play(userBalls);

		assertThat(playResult.getStrike()).isEqualTo(0);
		assertThat(playResult.getBall()).isEqualTo(2);
	}

	@Test
	void play_3ball() {
		Balls userBalls = new Balls(Arrays.asList(3,1,2));
		PlayResult playResult = balls.play(userBalls);

		assertThat(playResult.getStrike()).isEqualTo(0);
		assertThat(playResult.getBall()).isEqualTo(3);
	}

	@Test
	void play_1ball_1strike() {
		Balls userBalls = new Balls(Arrays.asList(6,1,3));
		PlayResult playResult = balls.play(userBalls);

		assertThat(playResult.getStrike()).isEqualTo(1);
		assertThat(playResult.getBall()).isEqualTo(1);
	}

	@Test
	void play_1strike() {
		Balls userBalls = new Balls(Arrays.asList(1,5,4));
		PlayResult playResult = balls.play(userBalls);

		assertThat(playResult.getStrike()).isEqualTo(1);
		assertThat(playResult.getBall()).isEqualTo(0);
	}

	@Test
	void play_2strike() {
		Balls userBalls = new Balls(Arrays.asList(1,2,4));
		PlayResult playResult = balls.play(userBalls);

		assertThat(playResult.getStrike()).isEqualTo(2);
		assertThat(playResult.getBall()).isEqualTo(0);
	}

	@Test
	void play_3strike() {
		Balls userBalls = new Balls(Arrays.asList(1,2,3));
		PlayResult playResult = balls.play(userBalls);

		assertThat(playResult.getStrike()).isEqualTo(3);
		assertThat(playResult.getBall()).isEqualTo(0);
	}

}
