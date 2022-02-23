package baseball;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class NumberUtil {
	private static final Random random = new Random();
	public static final int MIN_VALUE = 1;
	public static final int MAX_VALUE = 9;

	public static boolean validNumber(int number) {
		return number >= MIN_VALUE && number <= MAX_VALUE;
	}

	public static List<Integer> createNumbers() {
		return random
			.ints(1, 9)
			.limit(3)
			.boxed()
			.collect(Collectors.toList());
	}

}
