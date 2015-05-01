package model;

public class Person {

	private String name;
	
	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
