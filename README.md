WebServer
=========
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-WebServer-lightgrey.svg?style=flat)](https://android-arsenal.com/details/1/2847)

Android Web Server (with [NanoHTTPD](http://nanohttpd.com/))

Image Result
-----

![Capture Project](http://i40.tinypic.com/2i7wrb8.png)

Usage
-----

```java
int port = 8008;
WebServer server = new WebServer(port);
```

Create
-----

```java
package com.mikhaellopez.webserver;

import java.io.File;
import java.io.IOException;
import android.os.Environment;

public class WebServer extends NanoHTTPD {
	public WebServer(int port) throws IOException {
		super(port, new File(Environment.getExternalStorageDirectory().getAbsolutePath()));
	}
}
```

Download
-----

* [**NanoHTTPD**](https://github.com/lopspower/WebServer/blob/master/WebServer/src/com/mikhaellopez/webserver/NanoHTTPD.java)
