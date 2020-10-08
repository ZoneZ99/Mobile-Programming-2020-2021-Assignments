package id.ac.ui.cs.mobileprogramming.lab4.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import id.ac.ui.cs.mobileprogramming.lab4.models.Coffee;
import id.ac.ui.cs.mobileprogramming.lab4.repository.CoffeeRepository;

import java.util.List;

public class CoffeeViewModel extends ViewModel {

	private final MutableLiveData<String> selectedCoffee = new MutableLiveData<>();

	private final CoffeeRepository mRepository = CoffeeRepository.getInstance();

	public void selectCoffee(String coffeeName) {
		this.selectedCoffee.setValue(coffeeName);
	}

	public LiveData<String> getSelectedCoffee() {
		return this.selectedCoffee;
	}

	public List<String> getCoffeeList() {
		return this.mRepository.getCoffees();
	}

	public Coffee getCoffeeDetails(String name) {
		return this.mRepository.getCoffeeDetails(name);
	}
}
