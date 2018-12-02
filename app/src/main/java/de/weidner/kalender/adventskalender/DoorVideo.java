package de.weidner.kalender.adventskalender;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class DoorVideo extends Activity {

	private VideoView videoView;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.door_video);

		videoView = (VideoView)findViewById(R.id.videoView);
		videoView.setKeepScreenOn(true);

		String video = getIntent().getExtras().getString("Video");
		int resID = getIntent().getExtras().getInt("Day");

			InputStream inputStream = null;
			
			try {
				inputStream = getResources().getAssets().open(video);
			}
			catch (IOException e) {
				e.printStackTrace();
			}

			if(inputStream != null)
			{
				File file = createFileFromInputStream(inputStream);

				videoView.setVideoPath(file.getAbsolutePath());
			}

		//MediaController initialisieren und der VideoView zuweisen
		MediaController mediaController = new MediaController(this);
		videoView.setMediaController(mediaController);      

		//FrameLayout fl = new FrameLayout(this);  
		//fl.addView(image);  
		//setContentView(fl);  	    
	}

	private File createFileFromInputStream(InputStream inputStream) {

		try{
			File dir = Environment.getExternalStorageDirectory();
			File f = File.createTempFile("video", "mp4", dir);
			OutputStream outputStream = new FileOutputStream(f);
			byte buffer[] = new byte[1024];
			int length = 0;
			
			while((length=inputStream.read(buffer)) > 0) {
				outputStream.write(buffer,0,length);
			}
			outputStream.close();
			inputStream.close();
			return f;
		}catch (IOException e) {
			//Logging exception
			System.out.println("IOException");
		}

		return null;
	}
}
