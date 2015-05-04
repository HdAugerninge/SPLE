package Model;

import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public void setName(String name){
		this.name=name;
		System.out.println("Me name changed to " + name);
	}
	@Override
	 public boolean equals(Object other){
		if(other instanceof Person)
		  return this.name.equals(((Person)other).name);
		else return false;
	}
}
