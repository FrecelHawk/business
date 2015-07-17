package cn.caregg.o2o.business.ui.view;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.page.inf.ConnectionInf;
import cn.caregg.o2o.business.ui.base.BaseWebView;

import com.lidroid.xutils.util.LogUtils;

/**
 * @ClassName: MyWebView
 * @Description: TODO
 * @author FH 
 * @date 2015年7月13日 上午11:22:42
 * 
*/

@SuppressLint("SetJavaScriptEnabled")
public abstract class MyWebView extends BaseWebView implements ConnectionInf{

	protected WebView  webView;
	
	protected ViewGroup mNavigation;

	protected MyWebViewClient  webViewClient;
    
	protected MyWebChromeClient chromeClient;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.carnest_webview_activity);
		initView();
		settings();
		initialListnner();
	}

	protected void initialListnner() {
		webView.setOnKeyListener(new View.OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if(event.getAction()==KeyEvent.ACTION_DOWN){
					if(keyCode==KeyEvent.KEYCODE_BACK
							&&webView.canGoBack()){
						webView.goBack();
						return true;
					}
				}
				return false;
			}
		});
	}

	private void settings() {
		WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true); 
        chromeClient  = new MyWebChromeClient();
        webViewClient = new MyWebViewClient();
        webView.setWebChromeClient(chromeClient);
        webView.setWebViewClient(webViewClient);
	}

	private void initView() {
		webView = (WebView) findViewById(R.id.webView);
	//	mNavigation = (ViewGroup) findViewById(R.id.);
		
	}
	
	
	public void loadPage(String url){
		webView.loadUrl(url);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	
	
	
	private class MyWebChromeClient extends WebChromeClient{
		
		@Override
		public void onProgressChanged(WebView view, int newProgress) {
			// TODO Auto-generated method stub
			super.onProgressChanged(view, newProgress);
		}
		
		
		
	};
	
	
	private class MyWebViewClient  extends WebViewClient{
			
			@SuppressWarnings("unused")
			private long startTime;
			
			@SuppressWarnings("unused")
			private long endTime;
			
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				super.onPageStarted(view, url, favicon);
				webView.getSettings().setBlockNetworkImage(true);
				startTime  = System.currentTimeMillis();
			}
			
			@Override
			public void onPageFinished(WebView view, String url) {
				// TODO Auto-generated method stub
				super.onPageFinished(view, url);
				webView.getSettings().setBlockNetworkImage(false);
				endTime = System.currentTimeMillis();
					
			}
			
			
			@Override
			public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
				// TODO Auto-generated method stub
				super.onReceivedError(view, errorCode, description, failingUrl);
				LogUtils.e(description);
				
			}
			
			
			@Override
			public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
				// TODO Auto-generated method stub
				super.onReceivedSslError(view, handler, error);
				LogUtils.e(error.toString());
			}
			
			
		};
		
	

	
}
