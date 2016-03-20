package seed.seyfer.learnbeans.application;

public class PersonFactory {
	public Person create(int id, String name) {
		System.out.println("Person Factory");
		return new Person(id, name);
	}
}
