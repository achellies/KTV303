package com.ktv303.numeric;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import model.UserFunctions;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class HighscoreActivity extends Activity
{
	private ImageButton imageButtonGoBack;
	//  userFunctions
	private UserFunctions userFunctions;
	private ProgressDialog progressDialog;
	private Typeface romansTypeFace;
	private String errorMessage;
	private String username;
	private String score;
	private int position;
	private List<String> romansPositions;
	private boolean wait;
	private TableLayout tableLayoutHighscores;
	private static String KEY_SUCCESS = "success";
	private static String KEY_ERROR_MSG = "error_msg";
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		setContentView( R.layout.activity_highscore);
		
		this.userFunctions = new UserFunctions();
		
		//Set imageButtonGoBack
		imageButtonGoBack = (ImageButton) findViewById( R.id.imageButtonGoBack );
		this.romansTypeFace = Typeface.createFromAsset( getAssets(), "fonts/font.ttf" );
		tableLayoutHighscores = (TableLayout) findViewById( R.id.tableLayoutHighscores);
		this.romansPositions = new ArrayList<String>();
		this.romansPositions.add("I");
		this.romansPositions.add("II");
		this.romansPositions.add("III");
		this.romansPositions.add("IV");
		this.romansPositions.add("V");
		this.romansPositions.add("VI");
		this.romansPositions.add("VII");
		this.romansPositions.add("VIII");
		this.romansPositions.add("IX");
		this.romansPositions.add("X");
		this.score = "";
		this.username = "";
		
		addListenerOnButton();
		
		fillHighscoreBoard();
	}
	
	public void addListenerOnButton()
	{
		// add click listener to back button
		imageButtonGoBack.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				Intent i = new Intent( getApplicationContext(), MainActivity.class );
				startActivity(i);
				finish();
			}
		});
	}
	
	private void fillHighscoreBoard()
	{
		errorMessage = "";
		progressDialog = ProgressDialog.show( HighscoreActivity.this, "", "Ophalen gegevens...", true );
        new Thread(new Runnable() {
        	public void run() {
        		JSONObject json = userFunctions.getHighscoreBoard();
        		
        		try {
        			if( json.getString(KEY_SUCCESS) != null )
        			{
        				String res = json.getString(KEY_SUCCESS); 
        				if( Integer.parseInt(res) == 1 )
        				{
        					JSONObject highscore = new JSONObject( json.getJSONObject("highscore").toString() );
        					
        					for( int i = 0; i < highscore.length(); i++ )
        					{
        						wait = true;
        						username = highscore.names().get(i).toString();
        						score = highscore.get( highscore.names().get(i).toString() ).toString();
        						position = i;
        						runOnUiThread(new Runnable() {
        						    public void run() {
        						    	TableRow row = new TableRow( getApplicationContext() );
        						    	TextView position = new TextView( getApplicationContext() );
        						    	TextView username = new TextView(getApplicationContext());
        						    	TextView score = new TextView(getApplicationContext());
        						    	position.setText( HighscoreActivity.this.romansPositions.get( HighscoreActivity.this.position ) );
        						    	username.setText( HighscoreActivity.this.username );
        						    	score.setText( HighscoreActivity.this.score );
        						    	position.setTextColor( getResources().getColor( R.color.Grey ) );
        						    	username.setTextColor( getResources().getColor( R.color.White ) );
        						    	score.setTextColor( getResources().getColor( R.color.White ) );
        						    	position.setTextSize( 30 );
        						    	username.setTextSize( 30 );
        						    	score.setTextSize( 30 );
        						    	position.setTypeface( HighscoreActivity.this.romansTypeFace );
        						    	username.setTypeface( HighscoreActivity.this.romansTypeFace );
        						    	position.setGravity( android.view.Gravity.RIGHT );
        						    	position.setPadding(0, 0, 10, 0);
        						    	score.setGravity( android.view.Gravity.RIGHT );
        						    	row.addView( position );
        						    	row.addView( username );
        						    	row.addView( score );
        						    	HighscoreActivity.this.tableLayoutHighscores.addView(row);
        						    	wait = false;
        						    }
        						});
        						while( wait )
        						{}
        					}
        					
        					progressDialog.dismiss();
        				}else{
        					// Error in login
        					errorMessage = json.getString( KEY_ERROR_MSG );
        					showAlert();
        				}
        			}
        		} catch( JSONException e ) {
        			progressDialog.dismiss();
                   	Log.v( "Exception", e.getMessage() );
        		}
        	}
        }).start();
	}
	
	private void showAlert(){
        HighscoreActivity.this.runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(HighscoreActivity.this);
                builder.setTitle("Oeps!");
                builder.setMessage(errorMessage)
                       .setCancelable(false)
                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface dialog, int id) {
                           }
                       });                     
                AlertDialog alert = builder.create();
                alert.show();
                progressDialog.dismiss();
            }
        });
    }
}
