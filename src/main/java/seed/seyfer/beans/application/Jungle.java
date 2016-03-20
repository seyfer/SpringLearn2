package seed.seyfer.beans.application;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jungle {
	private Animal largest;
	private List<Animal> animals;
	private Map<String, String> foods = new HashMap<String, String>();
	private Map<String, Animal> mappedAnimals = new HashMap<String, Animal>();
	
	public Map<String, Animal> getMappedAnimals() {
		return mappedAnimals;
	}

	public void setMappedAnimals(Map<String, Animal> mappedAnimals) {
		this.mappedAnimals = mappedAnimals;
	}

	public Map<String, String> getFoods() {
		return foods;
	}

	public void setFoods(Map<String, String> foods) {
		this.foods = foods;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public Animal getLargest() {
		return largest;
	}

	public void setLargest(Animal largest) {
		this.largest = largest;
	}

	@Override
	public String toString() {
		return "Jungle [largest=" + largest + ", \n animals=" + animals + ", \n foods=" + foods + ", \n mappedAnimals="
				+ mappedAnimals + "]";
	}
}
