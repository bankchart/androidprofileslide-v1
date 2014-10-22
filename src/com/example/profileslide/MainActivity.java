package com.example.profileslide;

import com.example.profileslide.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	public boolean isClicked = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button profileBtn = (Button) findViewById(R.id.profile_btn);
		Button hobbyBtn = (Button) findViewById(R.id.hobby_btn);
		Button contactBtn = (Button) findViewById(R.id.contact_btn);
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		/*
		 * FragmentTransaction ft = getFragmentManager().
		 * beginTransaction().setCustomAnimations( R.animator.slidein,
		 * R.animator.slideout);
		 */
		FragmentManager fm = getFragmentManager();
		Fragment profileFm = fm.findFragmentById(R.id.profile_fm);
		Fragment hobbyFm = fm.findFragmentById(R.id.hobby_fm);
		Fragment contactFm = fm.findFragmentById(R.id.contact_fm);
		ft.hide(profileFm);
		ft.hide(hobbyFm);
		ft.hide(contactFm);
		ft.commit();

		getPreferences(MODE_PRIVATE).edit().putInt("already", 1).commit();
		profileBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int prefer = getPreferences(MODE_PRIVATE).getInt("already", 1);
				TextView check = (TextView) findViewById(R.id.checking);

				if (prefer == 1) {
					check.setText(prefer + "-p");
					getPreferences(MODE_PRIVATE).edit().putInt("already", 0)
							.commit();
					FragmentTransaction ft = getFragmentManager()
							.beginTransaction().setCustomAnimations(
									R.animator.down2up_slide,
									R.animator.up2down_slide);
					FragmentManager fm = getFragmentManager();
					final Fragment profileFm = fm
							.findFragmentById(R.id.profile_fm);
					ft.show(profileFm);
					ft.commit();
				} else {
					check.setText(prefer + "-p");
					getPreferences(MODE_PRIVATE).edit().putInt("already", 1)
							.commit();
					FragmentTransaction ft = getFragmentManager()
							.beginTransaction().setCustomAnimations(
									R.animator.down2up_slide,
									R.animator.up2down_slide);
					FragmentManager fm = getFragmentManager();
					final Fragment profileFm = fm
							.findFragmentById(R.id.profile_fm);
					ft.hide(profileFm);
					ft.commit();
				}
			}
		});

		hobbyBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int prefer = getPreferences(MODE_PRIVATE).getInt("already", 1);
				TextView check = (TextView) findViewById(R.id.checking);

				if (prefer == 1) {
					check.setText(prefer + "-h");
					getPreferences(MODE_PRIVATE).edit().putInt("already", 0)
							.commit();
					FragmentTransaction ft = getFragmentManager()
							.beginTransaction().setCustomAnimations(
									R.animator.right2left_slide,
									R.animator.left2right_slide);
					FragmentManager fm = getFragmentManager();
					final Fragment hobbyFm = fm.findFragmentById(R.id.hobby_fm);
					ft.show(hobbyFm);
					ft.commit();
				} else {
					check.setText(prefer + "-h");
					getPreferences(MODE_PRIVATE).edit().putInt("already", 1)
							.commit();
					FragmentTransaction ft = getFragmentManager()
							.beginTransaction().setCustomAnimations(
									R.animator.right2left_slide,
									R.animator.left2right_slide);
					FragmentManager fm = getFragmentManager();
					final Fragment hobbyFm = fm.findFragmentById(R.id.hobby_fm);
					ft.hide(hobbyFm);
					ft.commit();
				}
			}

		});

		contactBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int prefer = getPreferences(MODE_PRIVATE).getInt("already", 1);
				TextView check = (TextView) findViewById(R.id.checking);

				if (prefer == 1) {
					check.setText(prefer + "-c");
					getPreferences(MODE_PRIVATE).edit().putInt("already", 0)
							.commit();
					FragmentTransaction ft = getFragmentManager()
							.beginTransaction().setCustomAnimations(
									R.animator.bottom2top,
									R.animator.top2bottom);
					FragmentManager fm = getFragmentManager();
					final Fragment contactFm = fm
							.findFragmentById(R.id.contact_fm);
					ft.show(contactFm);
					ft.commit();
				} else {
					check.setText(prefer + "-c");
					getPreferences(MODE_PRIVATE).edit().putInt("already", 1)
							.commit();
					FragmentTransaction ft = getFragmentManager()
							.beginTransaction().setCustomAnimations(
									R.animator.bottom2top,
									R.animator.top2bottom);
					FragmentManager fm = getFragmentManager();
					final Fragment contactFm = fm
							.findFragmentById(R.id.contact_fm);
					ft.hide(contactFm);
					ft.commit();
				}
			}

		});

		final LinearLayout checkToHideProfile = (LinearLayout) findViewById(R.id.checkToHideProfile);
		checkToHideProfile.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				FragmentTransaction ft = getFragmentManager()
						.beginTransaction().setCustomAnimations(
								R.animator.down2up_slide,
								R.animator.up2down_slide);
				FragmentManager fm = getFragmentManager();
				final Fragment profileFm = fm.findFragmentById(R.id.profile_fm);
				ft.hide(profileFm);
				ft.commit();
				getPreferences(MODE_PRIVATE).edit().putInt("already", 1)
						.commit();
			}
		});
		
		final LinearLayout profileLinear = (LinearLayout) findViewById(R.id.profile_linear);
		profileLinear.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
			}
		});
		
		final LinearLayout checkToHideHobby = (LinearLayout) findViewById(R.id.checkToHideHobby);
		checkToHideHobby.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				FragmentTransaction ft = getFragmentManager()
						.beginTransaction().setCustomAnimations(
								R.animator.right2left_slide,
								R.animator.left2right_slide);
				FragmentManager fm = getFragmentManager();
				final Fragment hobbyFm = fm.findFragmentById(R.id.hobby_fm);
				ft.hide(hobbyFm);
				ft.commit();
				getPreferences(MODE_PRIVATE).edit().putInt("already", 1).commit();
			}
		});
		
		final LinearLayout hobbyLinear = (LinearLayout) findViewById(R.id.hobby_linear);
		hobbyLinear.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
			}
		});
		
		final LinearLayout checkToHideContact = (LinearLayout) findViewById(R.id.checkToHideContact);
		checkToHideContact.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				FragmentTransaction ft = getFragmentManager()
						.beginTransaction().setCustomAnimations(
								R.animator.bottom2top,
								R.animator.top2bottom);
				FragmentManager fm = getFragmentManager();
				final Fragment contactFm = fm.findFragmentById(R.id.contact_fm);
				ft.hide(contactFm);
				ft.commit();
				getPreferences(MODE_PRIVATE).edit().putInt("already", 1).commit();
			}
		});
		
		final LinearLayout contactLinear = (LinearLayout) findViewById(R.id.contact_linear);
		contactLinear.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
