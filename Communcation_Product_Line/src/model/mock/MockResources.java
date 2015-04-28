package model.mock;

import java.util.ArrayList;
import java.util.List;

import model.Person;

public class MockResources {

	private static ArrayList<Person> persons = new ArrayList<Person>();
	public static List<Person> getMockedPersons()
	{
		if(persons.size() == 0) {
		persons.add(new Person("Paul"));
		persons.add(new Person("Frieda"));
		persons.add(new Person("Helmut"));
		}
		return persons;
	}
}
