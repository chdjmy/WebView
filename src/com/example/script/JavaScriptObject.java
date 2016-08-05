package com.example.script;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class JavaScriptObject {
	Context mContext;
	Handler mHandler;
	public JavaScriptObject(Context context,Handler handler){
		mContext = context;
		mHandler = handler;
	}
	@JavascriptInterface
	public void fun(String name,String psd){
		Toast.makeText(mContext, name+psd, 0).show();
		Message msg = mHandler.obtainMessage();
		msg.what = 1;
		Bundle data = new Bundle();
		data.putString("info", name+psd);
		msg.setData(data);
		mHandler.sendMessage(msg);
		
	}

}
