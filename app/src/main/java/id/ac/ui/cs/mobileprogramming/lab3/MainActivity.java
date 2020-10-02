package id.ac.ui.cs.mobileprogramming.lab3;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

	private int seconds = 0;
	private boolean running;
	private final String LOG_TAG = "Lab3";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(this.LOG_TAG, "onCreate");

		if (savedInstanceState != null) {
			this.seconds = savedInstanceState.getInt("seconds");
			this.running = savedInstanceState.getBoolean("running");
		}
		this.runTimer();
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d(this.LOG_TAG, "onStart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d(this.LOG_TAG, "onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d(this.LOG_TAG, "onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d(this.LOG_TAG, "onStop");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d(this.LOG_TAG, "onRestart");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(this.LOG_TAG, "onDestroy");
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		outState.putInt("seconds", this.seconds);
		outState.putBoolean("running", this.running);
	}

	@Override
	public void onBackPressed() {
		Toast.makeText(
			getApplicationContext(),
			"Tap the 'EXIT' button to exit for real.",
			Toast.LENGTH_SHORT
		).show();
	}

	public void onClickStart(View view) {
		this.running = true;
	}

	public void onClickStop(View view) {
		this.running = false;
	}

	public void onClickReset(View view) {
		this.running = false;
		this.seconds = 0;
	}

	private void runTimer() {
		final TextView timeView = findViewById(R.id.time_view);
		final Handler handler = new Handler();
		handler.post(new Runnable() {
			@Override
			public void run() {

				int hours = seconds / 3600;
				int minutes = (seconds % 3600) / 60;
				int secs = seconds % 60;
				String time = String.format(
					Locale.getDefault(),
					"%d:%02d:%02d", hours, minutes, secs
				);
				timeView.setText(time);
				if (running) {
					seconds++;
				}
				handler.postDelayed(this, 1000);
			}
		});
	}

	public void onClickExit(View view) {
		this.finish();
	}
}