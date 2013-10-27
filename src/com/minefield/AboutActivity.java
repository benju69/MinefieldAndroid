package com.minefield;

import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class AboutActivity extends SherlockActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);

		BitmapDrawable bg = (BitmapDrawable) getResources().getDrawable(R.drawable.bgbar3);
		bg.setTileModeXY(TileMode.REPEAT, TileMode.CLAMP);
		getSupportActionBar().setBackgroundDrawable(bg);
		getSupportActionBar().setLogo(R.drawable.ic_launcher);

		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		getSupportActionBar().setTitle(R.string.AProposTitre);

		Typeface font = Typeface.createFromAsset(getAssets(), "fonts/minecraft.ttf");
		TextView txt = (TextView) findViewById(R.id.textViewAPropos);
		txt.setTypeface(font);

		ImageView bouclier = (ImageView) findViewById(R.id.logobouclier);
		bouclier.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				Toast.makeText(getApplicationContext(), "Dat Bouclier !", Toast.LENGTH_SHORT).show();
			}
		});
	}

	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == android.R.id.home) {
			this.finish();
			return false;
		}
		return false;
	}
}