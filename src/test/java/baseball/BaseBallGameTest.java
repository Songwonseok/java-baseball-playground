package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseBallGameTest {
	private BaseBallGame baseBallGame;

	@BeforeEach
	void setUp() {
		baseBallGame = new BaseBallGame(new Balls(Arrays.asList(1,2,3)));
	}

	@Test
	void nothing() {
		Balls userBalls = new Balls(Arrays.asList(4,5,6));

		String result = baseBallGame.play(userBalls);

		assertThat(result).isEqualTo("낫싱");
	}

	@Test
	void play_1ball() {
		Balls userBalls = new Balls(Arrays.asList(4,1,6));

		String result = baseBallGame.play(userBalls);

		assertThat(result).isEqualTo("1볼");
	}

	@Test
	void play_2ball() {
		Balls userBalls = new Balls(Arrays.asList(2,3,6));

		String result = baseBallGame.play(userBalls);

		assertThat(result).isEqualTo("2볼");
	}

	@Test
	void play_3ball() {
		Balls userBalls = new Balls(Arrays.asList(3,1,2));

		String result = baseBallGame.play(userBalls);

		assertThat(result).isEqualTo("3볼");
	}

	@Test
	void play_1ball_1strike() {
		Balls userBalls = new Balls(Arrays.asList(6,1,3));

		String result = baseBallGame.play(userBalls);

		assertThat(result).isEqualTo("1볼 1스트라이크");
	}

	@Test
	void play_2strike() {
		Balls userBalls = new Balls(Arrays.asList(1,2,4));

		String result = baseBallGame.play(userBalls);

		assertThat(result).isEqualTo("2스트라이크");
	}

	@Test
	void play_3strike() {
		Balls userBalls = new Balls(Arrays.asList(1,2,3));

		String result = baseBallGame.play(userBalls);

		assertThat(result).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

}
