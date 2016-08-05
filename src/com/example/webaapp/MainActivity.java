package com.example.webaapp;

import com.example.script.JavaScriptObject;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

	private WebView webView;
	private JavaScriptObject jsobject;
	private Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		webView = (WebView)findViewById(R.id.webView);
		handler = new WebViewUpdateHandler();
		jsobject = new JavaScriptObject(this,handler);
		
		//init
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setDefaultTextEncodingName("utf-8");
		webView.addJavascriptInterface(jsobject, "jsobject");
		webView.loadUrl("file:///android_asset/index.html");//访问本地
		//webView.loadUrl("http://www.google.com");//访问网络
		
		webView.setWebViewClient(new WebViewClient(){
			//点击WebView里的链接时仍然在该WebView里，不跳转到浏览器里
			public boolean shouldOverrideUrlLoading(WebView view,String url){
				view.loadUrl(url);
				return true;
			}
		});
		webView.setWebChromeClient(new WebChromeClient(){
			
		});
		
		
	
	}
	//当前文本只有一个activity，按返回键会退出Activity，随机结束WebView
	//因此需要重写onKeyDown，转为WebView返回上一页
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(webView.canGoBack()&&keyCode==KeyEvent.KEYCODE_BACK){
			webView.goBack();
			return true;
		}
		return false;
	}
	
	class WebViewUpdateHandler extends Handler{

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			Bundle data = msg.getData();
			String info = data.getString("info");
			switch(msg.what){
			case 1:
				webView.loadUrl("javascript:displayResult("+info+");");
				break;
			default:
				break;
			}
			
			
			super.handleMessage(msg);
		}
		
	}
	 
}
