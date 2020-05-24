package daoc.dsii.testmenu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class PopupActivity extends Activity implements PopupMenu.OnMenuItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button b = (Button) findViewById(R.id.b);
		b.setText("Abrir Pop Up");		
	}
	
	public void buttonClick(View v) {
	    PopupMenu popup = new PopupMenu(this, v);
	    popup.setOnMenuItemClickListener(this);
	    popup.getMenuInflater().inflate(R.menu.activity_main, popup.getMenu());
	    popup.show();
	}
	
	@Override
	public boolean onMenuItemClick(MenuItem item) {
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

	
	
}
