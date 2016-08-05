package com.example.script;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class JavaScriptObject {
	Context mContext;
	public JavaScriptObject(Context context){
		mContext = context;
	}
	@JavascriptInterface
	public void fun(String name,String psd){
		Toast.makeText(mContext, name+psd, 0).show();
	}

}
