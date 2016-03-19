package seed.seyfer.spring.application;

/**
 * Created by seyfer on 3/17/16.
 */
public class Person {
	
	private int id;
	private String name;
	
    public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Person() {
		super();
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

	public void speak() {
        System.out.println("lala");
    }

}
