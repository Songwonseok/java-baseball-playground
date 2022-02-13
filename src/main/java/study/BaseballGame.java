package study;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BaseballGame {
	private List<Integer> numbers;
	private Set<Integer> set;

	public BaseballGame() {
		this.numbers = new ArrayList<>();
		this.set = new HashSet<>();

		while (this.numbers.size() < 3) {
			int rand = (int)((Math.random() * 9) + 1);

			if (this.set.contains(rand)) {
				continue;
			}

			this.set.add(rand);
			this.numbers.add(rand);

		}
	}

	public int[] analyzeNumbers(String number) {
		int ball = 0;
		int strike = 0;

		for (int i = 0; i < 3; i++) {
			int curr = number.charAt(i) - '0';

			if (this.numbers.get(i) == curr) {
				strike++;
				continue;
			}

			if (this.set.contains(curr)) {
				ball++;
			}
		}

		return new int[] {ball, strike};
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();

		Scanner scanner = new Scanner(System.in);    // 인스턴스 생성
		BaseballGame baseballGame = new BaseballGame();

		start:
		while (true) {
			System.out.print("숫자를 입력해 주세요 : ");
			String input = scanner.next();

			int[] result = baseballGame.analyzeNumbers(input);

			int ball = result[0];
			int strike = result[1];

			StringBuilder sb = new StringBuilder();

			if (ball == 0 && strike == 0) {
				System.out.println("낫싱");
				continue;
			}

			if (ball > 0) {
				sb.append(ball).append("볼").append(" ");
			}

			if (strike > 0) {
				sb.append(strike).append("스트라이크");
			}

			System.out.println(sb);

			if (strike < 3) {
				continue;
			}

			while (true) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
				input = scanner.next().trim();

				if (!input.equals("1") && !input.equals("2")) {
					System.out.println("다시 입력해주세요.");
					continue;
				}

				if (input.equals("1")) {
					baseballGame = new BaseballGame();
					continue start;
				}

				System.out.println("종료되었습니다.");
				break;
			}

			break;
		}
	}
}
