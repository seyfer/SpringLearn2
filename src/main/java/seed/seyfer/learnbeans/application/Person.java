package seed.seyfer.learnbeans.application;

/**
 * Created by seyfer on 3/17/16.
 */
public class Person {

	private int id;
	private String name;
	Address address;
	private int taxId;

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Person() {
		super();
	}
	
	public static Person getInstance(int id, String name) {
		System.out.println("Factory method Person");
		return new Person(666, "vasya");
	}

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public void onCreate() {
		System.out.println("Created " + this);
	}
	
	public void onDestroy() {
		System.out.println("Destroyed " + this);
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + ", taxId=" + taxId + "]";
	}

	public void speak() {
		System.out.println("lala");
	}

}
