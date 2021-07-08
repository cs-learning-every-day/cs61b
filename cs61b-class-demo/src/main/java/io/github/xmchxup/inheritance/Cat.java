package io.github.xmchxup.inheritance;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class Cat extends Animal {

	public Cat(String name, int age) {
		super(name, age);
		this.noise = "Meow!";
	}


	@Override
	public void greet() {
		System.out.println("Cat " + name + " says: " + makeNoise());
	}

}
