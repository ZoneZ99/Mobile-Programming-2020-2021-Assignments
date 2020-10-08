package id.ac.ui.cs.mobileprogramming.lab4.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import id.ac.ui.cs.mobileprogramming.lab4.databinding.CoffeesBinding;
import id.ac.ui.cs.mobileprogramming.lab4.viewmodels.CoffeeViewModel;
import id.ac.ui.cs.mobileprogramming.lab4.views.MainActivity;

public class CoffeeListFragment extends Fragment {

	public static final String TAG = "CoffeeListFragment";

	private CoffeesBinding mBinding;

	private CoffeeViewModel mViewModel;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater,
	                         @Nullable ViewGroup container,
	                         @Nullable Bundle savedInstanceState) {
		this.mBinding = CoffeesBinding.inflate(inflater, container, false);
		return this.mBinding.getRoot();
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		this.mViewModel = new ViewModelProvider(requireActivity()).get(CoffeeViewModel.class);

		this.mBinding.coffeeListView.setAdapter(
			new ArrayAdapter<>(
				this.getActivity(),
				android.R.layout.simple_list_item_1,
				this.mViewModel.getCoffeeList()
			)
		);

		this.mBinding.coffeeListView.setOnItemClickListener((parent, view, position, id) -> {
			TextView textView = (TextView) view;
			this.mViewModel.selectCoffee(textView.getText().toString());
			((MainActivity) requireActivity()).showCoffeeDetailFragment();
		});
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		this.mBinding = null;
	}
}
