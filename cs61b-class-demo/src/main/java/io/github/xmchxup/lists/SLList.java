package io.github.xmchxup.lists;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class SLList {
	public class IntNode {
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
		}
	}

	//	private IntNode first;
	private IntNode sentinel = new IntNode(-1, null);
	private int size;


	public SLList() {
		size = 0;
	}

	public SLList(int x) {
		sentinel.next = new IntNode(x, null);
		size = 1;
	}

	/**
	 * Adds an item to the front of the list.
	 */
	public void addFirst(int x) {
		sentinel.next = new IntNode(x, sentinel.next);
		size += 1;
	}

	/**
	 * Retrieves the front item from the list.
	 */
	public int getFirst() {
		return sentinel.next.item;
	}

	/**
	 * Retrieves the front item from the list.
	 */
	public int getLast() {
		IntNode last = sentinel;
		while (last.next != null) {
			last = last.next;
		}
		return last.item;
	}


	/**
	 * Adds an item to the end of the list.
	 */
	public void addLast(int x) {
		size++;

		// 增加哨兵节点 Clean Code
//		if (sentinel == null) {
//			sentinel = new IntNode(x, null);
//			return;
//		}

		IntNode p = sentinel;
		while (p.next != null) {
			p = p.next;
		}
		p.next = new IntNode(x, null);
	}

	/**
	 * Returns the number of items in the list using recursion.
	 */
	public int size() {
		return size;
//		return size(first);
	}

	public void insert(int item, int position) {
		if (position < 0) throw new IllegalArgumentException("position should be greater than 0");
		if (position > size) {
			addLast(item);
		} else {
			IntNode prevNode = node(position - 1);
			prevNode.next = new IntNode(item, prevNode.next);
			size++;
		}
	}

	public void reverse() {
		Deque<IntNode> stack = new ArrayDeque<>();
		IntNode p = this.sentinel.next;
		while (p != null) {
			stack.push(p);
			p = p.next;
		}

		IntNode head = stack.pop();
		p = head;
		while (!stack.isEmpty()) {
			p.next = stack.pop();
			p = p.next;
		}
		p.next = null;
		this.sentinel.next = head;
	}

	public void reverseR() {
		reverse(this.sentinel.next);
	}

	private IntNode reverse(IntNode node) {
		if (node.next == null) {
			this.sentinel.next = node;
			return node;
		}
		IntNode prevNode = reverse(node.next);
		prevNode.next = node;
		node.next = null;
		return node;
	}

	/**
	 * 返回p位置的节点
	 */
	private IntNode node(int p) {
		IntNode cur = this.sentinel.next;
		while (p > 0) {
			cur = cur.next;
			p--;
		}
		return cur;
	}

	private int size(IntNode node) {
		if (node == null) return 0;
		return 1 + size(node.next);
	}

	public static void main(String[] args) {
		SLList l = new SLList(1);
		l.addFirst(2);
		l.addFirst(3);
		l.addLast(4);
		l.insert(5, 100);
		l.insert(6, 3);
		l.reverseR();
		System.out.println(l.getFirst());
		System.out.println(l.getLast());
		System.out.println(l.size());
	}
}
