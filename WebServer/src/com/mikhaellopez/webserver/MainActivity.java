package com.mikhaellopez.webserver;

import java.io.IOException;

import android.app.Activity;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	private int port = 8008;
	private WebServer server;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView tv = (TextView)findViewById(R.id.tvInfo);
		WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
		int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
		final String formatedIpAddress = String.format("%d.%d.%d.%d", (ipAddress & 0xff), (ipAddress >> 8 & 0xff), (ipAddress >> 16 & 0xff), (ipAddress >> 24 & 0xff));
		tv.setText("http://" + formatedIpAddress + ":" + port);
	}

	@Override
	protected void onResume() {
		super.onResume();
		try {
			server = new WebServer(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (server != null)
			server.stop();
	}

}
