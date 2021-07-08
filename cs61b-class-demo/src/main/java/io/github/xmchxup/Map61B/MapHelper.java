package io.github.xmchxup.Map61B;

import java.util.List;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class MapHelper {
	public static <K, V> V get(ArrayMap<K, V> map, K key) {
		if (map.containsKey(key)) {
			return map.get(key);
		}
		return null;
	}

	public static <K extends Comparable<K>, V> K maxKey(ArrayMap<K, V> map) {
		List<K> keylist = map.keys();
		K largest = keylist.get(0);
		for (K k : keylist) {
			if (k.compareTo(largest) > 0) {
				largest = k;
			}
		}
		return largest;
	}

	public static void main(String[] args) {
		ArrayMap<Integer, String> isMap = new ArrayMap<>();
		System.out.println(MapHelper.get(isMap, 5));
	}
}
