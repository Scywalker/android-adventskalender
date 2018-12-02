
package de.weidner.kalender.adventskalender;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import de.weidner.kalender.adventskalender.R.drawable;

import android.content.Context;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	private int actualDay = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		GetTimeTask getTimeTask = new GetTimeTask();
		getTimeTask.execute();

		//Toast.makeText(this, "If you have problems, check for update or send me a message!", Toast.LENGTH_SHORT).show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public boolean oneClick(View v)
    {
    	click(2);
    	return true;     	
    }
    
    public boolean twoClick(View v)
    {
    	click(3);
    	return true; 	
    }
    
    public boolean threeClick(View v)
    {
    	click(4);
    	return true; 
    }
    
    public boolean fourClick(View v)
    {
    	click(5);
    	return true; 	
    }
    
    public boolean fiveClick(View v)
    {
    	click(6);
    	return true; 
    }
    
    public boolean sixClick(View v)
    {
    	click(7);
    	return true; 
    }
    
    public boolean sevenClick(View v)
    {
    	click(8);
    	return true;  	
    }
    
    public boolean eightClick(View v)
    {
    	click(9);
    	return true; 	
    }
    
    public boolean nineClick(View v)
    {
    	click(10);
    	return true; 
    }
    
    public boolean tenClick(View v)
    {
    	click(11);  
    	return true; 
    }
    
    public boolean elevenClick(View v)
    {
    	click(12);
    	return true; 
    }
    
    public boolean twelveClick(View v)
    {
    	click(13);
    	return true; 
    }
    
    public boolean thirteenClick(View v)
    {
    	click(14);  
    	return true; 
    }
    
    public boolean fourteenClick(View v)
    {
    	click(15);  
    	return true; 
    }
    
    public boolean fifteenClick(View v)
    {
    	click(16);
    	return true; 
    }
    
    public boolean sixteenClick(View v)
    {
    	click(17);
    	return true; 
    }
    
    public boolean seventeenClick(View v)
    {
    	click(18);
    	return true; 
    }
    
    public boolean eighteenClick(View v)
    {
    	click(19);
    	return true; 
    }
    
    public boolean ninteenClick(View v)
    {
    	click(20);
    	return true; 
    }
    
    public boolean twentyClick(View v)
    {
    	click(21); 
    	return true; 
    }
    
    public boolean twentyoneClick(View v)
    {
    	click(22);
    	return true; 
    }
    
    public boolean twentytwoClick(View v)
    {
    	click(23);   
    	return true; 
    }
    
    public boolean twentythreeClick(View v)
    {
    	click(24);   
    	return true; 
    }
    
    public boolean twentyfourClick(View v)
    {
    	click(25);
    	return true; 
    }

	public boolean thirtyOneClick(View v)
	{
		click(32);
		return true;
	}

    private void click(int checkDay)
    {
    	//int day = getDay();
    	if(actualDay == 0)
		{
			System.out.println("Check dein Internet oder warte noch ein paar Sekunden.");
			Toast.makeText(this, "Check dein Internet oder warte noch ein paar Sekunden.", Toast.LENGTH_SHORT).show();
		}
		else if(actualDay >= checkDay-1)
		{
			System.out.println("Actual day: " + actualDay);
			Intent door;
			if(checkDay == 7 || checkDay == 25 || checkDay == 32)
			{
				door = new Intent(MainActivity.this, DoorVideo.class);
			}
			else
			{
				door = new Intent(MainActivity.this, DoorPictures.class);
			}
			//door = new Intent(MainActivity.this, DoorPictures.class);
			if(checkDay == 2)
				door.putExtra("Drawable", drawable._1);
			else if(checkDay == 3)
				door.putExtra("Drawable", drawable._2);
			else if(checkDay == 4)
				//streamVideo("http://www.youtube.com/watch?v=gyZuS3Z212U&feature=youtube_gdata_player");
				door.putExtra("Drawable", drawable._3);
			/*{
				
				Intent view = new Intent(Intent.ACTION_VIEW, Uri.parse("_3"));
				view.setType("image");
				startActivity(view);
			}*/
			else if(checkDay == 5)
            	door.putExtra("Drawable", drawable._4);
			else if(checkDay == 6)
            	door.putExtra("Drawable", drawable._5);
			else if(checkDay == 7)
			{
				//door.putExtra("Drawable", drawable._6);
				door.putExtra("Video", "_6.mp4");
				door.putExtra("Day", 6);
			}
            else if(checkDay == 8)
				door.putExtra("Drawable", drawable._7);
            else if(checkDay == 9)
            	door.putExtra("Drawable", drawable._8);
            else if(checkDay == 10)
        	    door.putExtra("Drawable", drawable._9);
        	else if(checkDay == 11)
				door.putExtra("Drawable", drawable._10);
        	else if(checkDay == 12)
        	    door.putExtra("Drawable", drawable._11);
			else if(checkDay == 13)
				door.putExtra("Drawable", drawable._12);
        	else if(checkDay == 14)
        	    door.putExtra("Drawable", drawable._13);
			else if(checkDay == 15)
				door.putExtra("Drawable", drawable._14);
        	else if(checkDay == 16)
				door.putExtra("Drawable", drawable._15);
			else if(checkDay == 17)
        		door.putExtra("Drawable", drawable._16);
        	else if(checkDay == 18)
        		door.putExtra("Drawable", drawable._17);
			else if(checkDay == 19)
				door.putExtra("Drawable", drawable._18);
        	else if(checkDay == 20)
			{
				door.putExtra("Drawable", drawable._19);
				//door.putExtra("Video", "_19.mp4");
				//door.putExtra("Day", 19);
			}
        	else if(checkDay == 21)
        	    door.putExtra("Drawable", drawable._20);
        	else if(checkDay == 22)
        		door.putExtra("Drawable", drawable._21);
			else if(checkDay == 23)
				door.putExtra("Drawable", drawable._22);
        	else if(checkDay == 24)
        		door.putExtra("Drawable", drawable._23);
        	else if(checkDay == 25)
			{
				//door.putExtra("Drawable", drawable._24);
				door.putExtra("Video", "_24.mp4");
				door.putExtra("Day", 24);
			}
			else if(checkDay == 32)
			{
				door.putExtra("Video", "_31.mp4");
				door.putExtra("Day", 31);
			}
        	else
            	Toast.makeText(this, "System error. Maybe you have to update your App!", Toast.LENGTH_LONG).show();
			
	    	startActivity(door);    		
		}
		else
		{
			Toast.makeText(this, "No way! Nicht schummeln!!", Toast.LENGTH_SHORT).show();
		}
    }

	public class GetTimeTask extends AsyncTask<Void, Void, Boolean> {

		private int day;
		protected Boolean doInBackground(Void... params) {
			while(day == 0)
			{
				HttpGet httpget = new HttpGet("http://api.timezonedb.com/v2/get-time-zone?key=PSLC2M2SZH0V&format=xml&by=zone&zone=Europe/Berlin");
				org.apache.http.client.HttpClient httpclient = new DefaultHttpClient();
				HttpResponse httpResponse = null;
				try {
					httpResponse = httpclient.execute(httpget);
				} catch (IOException e) {
					e.printStackTrace();
				}

				System.out.println(httpResponse.toString());
				HttpEntity resEntity = httpResponse.getEntity();

				// Get the HTTP Status Code
				int statusCode = httpResponse.getStatusLine().getStatusCode();
				if (statusCode == 0) {
					System.out.println("Something went wrong.");
				}

				// Get the contents of the response
				InputStream in = null;
				try {
					in = resEntity.getContent();
				} catch (IOException e) {
					e.printStackTrace();
				}

				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				String line = "";

				try {
					line = reader.readLine();
					while (line != null) {
						if(line.contains("formatted>")) {
							System.out.println(line);
							int start = line.indexOf("formatted>");
							line = line.substring(start + 10);
							break;
						}
						else
							line = reader.readLine();
					}
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				System.out.println(line);   //Prints the string content read from input stream

				try {
					if (Integer.parseInt(line.substring(8, 10)) > 0) {
						day = Integer.parseInt(line.substring(8, 10));
						return true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return false;
		}

		protected void onPostExecute(final Boolean success) {
			actualDay = day;
			Toast.makeText(getApplicationContext(), "I am ready now. Ich weiß welcher Tag heute ist.", Toast.LENGTH_LONG).show();
		}

		protected void onCancelled() {
		}
	}

    private void streamVideo(String url)
    {
    	MediaPlayer mediaPlayer = new MediaPlayer();
    	mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    	try {
			mediaPlayer.setDataSource(url);
			mediaPlayer.prepare();	// might take long! (for buffering, etc)
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	mediaPlayer.start();	
    	// has to stand at another place
    	mediaPlayer.release();
    	mediaPlayer = null;
    }

	private String getTime()
	{

		try
		{
			//Make the Http connection so we can retrieve the time
			HttpClient httpclient = new DefaultHttpClient();
			// I am using yahoos api to get the time
			HttpResponse response = httpclient.execute(new
					HttpGet("http://api.timezonedb.com/v2/get-time-zone?key=PSLC2M2SZH0V&format=xml&by=zone&zone=Europe/Berlin"));
			//HttpGet("http://api.timezonedb.com/v2/get-time-zone?key=PSLC2M2SZH0V&format=xml&by=zone&zone=Europe/Berlin"));
			StatusLine statusLine = response.getStatusLine();
			if(statusLine.getStatusCode() == HttpStatus.SC_OK)
			{
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				response.getEntity().writeTo(out);
				out.close();
				// The response is an xml file and i have stored it in a string
				String responseString = out.toString();
				Log.d("Response", responseString);
				//We have to parse the xml file using any parser, but since i have to
				//take just one value i have deviced a shortcut to retrieve it
				int x = responseString.indexOf("<Timestamp>");
				int y = responseString.indexOf("</Timestamp>");
				//I am using the x + "<Timestamp>" because x alone gives only the start value
				Log.d("Response", responseString.substring(x + "<Timestamp>".length(),y) );
				String timestamp =  responseString.substring(x + "<Timestamp>".length(),y);
				// The time returned is in UNIX format so i need to multiply it by 1000 to use it
				Date d = new Date(Long.parseLong(timestamp) * 1000);
				Log.d("Response", d.toString() );
				return d.toString() ;
			}
			else
			{
				//Closes the connection.
				response.getEntity().getContent().close();
				throw new IOException(statusLine.getReasonPhrase());
			}
		}
		catch (ClientProtocolException e)
		{
			Log.d("Response", e.getMessage());
		}
		catch (IOException e)
		{
			Log.d("Response", e.getMessage());
		}
		return null;
	}
}
