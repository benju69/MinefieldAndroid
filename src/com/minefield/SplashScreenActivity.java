package com.minefield;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class SplashScreenActivity extends Activity {

	/**
	 * The thread to process splash screen events
	 */
	private Thread mSplashThread;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Splash screen view
		setContentView(R.layout.splash);

		final SplashScreenActivity splash = this;

		// The thread to wait for splash screen events
		mSplashThread = new Thread() {
			@Override
			public void run() {
				try {
					synchronized (this) {
						// Temps d'attente
						wait(500);
					}
				} catch (InterruptedException ex) {
				}

				// Run next activity
				Intent intent = new Intent();
				intent.setClass(splash, MinefieldActivity.class);
				startActivity(intent);

				finish();
			}
		};

		mSplashThread.start();
	}

	/**
	 * Processes splash screen touch events
	 */
	@Override
	public boolean onTouchEvent(MotionEvent evt) {
		if (evt.getAction() == MotionEvent.ACTION_DOWN) {
			synchronized (mSplashThread) {
				mSplashThread.notifyAll();
			}
		}
		return true;
	}
}