package com.shmazi.ashtray;

import com.google.android.gms.ads.AdView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class Ashtray extends Activity {

	AdView adview;
	String str;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ashtray);
		str = (String)getResources().getString(R.string.toast_future);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater mi = getMenuInflater();
		mi.inflate(R.menu.activity_ashtray, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.menu_about:
			Intent i = new Intent("com.shmazi.ashtray.ABOUT");
			startActivity(i);
			break;
		case R.id.menu_exit:
			finish();
			break;
		case R.id.menu_change:
			Toast t = Toast.makeText(this, str,
					Toast.LENGTH_LONG);
			t.show();
		case R.id.menu_send:
			Toast s = Toast.makeText(this, str,
					Toast.LENGTH_LONG);
			s.show();
		}

		return false;
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		if (adview != null) {
			adview.destroy();
		}
		super.onDestroy();
	}
}
