package com.minefield;

import android.content.Context;
import android.content.Intent;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class MinefieldActivity extends SherlockActivity {
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		BitmapDrawable bg = (BitmapDrawable) getResources().getDrawable(
				R.drawable.bgbar3);
		bg.setTileModeXY(TileMode.REPEAT, TileMode.CLAMP);
		getSupportActionBar().setBackgroundDrawable(bg);
		getSupportActionBar().setLogo(R.drawable.ic_launcher);
		
		BitmapDrawable bgstone = (BitmapDrawable) getResources().getDrawable(
				R.drawable.footer);
		bgstone.setTileModeXY(TileMode.REPEAT, TileMode.CLAMP);
		RelativeLayout bottom = (RelativeLayout) findViewById(R.id.bottombar);
		bottom.setBackgroundDrawable(bgstone);
		 
		Typeface font = Typeface.createFromAsset(getAssets(),
				"fonts/minecraft.ttf");

		Button boutonNews = (Button) findViewById(R.id.buttonNews);
		boutonNews.setTypeface(font);
		boutonNews.setOnClickListener(buttonNews);

		Button boutonCodex = (Button) findViewById(R.id.buttonCodex);
		boutonCodex.setTypeface(font);
		boutonCodex.setOnClickListener(buttonCodex);

		Button boutonForum = (Button) findViewById(R.id.buttonForum);
		boutonForum.setTypeface(font);
		boutonForum.setOnClickListener(buttonForum);

		Button boutonM = (Button) findViewById(R.id.buttonCartes);
		boutonM.setTypeface(font);
		boutonM.setOnClickListener(buttonCartes);

		Button boutonFaq = (Button) findViewById(R.id.buttonFAQ);
		boutonFaq.setTypeface(font);
		boutonFaq.setOnClickListener(buttonFaq);

		Button boutonBourse = (Button) findViewById(R.id.buttonBourse);
		boutonBourse.setTypeface(font);
		boutonBourse.setOnClickListener(buttonBourse);

		Button boutonProfil = (Button) findViewById(R.id.buttonProfil);
		boutonProfil.setTypeface(font);
		boutonProfil.setOnClickListener(buttonProfil);

		Button boutonLiens = (Button) findViewById(R.id.buttonLiens);
		boutonLiens.setTypeface(font);
		boutonLiens.setOnClickListener(buttonLiens);

		ImageView fb = (ImageView) findViewById(R.id.facebookicon);
		fb.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				String url = "http://m.facebook.com/minefield.fr";
				Intent i = new Intent(Intent.ACTION_VIEW);
				Uri u = Uri.parse(url);
				i.setData(u);
				startActivity(i);
			}
		});

		ImageView twitter = (ImageView) findViewById(R.id.twittericon);
		twitter.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				// String url = "http://twitter.com/#!/minefield_fr";
				String url = "https://mobile.twitter.com/#!/minefield_fr";
				Intent i = new Intent(Intent.ACTION_VIEW);
				Uri u = Uri.parse(url);
				i.setData(u);
				startActivity(i);
			}
		});
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 0, 0, R.string.share).setIcon(R.drawable.ic_action_share)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		menu.add(0, 1, 0, R.string.about).setIcon(R.drawable.ic_about);
		menu.add(0, 2, 0, R.string.quit).setIcon(R.drawable.ic_quit);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 0:
			Partager();
			return true;
		case 1:
			Apropos();
			return true;
		case 2:
			Quitter();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void Partager() {
		Intent shareIntent = new Intent(Intent.ACTION_SEND);
		shareIntent.setType("text/plain");
		shareIntent	.putExtra(Intent.EXTRA_TEXT, "Découvrez Minefield sur Android ! -- https://market.android.com/details?id=com.minefield");
		startActivity(Intent.createChooser(shareIntent, "Partager l'app via"));
	}

	private void Apropos() {		
		Intent intent = new Intent(MinefieldActivity.this, AboutActivity.class);
		startActivity(intent);
	}

	private void Quitter() {
		this.finish();
	}

	public boolean isConnected() {
		ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isConnected()) {
			return true;
		}
		return false;
	}

	View.OnClickListener buttonNews = new View.OnClickListener() {
		public void onClick(View actuelView) {
			if (isConnected() == true)// vérifie la connexion
			{
				Intent intent = new Intent(MinefieldActivity.this, displayNews.class);
				startActivity(intent);
				// overridePendingTransition(R.anim.fade, R.anim.hold);
			} else {
				Context context = getApplicationContext();
				CharSequence text = "Veuillez vérifier votre connexion à Internet";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
			}
		}
	};

	View.OnClickListener buttonForum = new View.OnClickListener() {
		public void onClick(View actuelView) {
			if (isConnected() == true)// vérifie la connexion
			{
				Intent intent = new Intent(MinefieldActivity.this, displayForum.class);
				startActivity(intent);
				// overridePendingTransition(R.anim.fade, R.anim.hold);
			} else {
				Context context = getApplicationContext();
				CharSequence text = "Veuillez vérifier votre connexion à Internet";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
			}
		}
	};

	View.OnClickListener buttonCodex = new View.OnClickListener() {
		public void onClick(View actuelView) {
			Intent intent = new Intent(MinefieldActivity.this, displayCodex.class);
			startActivity(intent);
			// overridePendingTransition(R.anim.fade, R.anim.hold);
		}
	};

	View.OnClickListener buttonCartes = new View.OnClickListener() {
		public void onClick(View actuelView) {
			Intent intent = new Intent(MinefieldActivity.this, TabCarte.class);// displayCarteNewStendel.class);
			startActivity(intent);
			// overridePendingTransition(R.anim.fade, R.anim.hold);
		}
	};

	View.OnClickListener buttonFaq = new View.OnClickListener() {
		public void onClick(View actuelView) {
			Intent intent = new Intent(MinefieldActivity.this, displayFaq.class);
			startActivity(intent);
			// overridePendingTransition(R.anim.fade, R.anim.hold);
		}
	};

	View.OnClickListener buttonBourse = new View.OnClickListener() {
		public void onClick(View actuelView) {
			if (isConnected() == true)// vérifie la connexion
			{
				Intent intent = new Intent(MinefieldActivity.this, displayBourse.class);
				startActivity(intent);
				// overridePendingTransition(R.anim.fade, R.anim.hold);
			} else {
				Context context = getApplicationContext();
				CharSequence text = "Veuillez vérifier votre connexion à Internet";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
			}
		}
	};

	View.OnClickListener buttonLiens = new View.OnClickListener() {
		public void onClick(View actuelView) {
			Intent intent = new Intent(MinefieldActivity.this, displayLiens.class);
			startActivity(intent);
			// overridePendingTransition(R.anim.fade, R.anim.hold);
		}
	};

	View.OnClickListener buttonProfil = new View.OnClickListener() {
		public void onClick(View actuelView) {
			if (isConnected() == true)// vérifie la connexion
			{
				Intent intent = new Intent(MinefieldActivity.this, displayProfil.class);
				startActivity(intent);
			} else {
				Context context = getApplicationContext();
				CharSequence text = "Veuillez vérifier votre connexion à Internet";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
			}
		}
	};
}