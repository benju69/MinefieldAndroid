package com.minefield;

import java.util.ArrayList;

import android.app.ProgressDialog;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class displayNews extends SherlockActivity {

	static ListView ListNews;
	ArrayList<Feed> feeds;
	static ListFeedAdapter lfa;
	private static Handler handler;
	private static ProgressDialog dialog;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news);
		
		BitmapDrawable bg = (BitmapDrawable) getResources().getDrawable(R.drawable.bgbar3);
		bg.setTileModeXY(TileMode.REPEAT, TileMode.CLAMP);
		getSupportActionBar().setBackgroundDrawable(bg);
		getSupportActionBar().setLogo(R.drawable.sign);

		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		getSupportActionBar().setTitle(R.string.news_title);
		
		handler = new Handler();
		
		//content		
		ListNews = (ListView) findViewById(R.id.listFeed);		
		dialog = ProgressDialog.show(this, null, "Chargement...", true);
		
		new Thread((new Runnable() {
			@Override
			public void run() {			
				feeds = ContainerData.getFeeds();	
				for (Feed feed : feeds) {
					Log.e("feedPlayer", feed.toString());
				}
				lfa = new ListFeedAdapter(getApplicationContext(), feeds);
				
				//TODO quand fin			
				handler.post(new Runnable() {
					@Override
					public void run() {
						ListNews.setAdapter(lfa);
						dialog.dismiss();						
					}					
				});
			}
		})).start();
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
