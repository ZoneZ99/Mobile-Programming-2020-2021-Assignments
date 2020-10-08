package id.ac.ui.cs.mobileprogramming.lab4.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import id.ac.ui.cs.mobileprogramming.lab4.R;
import id.ac.ui.cs.mobileprogramming.lab4.models.Coffee;
import id.ac.ui.cs.mobileprogramming.lab4.viewmodels.CoffeeViewModel;

public class CoffeeDetailFragment extends Fragment {

	private CoffeeViewModel mViewModel;

	public static final String TAG = "CoffeeDetailFragment";

	private TextView name;
	private TextView origin;
	private TextView type;
	private TextView aroma;
	private TextView taste;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.mViewModel = new ViewModelProvider(requireActivity()).get(CoffeeViewModel.class);
		this.mViewModel.getSelectedCoffee().observe(this, item -> {
			Coffee coffee = mViewModel.getCoffeeDetails(item);
			this.setCoffeeDetails(coffee);
		});
	}

	private void setCoffeeDetails(Coffee coffee) {
		this.name.setText(coffee.getName());
		String originText = "Origin: " + coffee.getOrigin();
		String typeText = "Type: " + coffee.getType();
		String aromaText = "Aroma: " + coffee.getAroma();
		String tasteText = "Taste: " + coffee.getTaste();
		this.origin.setText(originText);
		this.type.setText(typeText);
		this.aroma.setText(aromaText);
		this.taste.setText(tasteText);
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater,
	                         @Nullable ViewGroup container,
	                         @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.coffee_details, container, false);
		this.name = view.findViewById(R.id.name);
		this.origin = view.findViewById(R.id.origin);
		this.type = view.findViewById(R.id.type);
		this.aroma = view.findViewById(R.id.aroma);
		this.taste = view.findViewById(R.id.taste);

		return view;
	}
}
