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

public class displayBourse extends SherlockActivity {
	
	WebView mWebView;

	public void onCreate(Bundle savedInstanceState) {
		
		requestWindowFeature(Window.FEATURE_PROGRESS);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webbourse);
		
		mWebView = (WebView) findViewById(R.id.webviewbourse);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.getSettings().setLoadsImagesAutomatically(true);

		mWebView.setInitialScale(110);
		mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		//mWebView.getSettings().setBuiltInZoomControls(true); // zooming
		
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
				Toast.makeText(displayBourse.this, "Oh non! " + description,
						Toast.LENGTH_SHORT).show();
			}
		});

		mWebView.loadUrl("http://www.minefield.fr/gui/bourse.php");
		mWebView.setWebViewClient(new bourseWebViewClient());

		BitmapDrawable bg = (BitmapDrawable) getResources().getDrawable(
				R.drawable.bgbar3);
		bg.setTileModeXY(TileMode.REPEAT, TileMode.CLAMP);
		getSupportActionBar().setBackgroundDrawable(bg);
		getSupportActionBar().setLogo(R.drawable.or);

		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		getSupportActionBar().setTitle(R.string.bourse_title);
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

class bourseWebViewClient extends WebViewClient {
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		view.loadUrl(url);
		return true;
	}
}