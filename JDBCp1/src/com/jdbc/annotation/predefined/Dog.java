package com.jdbc.annotation.predefined;

public class Dog extends Animal {
	
	@Override  // talks to Compiler and confirm the method from Super
	public void makeSound() {
		System.out.println("Dog Barking!");
	}
	
	@Override
	public void eat() {
		System.out.println("Dog Eating!");
	}
	
	@Deprecated
	public void move() {
		System.out.println("Dog is running !");
	}

}
