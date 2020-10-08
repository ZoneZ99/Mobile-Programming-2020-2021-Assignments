package id.ac.ui.cs.mobileprogramming.lab4.repository;

import id.ac.ui.cs.mobileprogramming.lab4.models.Coffee;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CoffeeRepository {

	private HashMap<String, Coffee> coffees = new HashMap<>();

	private static CoffeeRepository instance;

	private CoffeeRepository() {
		this.coffees.put("A", new Coffee("A", "B", "C" , "D", "E"));
		this.coffees.put("F", new Coffee("F", "G", "H", "I", "J"));
	}

	public static CoffeeRepository getInstance() {
		 if (instance == null) {
		 	instance = new CoffeeRepository();
		 }
		 return instance;
	}

	public List<String> getCoffees() {
		return this.coffees.values()
			.stream()
			.map(Coffee::getName)
			.collect(Collectors.toList());
	}

	public Coffee getCoffeeDetails(String name) {
		return this.coffees.get(name);
	}
}
