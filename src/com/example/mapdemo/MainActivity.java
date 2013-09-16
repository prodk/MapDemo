package com.example.mapdemo;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(getClass().getSimpleName(), "onCreate()");
        setContentView(R.layout.activity_main);
        
        final EditText lattitude = (EditText) findViewById(R.id.editText1);
        final EditText longitude = (EditText) findViewById(R.id.editText2);
        
        final Button button = (Button) findViewById(R.id.mapButton);
        
        button.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v){
        		String lat = lattitude.getText().toString();
    			String lon = longitude.getText().toString();
        		try {        			
        			Intent geoIntent = new Intent(android.content. Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + "(" + lat + "," + " " + lon + ")"));
        			startActivity(geoIntent);
        		}
        		catch (Exception e){
        			Log.d(getClass().getSimpleName(), "geo: URI failed!");
        			Intent intent = new Intent(android.content.Intent.ACTION_VIEW, 
        				    Uri.parse("http://maps.google.com/maps?saddr="+lat+","+lon+")" ));
        			startActivity(intent);
        		}
        	}
        });
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(getClass().getSimpleName(), "onStart()");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
