package seed.seyfer.beans.application;

public class Address {
	private String street;
	private String postcode;

	public Address() {
		super();
	}

	public Address(String street, String postcode) {
		super();
		this.street = street;
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", postcode=" + postcode + "]";
	}

	public void onBeanInit() {
		System.out.println("Created " + this);
	}

	public void onBeanDestroy() {
		// TODO Auto-generated method stub
		System.out.println("Destroyed " + this);
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
}
