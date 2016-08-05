# WebView
这是一个WebView和JS交互的测试，
HTML文件放在本地的assets文件夹下，
感觉这是用html替换了layout.xml来做布局文件，
webView.loadURL(file:///android_asset/index.html)类比到setContentView,
javaScriptObj.fun1()类比到getText(),
webView.loadUrl("javascript:fun2()")类比到setText(),
还没深入原理，先测试一下。
