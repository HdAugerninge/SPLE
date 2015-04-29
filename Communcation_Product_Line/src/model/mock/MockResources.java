package model.mock;

import java.util.ArrayList;
import java.util.List;

import model.Person;

public class MockResources {

	public static final ArrayList<Person> PERSONS = new ArrayList<Person>() {
		private static final long serialVersionUID = 3013585760508529787L;
		{
			add(new Person("Paul"));
			add(new Person("Frieda"));
			add(new Person("Helmut"));
		}
	};
}
