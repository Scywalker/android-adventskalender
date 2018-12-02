package de.weidner.kalender.adventskalender;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class DoorPictures extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.door_pictures);
		
		int resID = getIntent().getExtras().getInt("Drawable");
		
		ImageView image = new ImageView(this);
		image.setImageResource(resID);
	    FrameLayout fl = new FrameLayout(this);  
	    fl.addView(image);  
	    setContentView(fl);  	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.door_pictures, menu);
		
		return true;
	}

}
