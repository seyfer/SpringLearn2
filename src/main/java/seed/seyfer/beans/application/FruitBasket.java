package seed.seyfer.beans.application;

import java.util.List;

public class FruitBasket {

	private String name;
	private List<String> fruits;

	public FruitBasket(String name, List<String> fruits) {
		super();
		this.name = name;
		this.fruits = fruits;
	}

	@Override
	public String toString() {
		return "FruitBasket [name=" + name + ", fruits=" + fruits + "]";
	}
	
}
