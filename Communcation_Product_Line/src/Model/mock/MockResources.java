package Model.mock;

import java.util.ArrayList;

import Model.Person;

public class MockResources {

	public static final ArrayList<Person> PERSONS = new ArrayList<Person>() {
		private static final long serialVersionUID = 3013585760508529787L;
		{
			add(new Person("Klaus"));
			add(new Person("Kalle"));
			add(new Person("Horst"));
			add(new Person("Beate"));
			add(new Person("Ute"));
			add(new Person("Thorsten"));
			add(new Person("Heinz"));
			add(new Person("Waldtraut"));
		}
	};
}
