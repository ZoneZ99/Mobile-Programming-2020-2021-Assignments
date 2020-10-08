package id.ac.ui.cs.mobileprogramming.lab4.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import id.ac.ui.cs.mobileprogramming.lab4.databinding.CoffeeDetailsBinding;
import id.ac.ui.cs.mobileprogramming.lab4.models.Coffee;
import id.ac.ui.cs.mobileprogramming.lab4.viewmodels.CoffeeViewModel;

public class CoffeeDetailFragment extends Fragment {

	private CoffeeViewModel mViewModel;

	private CoffeeDetailsBinding mBinding;

	public static final String TAG = "CoffeeDetailFragment";

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
		this.mBinding.name.setText(coffee.getName());
		String originText = "Origin: " + coffee.getOrigin();
		String typeText = "Type: " + coffee.getType();
		String aromaText = "Aroma: " + coffee.getAroma();
		String tasteText = "Taste: " + coffee.getTaste();
		this.mBinding.origin.setText(originText);
		this.mBinding.type.setText(typeText);
		this.mBinding.aroma.setText(aromaText);
		this.mBinding.taste.setText(tasteText);
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater,
	                         @Nullable ViewGroup container,
	                         @Nullable Bundle savedInstanceState) {
		this.mBinding = CoffeeDetailsBinding.inflate(inflater, container, false);
		return this.mBinding.getRoot();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		this.mBinding = null;
	}
}
