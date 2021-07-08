package io.github.xmchxup.inheritance;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class Dog extends Animal {

	public Dog(String name, int age) {
		super(name, age);
		noise = "Woof!";
	}

	public void bark() {
		System.out.println("bark");
	}

	public void barkMany(int N) {
		for (int i = 0; i < N; i += 1) {
			bark();
		}
	}

	@Override
	public void greet() {
		System.out.println("Dog " + name + " says: " + makeNoise());
	}

	public void playFetch() {
		System.out.println("Fetch, " + name + "!");
	}

}
