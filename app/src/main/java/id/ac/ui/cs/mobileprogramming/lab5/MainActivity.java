package id.ac.ui.cs.mobileprogramming.lab5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import id.ac.ui.cs.mobileprogramming.lab5.databinding.ActivityMainBinding;

import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

	private ActivityMainBinding mBinding;

	private WifiManager mWifiManager;

	private BroadcastReceiver mWifiReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			List<ScanResult> scanResults = mWifiManager.getScanResults();
			mBinding.listWifi.setAdapter(
					new ArrayAdapter<>(
							getApplicationContext(),
							android.R.layout.simple_list_item_1,
							scanResults.stream().map(result -> result.SSID).collect(Collectors.toList())
					)
			);
			unregisterReceiver(this);
			mBinding.buttonScan.setEnabled(true);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBinding = ActivityMainBinding.inflate(getLayoutInflater());
		View view = mBinding.getRoot();
		setContentView(view);

		mWifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
		scanWifi();
	}

	public void scanWifiClickCallback(View view) {
		mBinding.buttonScan.setEnabled(false);
		scanWifi();
	}

	private void scanWifi() {
		Toast.makeText(getApplicationContext(), "Scanning...", Toast.LENGTH_SHORT).show();
		registerReceiver(mWifiReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
		mWifiManager.startScan();
	}
}