AndroidWebServer
=========
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-WebServer-lightgrey.svg?style=flat)](https://android-arsenal.com/details/1/2847)
[![Platform](https://img.shields.io/badge/platform-android-green.svg)](https://developer.android.com/index.html)
[![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15)
[![Twitter](https://img.shields.io/badge/Twitter-@LopezMikhael-blue.svg?style=flat)](https://twitter.com/lopezmikhael)

This is a sample project for creating an **Android Web Server** using the [NanoHTTPD](https://github.com/NanoHttpd/nanohttpd) library.

Usage
-----

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

LICENSE
-----

**AndroidWebServer** by [Lopez Mikhael](https://mikhaellopez.com/) is licensed under a [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0).
