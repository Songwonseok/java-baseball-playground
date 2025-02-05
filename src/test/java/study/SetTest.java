package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	void size() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@DisplayName("contails ValueSource Test")
	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	void contains(int number) {
		// assertThat(numbers.contains(1)).isTrue();
		// assertThat(numbers.contains(2)).isTrue();
		// assertThat(numbers.contains(3)).isTrue();

		assertThat(numbers.contains(number)).isTrue();
	}

	@DisplayName("contails CsvSource Test")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void contains2(int number, boolean expected) {
		assertThat(numbers.contains(number)).isEqualTo(expected);
	}

}
