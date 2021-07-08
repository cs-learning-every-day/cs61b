package io.github.xmchxup.inheritance;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class WordUtils {
	public static String longest(List61B<String> list) {
		int maxDex = 0;
		for (int i = 0; i < list.size(); i++) {
			String longestString = list.get(maxDex);
			String thisString = list.get(i);
			if (thisString.length() > longestString.length()) {
				maxDex = i;
			}
		}
		return list.get(maxDex);
	}
	public static void peek(List61B<String> list) {
		System.out.println(list.getLast());
	}

	public static void peek(SLList<String> list) {
		System.out.println(list.getFirst());
	}


	public static void main(String[] args) {
		SLList<String> SP = new SLList<String>();
		List61B<String> LP = SP;
		SP.addLast("elk");
		SP.addLast("are");
		SP.addLast("cool");
		peek(SP);
		peek(LP);
	}
}
