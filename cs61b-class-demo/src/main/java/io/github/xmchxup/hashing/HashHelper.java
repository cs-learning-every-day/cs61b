package io.github.xmchxup.hashing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class HashHelper {
	/**
	 * Converts character to a letter number.
	 * e.g. 'a' -> 1, 'b' -> 2, 'z' -> 26
	 */
	public static int letterNum(char c) {
		if ((c < 'a') || (c > 'z')) {
			throw new IllegalArgumentException();
		}
		return c - 'a' + 1;
	}

	public static int englishToInt(String word) {
		int p = word.length() - 1;
		int result = 0;
		char[] chars = word.toCharArray();
		for (char c : chars) {
			result += letterNum(c) * Math.pow(27, p);
			p--;
		}
		return result;
	}

	@Test
	public void testEnglishToInt() {
		Assertions.assertEquals(28, englishToInt("aa"));
		Assertions.assertEquals(1598, englishToInt("bee"));
		Assertions.assertEquals(237_949_071, englishToInt("potato"));
	}

	public static int asciiToInt(String s) {
		int intRep = 0;
		int length = s.length();
		for (int i = 0; i < length; i++) {
			intRep = intRep * 126;
			intRep = intRep + s.charAt(i);
		}
		return intRep;
	}
}
