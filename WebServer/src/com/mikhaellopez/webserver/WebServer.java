package com.mikhaellopez.webserver;

import java.io.File;
import java.io.IOException;

import android.os.Environment;
import android.util.Log;

public class WebServer extends NanoHTTPD {
	private static final String SERVER_BASE_DIR = Environment
			.getExternalStorageDirectory().getAbsolutePath() + "/web";

	public WebServer(int port) throws IOException {
		super(port, new File(SERVER_BASE_DIR));
		Log.i("SERVER_BASE_DIR", SERVER_BASE_DIR);
	}
}
