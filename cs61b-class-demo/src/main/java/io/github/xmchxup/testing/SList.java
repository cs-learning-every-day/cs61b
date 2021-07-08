package io.github.xmchxup.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class SList {
	public class IntNode {
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode h) {
			item = i;
			next = h;
		}
	}

	private static IntNode sentinel;

	public SList() {
		sentinel = new IntNode(982734, null);
	}

	public void insertFront(int x) {
		sentinel.next = new IntNode(x, sentinel.next);
	}

	public int getFront() {
		if (sentinel.next == null) {
			return -1;
		}
		return sentinel.next.item;
	}

	@Test
	public void test() {
		SList s1 = new SList();
		SList s2 = new SList();
		s1.insertFront(1);
		s2.insertFront(2);
		Assertions.assertNotEquals(s1.getFront(), s2.getFront());
		Assertions.assertEquals(1, s1.getFront());
	}

}
