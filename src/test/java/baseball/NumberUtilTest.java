package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberUtilTest {

	@Test
	@DisplayName("1~9 사이 숫자 체크")
	void 숫자_유효성_체크() {
		assertThat(NumberUtil.validNumber(1)).isTrue();
		assertThat(NumberUtil.validNumber(9)).isTrue();
		assertThat(NumberUtil.validNumber(0)).isFalse();
		assertThat(NumberUtil.validNumber(10)).isFalse();
	}

	@Test
	void 중복되지_않는_랜덤숫자_3개_구하기() {
		//1~9사이 3개 숫자
		List<Integer> numbers = NumberUtil.createNumbers();

		assertThat(numbers.size()).isEqualTo(3);
		assertThat(new HashSet<>(numbers).size()).isEqualTo(3);

		for(Integer number : numbers) {
			assertThat(NumberUtil.validNumber(number)).isTrue();
		}
	}
}
