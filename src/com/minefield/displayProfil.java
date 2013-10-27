package com.minefield;

import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.Window;

public class displayProfil extends SherlockActivity {

	private Editable name;
	private EditText pseudoField;
	private WebView mWebViewProfil;

	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		requestWindowFeature(Window.FEATURE_PROGRESS);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profil);

		BitmapDrawable bg = (BitmapDrawable) getResources().getDrawable(
				R.drawable.bgbar3);
		bg.setTileModeXY(TileMode.REPEAT, TileMode.CLAMP);
		getSupportActionBar().setBackgroundDrawable(bg);
		getSupportActionBar().setLogo(R.drawable.profil);

		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		getSupportActionBar().setTitle(R.string.profil_title);
		
		
		BitmapDrawable separator = (BitmapDrawable) getResources().getDrawable(
				R.drawable.red);
		separator.setTileModeXY(TileMode.REPEAT, TileMode.CLAMP);
		
		ImageView imageseparator = (ImageView)findViewById(R.id.separator);
		imageseparator.setBackgroundDrawable(separator);

		pseudoField = (EditText) findViewById(R.id.pseudoField);

		Button buttonOK = (Button) findViewById(R.id.buttonOK);
		buttonOK.setOnClickListener(OKListener);

		mWebViewProfil = (WebView) findViewById(R.id.webViewProfil);
		mWebViewProfil.getSettings().setLoadsImagesAutomatically(true);
		mWebViewProfil.getSettings().setUseWideViewPort(true);

		mWebViewProfil.getSettings().setBuiltInZoomControls(true); // zooming
		// controls
		mWebViewProfil.setInitialScale(5);
		mWebViewProfil.setVerticalScrollBarEnabled(false);
		mWebViewProfil.setHorizontalScrollBarEnabled(false);
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			this.finish();
			return false;
		}
		return false;
	}

	View.OnClickListener OKListener = new View.OnClickListener() {
		public void onClick(View actuelView) {
			// recupere la valeur du champ et on charge l'url
			name = pseudoField.getText();
			name.toString();
			
			mWebViewProfil.setWebChromeClient(new WebChromeClient() {
				public void onProgressChanged(WebView view, int progress) {
					//Normalize our progress along the progress bar's scale
		            int myprogress = (Window.PROGRESS_END - Window.PROGRESS_START) / 100 * progress;
		            setSupportProgress(myprogress);
				}
			});
			
			mWebViewProfil.setWebViewClient(new WebViewClient() {
				public void onReceivedError(WebView view, int errorCode,
						String description, String failingUrl) {
					Toast.makeText(displayProfil.this, "Oh non! " + description,
							Toast.LENGTH_SHORT).show();
				}
			});

			mWebViewProfil.loadUrl("http://www.minefield.fr/profil/" + name);
		}
	};
	
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
