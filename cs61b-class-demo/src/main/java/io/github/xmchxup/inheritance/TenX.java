package io.github.xmchxup.inheritance;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class TenX implements IntUnaryFunction {
	@Override
	public int apply(int x) {
		return 10 * x;
	}

	public static int do_twice(IntUnaryFunction f, int x) {
		return f.apply(f.apply(x));
	}

	public static void main(String[] args) {
		System.out.println(do_twice(new TenX(), 2));
	}
}
