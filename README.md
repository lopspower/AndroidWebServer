<p align="center"><a target="_blank" href="https://play.google.com/store/apps/details?id=com.mikhaellopez.androidwebserver" title="Download on Google Play Store"><img src="http://i68.tinypic.com/igg1o2.png"></a></p>

AndroidWebServer
=========
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-WebServer-lightgrey.svg?style=flat)](https://android-arsenal.com/details/1/2847)
[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![API](https://img.shields.io/badge/API-8%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=8)
[![PayPal](https://img.shields.io/badge/paypal-donate-yellow.svg)](https://www.paypal.me/LopezMikhael)
[![Twitter](https://img.shields.io/badge/Twitter-@LopezMikhael-blue.svg?style=flat)](http://twitter.com/lopezmikhael)

This is a sample project for creating an **Android Web Server** using the [NanoHTTPD](https://github.com/NanoHttpd/nanohttpd) library.

<a target="_blank" href="https://play.google.com/store/apps/details?id=com.mikhaellopez.androidwebserver">
  <img alt="Android app on Google Play" src="https://developer.android.com/images/brand/en_app_rgb_wo_45.png" />
</a>

Usage
-----

<img src="http://i67.tinypic.com/2iaajgz.png" width="250" align="right" hspace="20" />

1. To make an **Android Web Server** add [NanoHTTPD](https://github.com/NanoHttpd/nanohttpd) dependency in your build.gradle file: 

	```groovy
	compile 'org.nanohttpd:nanohttpd:2.2.0'
	```

2. After that, you must create an **Android Web Server** Class this way:

	```java
	public class AndroidWebServer extends NanoHTTPD {
	
	    public AndroidWebServer(int port) {
	        super(port);
	    }
	
	    public AndroidWebServer(String hostname, int port) {
	        super(hostname, port);
	    }
	    
	    //...
	}
	```

3. Add `serve()` method in your **Android Web Server** Class :

	```java
	@Override
	public Response serve(IHTTPSession session) {
	    String msg = "<html><body><h1>Hello server</h1>\n";
	    Map<String, String> parms = session.getParms();
	    if (parms.get("username") == null) {
	        msg += "<form action='?' method='get'>\n";
	        msg += "<p>Your name: <input type='text' name='username'></p>\n";
	        msg += "</form>\n";
	    } else {
	        msg += "<p>Hello, " + parms.get("username") + "!</p>";
		}
	    return newFixedLengthResponse( msg + "</body></html>\n" );
	}
	```

	`serve()` is a very important method beacause this is the response sent by your web server.
	
4. You can now instantiate and start your server in your activity. (Full implementation [**here**](/app/src/main/java/com/mikhaellopez/androidwebserver/MainActivity.java))
	```java
	AndroidWebServer androidWebServer = new AndroidWebServer(port);
	androidWebServer.start();
	```
	
	```java
	androidWebServer.stop();
	```

LICENCE
-----

**AndroidWebServer** by [Lopez Mikhael](http://mikhaellopez.com/) is licensed under a [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0).
