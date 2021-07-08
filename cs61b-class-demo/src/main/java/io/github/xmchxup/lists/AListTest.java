package io.github.xmchxup.lists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class AListTest {

	@Test
	public void testInsert() {
		int[] a = {3, 2, 1};
		a = AList.insert(a,10,1);
	}

	@Test
	public void testReverse() {
		int[] a = {3, 2, 1};
		AList.reverse(a);
	}

	@Test
	public void testReplicate() {
		int[] result = AList.replicate(new int[]{3, 2, 1});
		assertEquals(6, result.length);
	}

	@Test
	public void testEmptySize() {
		AList L = new AList();
		assertEquals(0, L.size());
	}

	@Test
	public void testAddAndSize() {
		AList L = new AList();
		L.addLast(99);
		L.addLast(99);
		assertEquals(2, L.size());
	}


	@Test
	public void testAddAndGetLast() {
		AList L = new AList();
		L.addLast(99);
		assertEquals(99, L.getLast());
		L.addLast(36);
		assertEquals(36, L.getLast());
	}


	@Test
	public void testGet() {
		AList L = new AList();
		L.addLast(99);
		assertEquals(99, L.get(0));
		L.addLast(36);
		assertEquals(99, L.get(0));
		assertEquals(36, L.get(1));
	}


	@Test
	public void testRemove() {
		AList L = new AList();
		L.addLast(99);
		assertEquals(99, L.get(0));
		L.addLast(36);
		assertEquals(99, L.get(0));
		L.removeLast();
		assertEquals(99, L.getLast());
		L.addLast(100);
		assertEquals(100, L.getLast());
		assertEquals(2, L.size());
	}

	/**
	 * Tests insertion of a large number of items.
	 */
	@Test
	public void testMegaInsert() {
		AList L = new AList();
		int N = 1000000;
		for (int i = 0; i < N; i += 1) {
			L.addLast(i);
		}

		for (int i = 0; i < N; i += 1) {
			L.addLast(L.get(i));
		}
	}

}
