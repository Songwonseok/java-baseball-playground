package baseball;

public class BaseBallGame {
	private final static String NOTHING = "낫싱";
	private final static String STRIKE = "스트라이크";
	private final static String BALL = "볼";
	private final static String END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	private Balls answers;

	public BaseBallGame(Balls balls) {
		answers = balls;
	}

	public String play(Balls userBalls) {
		PlayResult playResult = answers.play(userBalls);

		if(playResult.isNothing()) {
			return NOTHING;
		}

		if(playResult.isEnd()) {
			return END;
		}

		StringBuilder stringBuilder = new StringBuilder();

		if(playResult.hasBall()) {
			stringBuilder.append(playResult.getBall()).append(BALL);
		}

		if(playResult.hasStrike()) {
			if(playResult.hasBall()){
				stringBuilder.append(" ");
			}

			stringBuilder.append(playResult.getStrike()).append(STRIKE);
		}

		return stringBuilder.toString();
	}
}
