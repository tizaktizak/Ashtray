package com.shmazi.ashtray;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Intro extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);
		Thread th = new Thread(){
			public void run(){
				try{
					sleep(3500);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				finally{
					Intent i = new Intent("com.shmazi.ashtray.ASHTRAY");
					startActivity(i);
					overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
				}
			}
		};
		th.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
