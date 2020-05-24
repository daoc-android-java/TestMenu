package daoc.dsii.testmenu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ContextActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button b = (Button) findViewById(R.id.b);
		b.setText("Ir a PopupMenu");
		
		ImageView iv = (ImageView) findViewById(R.id.iv);
		registerForContextMenu(iv);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
	    super.onCreateContextMenu(menu, v, menuInfo);
	    
	    getMenuInflater().inflate(R.menu.activity_main, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		int id = item.getItemId();
		Intent intent;
		switch (id) {
		case R.id.brow:
			Uri url = Uri.parse("http://www.example.com");
			intent = new Intent(Intent.ACTION_VIEW, url);
			startActivity(intent);
			return true;
		case R.id.fotos:
			intent = Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_EMAIL);
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
		Intent intent = new Intent(this, PopupActivity.class);
		startActivity(intent);
	}
	
}
