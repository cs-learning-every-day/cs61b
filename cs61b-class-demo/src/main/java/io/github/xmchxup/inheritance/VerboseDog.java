package io.github.xmchxup.inheritance;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class VerboseDog extends Dog {
	public VerboseDog(String name, int age) {
		super(name, age);
	}

	@Override
	public void barkMany(int N) {
		System.out.println("As a dog, I say: ");
		for (int i = 0; i < N; i += 1) {
			bark();
		}
	}

	public static void main(String[] args) {
		VerboseDog dog = new VerboseDog("123",4);
		dog.barkMany(2);
	}
}
