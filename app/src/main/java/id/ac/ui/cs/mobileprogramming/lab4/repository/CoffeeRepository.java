package id.ac.ui.cs.mobileprogramming.lab4.repository;

import id.ac.ui.cs.mobileprogramming.lab4.models.Coffee;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CoffeeRepository {

	private HashMap<String, Coffee> coffees = new HashMap<>();

	private static CoffeeRepository instance;

	private CoffeeRepository() {
		Coffee[] coffeeArray = new Coffee[]{
			new Coffee(
				"Arabica Gayo Takengon",
				"Gayo Takengon",
				"Arabica",
				"Brown sugar, dark chocolate, sweet, and citrus",
				"Chocolate caramel and unripe orange"
			),
			new Coffee(
				"Robusta Lampung",
				"Lampung",
				"Robusta",
				"Chocolaty, brown sugar, woody, and earthy",
				"Brown sugar, cocoa, woody, and earthy"
			),
			new Coffee(
				"Arabica Gayo Wine",
				"Gayo",
				"Arabica",
				"Brown sugar, dark chocolate, fruity, and berry",
				"Strong wine, berry, alcohol-like, fruity, sweet"
			),
			new Coffee(
				"Arabica Ethiopia Sidamo",
				"Ethiopia Sidamo",
				"Arabica",
				"Floral",
				"Spice, wine, well-balanced with notes of chocolate"
			),
			new Coffee(
				"Gourment Blend",
				"Blend",
				"Arabica",
				"Brown sugar and orange zest",
				"Brown sugar, sweet, and dark chocolate"
			)
		};
		for (Coffee coffee : coffeeArray) {
			this.coffees.put(coffee.getName(), coffee);
		}
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
			.sorted()
			.collect(Collectors.toList());
	}

	public Coffee getCoffeeDetails(String name) {
		return this.coffees.get(name);
	}
}
