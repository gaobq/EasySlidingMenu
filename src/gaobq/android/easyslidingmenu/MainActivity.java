package gaobq.android.easyslidingmenu;


import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		this.addPreferencesFromResource(R.xml.main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen,
			Preference preference) {
		Class<?> cls = null;
		String title = preference.getTitle().toString();
		if(title.equals(getString(R.string.change_data))){
			cls = SlidingTestActivity.class ;
		}
		if(cls != null){
			Intent intent = new Intent(this, cls);
			startActivity(intent);
			return true ;
		}else{
			return false ;
		}
		
	}
	
	

}
