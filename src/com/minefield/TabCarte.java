package com.minefield;

import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.Window;

public class TabCarte extends SherlockActivity implements ActionBar.TabListener {
    private WebView mViewCarte;
    
	public void onCreate(Bundle savedInstanceState) {	
		requestWindowFeature(Window.FEATURE_PROGRESS);
		
		super.onCreate(savedInstanceState);
        setContentView(R.layout.carte);
        
        BitmapDrawable bg = (BitmapDrawable) getResources().getDrawable(
				R.drawable.bgbar3);
        bg.setTileModeXY(TileMode.REPEAT, TileMode.CLAMP);
		getSupportActionBar().setBackgroundDrawable(bg);
		getSupportActionBar().setLogo(R.drawable.map);

		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		getSupportActionBar().setTitle(R.string.carte_title);
		
		mViewCarte = (WebView)findViewById(R.id.map);
		
		try {
			mViewCarte.getSettings().setLoadsImagesAutomatically(true);
			mViewCarte.getSettings().setUseWideViewPort(true);

			mViewCarte.getSettings().setBuiltInZoomControls(true); // zooming
																// controls
			mViewCarte.setInitialScale(5);
			mViewCarte.setVerticalScrollBarEnabled(false);
			mViewCarte.setHorizontalScrollBarEnabled(false);
		} catch (Exception e) {
			e.printStackTrace();
		}

        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for (int i = 1; i <= 4; i++) {
            ActionBar.Tab tab = getSupportActionBar().newTab();
            if(i==1) tab.setText("Stendel");
            if(i==2) tab.setText("New Stendel");
            if(i==3) tab.setText("Crash");
            if(i==4) tab.setText("Capitale Stendel");
            tab.setTabListener(this);
            getSupportActionBar().addTab(tab);
        }
    }

	@Override
    public void onTabReselected(Tab tab, FragmentTransaction transaction) {
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction transaction) {
        //mSelected.setText("Selected: " + tab.getText());
    	mViewCarte.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress) {	
				//Normalize our progress along the progress bar's scale
	            int myprogress = (Window.PROGRESS_END - Window.PROGRESS_START) / 100 * progress;
	            setSupportProgress(myprogress);
			}
		});
		
    	mViewCarte.setWebViewClient(new WebViewClient() {
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				Toast.makeText(TabCarte.this, "Oh non! " + description,
						Toast.LENGTH_SHORT).show();
			}
		});
    	
    	switch(tab.getPosition())
    	{
    	case 0:
    		mViewCarte.stopLoading();
    		mViewCarte.loadUrl("file:///android_asset/maps/mapStendel/Stendel.html");
    		break;
    	case 1: 
    		mViewCarte.stopLoading();
    		mViewCarte.loadUrl("file:///android_asset/maps/mapNewStendel/map.html");
    		break;
    	case 2:
    		mViewCarte.stopLoading();
    		mViewCarte.loadUrl("file:///android_asset/maps/mapCrash/crash.html");
    		break;
    	case 3:
    		mViewCarte.stopLoading();
    		mViewCarte.loadUrl("file:///android_asset/maps/mapCapitaleStendel/capitalStendel.html");
    		break;
    		
    	}
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction transaction) {
    }

	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == android.R.id.home) {
			this.finish();
			return false;
		}
		return false;
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
