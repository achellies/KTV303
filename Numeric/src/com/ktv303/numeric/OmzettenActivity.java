package com.ktv303.numeric;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Combination;
import model.Gate;
import model.UserFunctions;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class OmzettenActivity extends Activity
{
	//  ImageButton imageButtonGoBack
	private ImageButton imageButtonGoBack;
	//  ImageButton imageButtonNext
	private ImageButton imageButtonNextGame;
	//  ImageButton imageButtonHints
	private Button buttonHints;
	//  List Number numbers
	private List<Gate> gates;
	//  int gateID
	private int gateID;
	//  int highscore
	private int highScore;
	//  int gameCount
	private int gameCount;
	//  int[] combiAlreadyAnswered
	private ArrayList<Integer> combiAlreadyAnswered;
	//  Typeface romansTypeFace
	private Typeface romansTypeFace;
	//  List allCombinations
	private List<Combination> allCombinations;
	//  RelativeLayout gateLayout
	private RelativeLayout gateLayout;
	//  OmzettenActivity activity
	private OmzettenActivity activity;
	//  UserFunctions userFunctions;
	private UserFunctions userFunctions;
	//  TextView textViewHighScore
	private TextView textViewHighScore;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        setContentView( R.layout.activity_omzetten );
        
        this.activity = this;
        this.userFunctions = new UserFunctions();
        
        //  set ImageButtonGoBack
        this.imageButtonGoBack = (ImageButton) findViewById( R.id.imageButtonGoBack );
        //  set ImageButtonNextGame
        this.imageButtonNextGame = (ImageButton) findViewById( R.id.imageButtonNextGame );
        //  set textViewHighScore
        this.textViewHighScore = (TextView) findViewById( R.id.textViewHighScoreOmzetten );
        //  set ImageButtonHints
        this.buttonHints = (Button) findViewById( R.id.buttonHints ); 
        
        //  get Extra's
        Bundle bundle = getIntent().getExtras();
        this.gameCount = bundle.getInt( "gameCount" ) + 1;
        this.combiAlreadyAnswered = bundle.getIntegerArrayList( "combiAlreadyAnswered" );
        
        if( this.userFunctions.isUserLoggedIn( getApplicationContext() ) )
        {
        	this.highScore = this.userFunctions.getUserHighScore( getApplicationContext() );
        	this.textViewHighScore.setText( "Highscore: " + String.valueOf( this.highScore ) );
        }
        
        //  set gateID and gates array
        this.gateID = 0;
        this.gates = new ArrayList<Gate>();
        
        //  GateLayout
        this.gateLayout = (RelativeLayout) findViewById( R.id.gateLayout );
        
        //  set font
        this.romansTypeFace = Typeface.createFromAsset( getAssets(), "fonts/font.ttf" );
        
        //  set combinations for exercises        
        this.allCombinations = new ArrayList<Combination>();
        this.allCombinations.add( new Combination( "I", "V", "X", "L", "Tien", "X" ) );
        this.allCombinations.add( new Combination( "IV", "XV", "LXX", "XC", "Vier", "IV" ) );
        this.allCombinations.add( new Combination( "III", "V", "XIV", "L", "Vijftig", "L" ) );
        this.allCombinations.add( new Combination( "I", "II", "IV", "VI", "Twee", "II" ) );
        this.allCombinations.add( new Combination( "L", "LX", "LXX", "C", "Honderd", "C" ) );
        //this.allCombinations.add( new Combination( "", "", "", "" ) );
        
        //  generate new random number
        Random random = new Random();
	    int r = random.nextInt( this.allCombinations.size() );
	    int i = 0;
	    
        while( this.combiAlreadyAnswered.contains( r ) && i < 20 )
        {
        	r = random.nextInt( this.allCombinations.size() );
        	i++;
        }
        if( i >= 20 )
        {
        	finish();
        }
        this.combiAlreadyAnswered.add( r );
        
        //  add four new gates
        this.gates.add( new Gate( 1, this, this.romansTypeFace, new Point( 61, 175 ), this.allCombinations.get( r ).getOption( 5 ), activity ) );
        this.gates.add( new Gate( 2, this, this.romansTypeFace, new Point( 255, 176 ), this.allCombinations.get( r ).getOption( 5 ), activity ) );
        this.gates.add( new Gate( 3, this, this.romansTypeFace, new Point( 446, 175 ), this.allCombinations.get( r ).getOption( 5 ), activity ) );
        this.gates.add( new Gate( 4, this, this.romansTypeFace, new Point( 641, 175 ), this.allCombinations.get( r ).getOption( 5 ), activity ) );
        
        // create a question
        TextView txtViewQuestion = new TextView( this );
        txtViewQuestion.setText( this.allCombinations.get( r ).getOption( 4 ) + " = " );
        txtViewQuestion.setTypeface( this.romansTypeFace );
        txtViewQuestion.setTextSize( 60 );
        txtViewQuestion.setPadding( 60, 40, 0, 0 );
        txtViewQuestion.setTextColor( getResources().getColor( R.color.Black ) );
        
	    //  set new texts based on random number and combination
        this.gates.get( 0 ).setText( allCombinations.get( r ).getOption( 0 ) );
        this.gates.get( 1 ).setText( allCombinations.get( r ).getOption( 1 ) );
        this.gates.get( 2 ).setText( allCombinations.get( r ).getOption( 2 ) );
        this.gates.get( 3 ).setText( allCombinations.get( r ).getOption( 3 ) );
        
        // put the newly create gates in the right view
        this.gateLayout.addView( txtViewQuestion );
        
        for( Gate gate : this.gates )
        {
        	this.gateLayout.addView( gate, gate.getRLP() );
        	this.gateLayout.addView( gate.getTxtView(), gate.getTxtRLP() );
        }
        
        addListenerOnButton();
    }
    // add listeners to buttons
    public void addListenerOnButton()
    { 
    	// add click listener to back button
		imageButtonGoBack.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent( getApplicationContext(), MainActivity.class );
				startActivity(i);
				finish();
			}
		});
		
		// add click listener to "next" button
		imageButtonNextGame.setOnClickListener( new OnClickListener()
		{
			
			@Override
			public void onClick( View arg0 )
			{
				if( gameCount < 5 )
				{
					//  start the activity again
					Intent reloadI = getIntent();
					reloadI.putExtra( "gameCount", gameCount );
					reloadI.putIntegerArrayListExtra( "combiAlreadyAnswered", combiAlreadyAnswered );
					startActivity( getIntent() );
					finish();
				} else {
					int points = 5;
					if( userFunctions.isUserLoggedIn( getApplicationContext() ) )
			        {
						AlertDialog.Builder builder = new AlertDialog.Builder(OmzettenActivity.this);
		                builder.setTitle("Goedzo!");
		                builder.setMessage("Je hebt " + String.valueOf( points ) + " punten verdiend!")
		                       .setCancelable(false)
		                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
		                           public void onClick(DialogInterface dialog, int id) {
		                        	   OmzettenActivity.this.runOnUiThread(new Runnable() {
		                                   public void run() {
		                                	   //  addscore
		                                   }
		                        	   });
		                        	   Intent i = new Intent( getApplicationContext(), MainActivity.class );
		                        	   startActivity(i);
		                        	   finish();
		                           }
		                       });                     
		                AlertDialog alert = builder.create();
		                alert.show();
			        } else {
			        	//  user is not logged in
			        	AlertDialog.Builder builder = new AlertDialog.Builder(OmzettenActivity.this);
		                builder.setTitle("Whoops!");
		                builder.setMessage("Je bent niet ingelogd.\nJe bent " + String.valueOf( points ) + " punten misgelopen, log snel in!")
		                       .setCancelable(false)
		                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
		                           public void onClick(DialogInterface dialog, int id) {
		                        	   Intent i = new Intent( getApplicationContext(), MainActivity.class );
		                        	   startActivity(i);
		                        	   finish();
		                           }
		                       });                     
		                AlertDialog alert = builder.create();
		                alert.show();
			        }
				}
			}
			
		});
		
		buttonHints.setOnClickListener( new OnClickListener(){
			
			public void onClick( View arg0 )
			{
				AlertDialog.Builder builder = new AlertDialog.Builder(activity);
			    LayoutInflater inflater = activity.getLayoutInflater();
		        builder.setView(inflater.inflate(R.layout.hintslayout, null));
		        builder.create();
				builder.show();
			
			}
			
		});
	}
    
    // toggle visbility of ImageButtonNext on
    public void showImageButtonNextGame()
    {
    	this.imageButtonNextGame.setVisibility( 1 );
    }
	
}