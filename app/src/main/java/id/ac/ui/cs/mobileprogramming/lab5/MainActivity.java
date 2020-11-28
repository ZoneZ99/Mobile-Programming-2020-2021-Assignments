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
import id.ac.ui.cs.mobileprogramming.lab5.service.ServiceResponse;
import id.ac.ui.cs.mobileprogramming.lab5.service.WifiData;
import id.ac.ui.cs.mobileprogramming.lab5.service.WifiDataService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

	private ActivityMainBinding mBinding;

	private WifiManager mWifiManager;

	private List<WifiData> mWifiData = new ArrayList<>();

	private BroadcastReceiver mWifiReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			List<ScanResult> scanResults = mWifiManager.getScanResults();
			if (scanResults.isEmpty()) {
				mBinding.buttonSendWifiData.setVisibility(View.GONE);
			} else {
				mBinding.listWifi.setAdapter(
						new ArrayAdapter<>(
								getApplicationContext(),
								android.R.layout.simple_list_item_1,
								scanResults.stream()
										.map(result -> result.SSID)
										.collect(Collectors.toList())
						)
				);
				mWifiData = scanResults.stream()
						.map(result -> new WifiData(result.SSID, result.BSSID, result.frequency))
						.collect(Collectors.toList());
				mBinding.buttonSendWifiData.setVisibility(View.VISIBLE);
			}
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
		mBinding.buttonSendWifiData.setVisibility(View.GONE);
		scanWifi();
	}

	public void scanWifiClickCallback(View view) {
		mBinding.buttonScan.setEnabled(false);
		mBinding.buttonSendWifiData.setVisibility(View.GONE);
		scanWifi();
	}

	private void scanWifi() {
		Toast.makeText(this, "Scanning...", Toast.LENGTH_SHORT).show();
		registerReceiver(mWifiReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
		mWifiManager.startScan();
	}

	public void sendWifiDataClickCallback(View view) {
		Toast.makeText(this, "Sending...", Toast.LENGTH_SHORT).show();
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://a8289c9864293182fccdab7a5aeb4505.m.pipedream.net")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		WifiDataService service = retrofit.create(WifiDataService.class);
		Call<ServiceResponse> request = service.sendWifiData(mWifiData);
		request.enqueue(new Callback<ServiceResponse>() {
			@Override
			public void onResponse(Call<ServiceResponse> call, Response<ServiceResponse> response) {
				String result = "Success: " + response.body().isSuccess();
				sendResponseResult(result);
			}

			@Override
			public void onFailure(Call<ServiceResponse> call, Throwable t) {
				sendResponseResult("Failed to send WiFi data");
			}
		});
	}

	private void sendResponseResult(String result) {
		Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
	}
}