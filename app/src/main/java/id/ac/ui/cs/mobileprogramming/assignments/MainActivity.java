package id.ac.ui.cs.mobileprogramming.assignments;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import id.ac.ui.cs.mobileprogramming.assignments.utils.HelloWorldUtil;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.loadLibrary("native-hello-world-util");
	}

	public native String nativeHelloWorld(String input);


	public void submitHelloName(View view) {
		EditText inputField = findViewById(R.id.nameInputField);
		TextView helloDisplay = findViewById(R.id.helloDisplay);

//		String helloText = HelloWorldUtil.sayHello(inputField.getText().toString());
		String helloText = nativeHelloWorld(inputField.getText().toString());
		helloDisplay.setText(helloText);
	}
}