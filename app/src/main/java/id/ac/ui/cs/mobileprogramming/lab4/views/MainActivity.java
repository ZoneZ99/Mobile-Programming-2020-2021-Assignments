package id.ac.ui.cs.mobileprogramming.lab4.views;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import id.ac.ui.cs.mobileprogramming.lab4.R;
import id.ac.ui.cs.mobileprogramming.lab4.models.Coffee;
import id.ac.ui.cs.mobileprogramming.lab4.views.fragments.CoffeeDetailFragment;
import id.ac.ui.cs.mobileprogramming.lab4.views.fragments.CoffeeListFragment;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			CoffeeListFragment fragment = new CoffeeListFragment();
			getSupportFragmentManager()
				.beginTransaction()
				.add(R.id.fragment_container, fragment, CoffeeListFragment.TAG)
				.commit();
		}
	}

	public void showCoffeeDetailFragment() {
		CoffeeDetailFragment fragment = new CoffeeDetailFragment();
		getSupportFragmentManager()
			.beginTransaction()
			.replace(R.id.fragment_container, fragment, CoffeeDetailFragment.TAG)
			.addToBackStack(CoffeeDetailFragment.TAG)
			.commit();
	}
}