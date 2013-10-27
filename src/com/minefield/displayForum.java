package com.minefield;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.Window;

import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class displayForum extends SherlockActivity {
	WebView mWebView;

	@SuppressWarnings("deprecation")
	public void onCreate(Bundle savedInstanceState) {
		
		//This has to be called before setContentView and you must use the
        //class in com.actionbarsherlock.view and NOT android.view
        requestWindowFeature(Window.FEATURE_PROGRESS);
        
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webforum);
		
		mWebView = (WebView) findViewById(R.id.webviewforum);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.getSettings().setSavePassword(true);
		mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		
		mWebView.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress) {
				//Normalize our progress along the progress bar's scale
	            int myprogress = (Window.PROGRESS_END - Window.PROGRESS_START) / 100 * progress;
	            setSupportProgress(myprogress);
			}
		});
		
		mWebView.setWebViewClient(new WebViewClient() {
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				Toast.makeText(displayForum.this, "Oh non! " + description,
						Toast.LENGTH_SHORT).show();
			}
		});
		
		mWebView.loadUrl("http://www.minefield.fr/forum");
		mWebView.setWebViewClient(new ForumMFWebViewClient());

		BitmapDrawable bg = (BitmapDrawable) getResources().getDrawable(R.drawable.bgbar3);
		bg.setTileModeXY(TileMode.REPEAT, TileMode.CLAMP);
		getSupportActionBar().setBackgroundDrawable(bg);
		getSupportActionBar().setLogo(R.drawable.paper);

		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		getSupportActionBar().setTitle(R.string.forum_title);
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			this.finish();
			return false;
		}
		return false;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
			mWebView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	protected void onDestroy() {
		super.onDestroy();
	}

	protected void onPause() {
		super.onPause();
	}

	protected void onRestart() {
		super.onRestart();
	}

	protected void onResume() {
		super.onResume();
	}

	protected void onStart() {
		super.onStart();
	}

	protected void onStop() {
		super.onStop();
	}
}

class ForumMFWebViewClient extends WebViewClient {
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		view.loadUrl(url);
		return true;
	}
}