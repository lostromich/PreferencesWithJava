package com.exploreca.tourfinder;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.exploreca.tourfinder.utils.UIHelper;

public class MainActivity extends Activity {
	
	public static final String LOGTAG="EXPLORECA";
	public static final String USERNAME="username";

	// Share preferences
	private SharedPreferences settings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Populate settings
		settings = getPreferences(MODE_PRIVATE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void setPreference(View v) {
		Log.i(LOGTAG, "Clicked set");

		SharedPreferences.Editor editor = settings.edit();
		// get the value
		String prefValue = UIHelper.getText(this, R.id.editText1);
		// add the value to the preferences
		editor.putString(USERNAME, prefValue);
		editor.commit();
		// Display information
		UIHelper.displayText(this, R.id.textView1, "Username saved in preferences");
	}

	public void refreshDisplay(View v) {
		Log.i(LOGTAG, "Clicked show");
		// Get the user name from preferences
		String user = settings.getString(USERNAME, "Not found");
		// Make it visible
		UIHelper.displayText(this, R.id.textView1, user);

	}
	
}
