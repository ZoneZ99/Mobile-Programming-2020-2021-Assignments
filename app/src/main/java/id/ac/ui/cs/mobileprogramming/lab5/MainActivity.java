package id.ac.ui.cs.mobileprogramming.lab5;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import id.ac.ui.cs.mobileprogramming.lab5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

	private ActivityMainBinding mBinding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBinding = ActivityMainBinding.inflate(getLayoutInflater());
		View view = mBinding.getRoot();
		setContentView(view);
	}
}