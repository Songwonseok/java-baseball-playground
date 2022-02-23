package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
	private final List<Ball> answers;

	public Balls(List<Integer> numbers) {
		List<Ball> balls = new ArrayList();
		for (int i = 0; i < 3; i++) {
			balls.add(new Ball(i + 1, numbers.get(i)));
		}
		this.answers = balls;
	}

	public BallStatus play(Ball ball) {

		// for(Ball answerBall : balls) {
		// 	BallStatus ballStatus = answerBall.play(ball);
		// 	if(ballStatus.isNotNothing()) {
		// 		return ballStatus;
		// 	}
		// }
		// return BallStatus.NOTHING;

		return answers.stream()
			.map(answer -> answer.play(ball))
			.filter(ballStatus -> ballStatus.isNotNothing())
			.findFirst()
			.orElse(BallStatus.NOTHING);
	}

	public PlayResult play(Balls balls) {
		PlayResult playResult = new PlayResult();

		for(Ball answer : answers) {
			BallStatus status = balls.play(answer);
			playResult.report(status);
		}

		return playResult;
	}

}
