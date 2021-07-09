package io.github.xmchxup.bst;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class BST<Key extends Comparable> {
	private Key key;
	private BST<Key> left;
	private BST<Key> right;

	public BST(Key key, BST left, BST Right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}

	public BST(Key key) {
		this.key = key;
	}

	public static <Key extends Comparable> BST find(BST T, Key sk) {
		if (T == null) {
			return null;
		}
		int cmp = sk.compareTo(T.key);
		if (cmp == 0) {
			return T;
		} else if (cmp < 0) {
			return find(T.left, sk);
		} else {
			return find(T.right, sk);
		}
	}

	public static <Key extends Comparable> BST insert(BST T, Key ik) {
		if (T == null) {
			return new BST(ik);
		}
		int cmp = ik.compareTo(T.key);
		if (cmp < 0) {
			T.left = insert(T.left, ik);
		} else if (cmp > 0) {
			T.right = insert(T.right, ik);
		}
		return T;
	}

	public static <Key extends Comparable> BST delete(BST T, Key ik) {
		if (T == null) return null;

		int cmp = ik.compareTo(T.key);
		if (cmp < 0) {
			T.left = delete(T.left, ik);
		} else if (cmp > 0) {
			T.right = delete(T.right, ik);
		} else {
			if (T.right == null) return T.left;
			if (T.left == null) return T.right;
			T.right.left = T.left;
			return T.right;
		}
		return T;
	}


	public static void main(String[] args) {
		BST<Integer> root = new BST<>(15);
		insert(root, 6);
		insert(root, 4);
		insert(root, 1);
		insert(root, 5);
		insert(root, 7);
		insert(root, 23);
		insert(root, 71);
		insert(root, 77);
		insert(root, 80);
		insert(root, 50);
		insert(root, 25);
		insert(root, 29);
		insert(root, 61);

		assertEquals(7, find(root, 7).key);
		assertNull(find(root, 11));

		delete(root, 29);
		delete(root, 4);
		delete(root, 50);
		delete(root, 77);

		assertEquals(61, find(root, 71).left.key);
		assertEquals(80, find(root, 71).right.key);

		delete(root, 71);
		root = delete(root, 15);

		assertEquals(80, find(root, 23).right.key);
		assertEquals(61, find(root, 80).left.key);
	}

}
