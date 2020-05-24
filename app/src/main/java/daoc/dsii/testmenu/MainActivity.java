package daoc.dsii.testmenu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button b = (Button) findViewById(R.id.b);
		b.setText("Ir a ContextMenu");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		Intent intent;
		switch (id) {
		case R.id.brow:
			Uri url = Uri.parse("http://www.example.com");
			intent = new Intent(Intent.ACTION_VIEW, url);
			startActivity(intent);
			return true;
		case R.id.fotos:
			intent = Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_GALLERY);
			startActivity(intent);			
			return true;
		case R.id.music:
			intent = new Intent("android.intent.action.MUSIC_PLAYER");
			startActivity(intent);		
			return true;			
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void buttonClick(View v) {
		Intent intent = new Intent(this, ContextActivity.class);
		startActivity(intent);
	}

}
