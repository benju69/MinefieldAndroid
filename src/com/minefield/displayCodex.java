package com.minefield;

import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class displayCodex extends SherlockActivity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.codex);

		BitmapDrawable bg = (BitmapDrawable) getResources().getDrawable(
				R.drawable.bgbar3);
		bg.setTileModeXY(TileMode.REPEAT, TileMode.CLAMP);
		getSupportActionBar().setBackgroundDrawable(bg);

		getSupportActionBar().setLogo(R.drawable.book);

		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		getSupportActionBar().setTitle(R.string.codex_title);
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
