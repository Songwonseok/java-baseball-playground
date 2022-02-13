package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("replace")
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    @Test
    @DisplayName("split")
    void split() {
        String[] testArray1 = "1,2,3".split(",");
        String[] testArray2 = "1".split(",");

        assertThat(testArray1).contains("1", "2");
        assertThat(testArray2).containsExactly("1");
    }

    @Test
    @DisplayName("substring")
    void substring() {
        String testString = "(1,2)";
        String subStringResult = testString.substring(1, testString.length() - 1);

        assertThat(subStringResult).isEqualTo("1,2");
    }

    @Test
    @DisplayName("CharAt 인덱스를 벗어난 경우")
    void charAt() {
        String testString = "abc";

        assertThat(testString.charAt(0)).isEqualTo('a');
        assertThat(testString.charAt(1)).isEqualTo('b');
        assertThat(testString.charAt(2)).isEqualTo('c');
        assertThatThrownBy(() -> {
            testString.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
