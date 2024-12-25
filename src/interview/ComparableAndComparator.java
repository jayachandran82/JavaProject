package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableAndComparator {

	public static void main(String[] args) {

		Person p1 = new Person(10, "Mikey", 25, 10000);
		Person p2 = new Person(20, "Arun", 29, 20000);
		Person p3 = new Person(5, "Lisa", 35, 5000);
		Person p4 = new Person(1, "Pankaj", 32, 50000);
		List<Person> person = new ArrayList<Person>();
		person.add(p1);
		person.add(p2);
		person.add(p3);
		person.add(p4);
		//Sorting Comparable inferface for single element
		Collections.sort(person);
		for (Person p : person) {
			System.out.println("Id, Name : " + p.getId() + " -> " + p.getName());
		}
		
		// Sorting Comparator interface for multiple element
		Collections.sort(person, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				 return (int) (p1.getSalary() - p2.getSalary());
			}

		});
		System.out.println("Comparable End... \n");
		
		for (Person p : person) {
			System.out.println("Salary, Name, Id  : " +p.getSalary()  + " -> " + p.getName()+ " -> " + p.getId());
		}
		System.out.println("End... :");

	}

}

class Person implements Comparable<Person>{

	private int id;
	private String name;
	private int age;
	private long salary;

	public Person(int id, String name, int age, int salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	@Override
	public int compareTo(Person p) {
		return this.id - p.id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public long getSalary() {
		return salary;
	}
}
