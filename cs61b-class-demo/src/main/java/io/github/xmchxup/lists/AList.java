package io.github.xmchxup.lists;

import java.util.NoSuchElementException;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class AList {
	private static final int DEFAULT_CAPACITY = 10;
	private int size;
	private int[] items;

	/**
	 * Creates an empty list.
	 */
	public AList() {
		size = 0;
		items = new int[DEFAULT_CAPACITY];
	}


	/**
	 * Inserts X into the back of the list.
	 */
	public void addLast(int x) {
		if (size == items.length) resize(size << 1);
		items[size++] = x;
	}

	private void resize(int capacity) {
		int[] newItems = new int[capacity];
		for (int i = 0; i < items.length; i++) {
			newItems[i] = items[i];
		}
		items = newItems;
	}

	/**
	 * Returns the item from the back of the list.
	 */
	public int getLast() {
		if (size == 0) throw new NoSuchElementException();
		return items[size - 1];
	}

	/**
	 * Gets the ith item in the list (0 is the front).
	 */
	public int get(int i) {
		return items[i];
	}

	/**
	 * Returns the number of items in the list.
	 */
	public int size() {
		return size;
	}

	/**
	 * Deletes item from back of the list and
	 * returns deleted item.
	 */
	public int removeLast() {
		int item = items[size - 1];
		size--;
		if (items.length > DEFAULT_CAPACITY && size < (items.length / 4))
			resize(items.length / 4);
		return item;
	}

	public static int[] insert(int[] arr, int item, int position) {
		int[] result = new int[arr.length + 1];
		position = Math.min(arr.length, position);
		for (int i = 0; i < position; i++) {
			result[i] = arr[i];
		}
		result[position] = item;
		for (int i = position; i < arr.length; i++) {
			result[i + 1] = arr[i];
		}
		return result;
	}

	public static void reverse(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			int j = arr.length - i - 1;
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
	}

	public static int[] replicate(int[] arr) {
		int total = 0;
		for (int item : arr) {
			total += item;
		}
		int[] result = new int[total];
		int idx = 0;
		for (int item : arr) {
			for (int i = 0; i < item; i++) {
				result[idx++] = item;
			}
		}
		return result;
	}
}
