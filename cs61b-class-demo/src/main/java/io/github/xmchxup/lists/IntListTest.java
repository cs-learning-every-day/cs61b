package io.github.xmchxup.lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class IntListTest {
	@Test
	void testList() {
		IntList one = new IntList(1, null);
		IntList twoOne = new IntList(2, one);
		IntList threeTwoOne = new IntList(3, twoOne);

		IntList x = IntList.list(3, 2, 1);
		Assertions.assertEquals(threeTwoOne, x);
	}

	@Test
	void testEqualAndSkippify() {
		IntList A = IntList.list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		IntList expectedA = IntList.list(1, 3, 6, 10);

		IntList B = IntList.list(9, 8, 7, 6, 5, 4, 3, 2, 1);
		IntList expectedB = IntList.list(9, 7, 4);

		A.skippify();
		B.skippify();

		Assertions.assertEquals(expectedA, A);
		Assertions.assertEquals(expectedB, B);
	}
}
