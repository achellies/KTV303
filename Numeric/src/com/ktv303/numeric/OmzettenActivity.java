package com.ktv303.numeric;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Combination;
import model.Gate;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class OmzettenActivity extends Activity
{
	//  ImageButton imageButtonGoBack
	private ImageButton imageButtonGoBack;
	//  ImageButton imageButtonNext
	private ImageButton imageButtonNextGame;
	//  List Number numbers
	private List<Gate> gates;
	//  int gateID
	private int gateID;
	//  int highscore
	private int highscore;
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
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        setContentView( R.layout.activity_omzetten );
        
        this.activity = this;
        
        //  set imagebuttons
        this.imageButtonGoBack = (ImageButton) findViewById( R.id.imageButtonGoBack );
        this.imageButtonNextGame = (ImageButton) findViewById( R.id.imageButtonNextGame );
        
        //  get Extra's
        Bundle bundle = getIntent().getExtras();
        this.highscore = bundle.getInt( "highscore" );
        this.gameCount = bundle.getInt( "gameCount" ) + 1;
        this.combiAlreadyAnswered = bundle.getIntegerArrayList( "combiAlreadyAnswered" );
        
        //  set gateid and gates array
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
        
        this.gateLayout.addView( txtViewQuestion );
        
        for( Gate gate : this.gates )
        {
        	this.gateLayout.addView( gate, gate.getRLP() );
        	this.gateLayout.addView( gate.getTxtView(), gate.getTxtRLP() );
        }
        
        addListenerOnButton();
    }
    
    public void addListenerOnButton()
    { 
		imageButtonGoBack.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
		
		this.imageButtonNextGame.setOnClickListener( new OnClickListener()
		{
			
			@Override
			public void onClick( View arg0 )
			{
				//  finish the activity
				finish();
				if( gameCount < 5 )
				{
					//  start the activity again
					Intent reloadI = getIntent();
					reloadI.putExtra( "highscore", highscore );
					reloadI.putExtra( "gameCount", gameCount );
					reloadI.putIntegerArrayListExtra( "combiAlreadyAnswered", combiAlreadyAnswered );
					startActivity( getIntent() );
				}
			}
			
		});
	}
    
    public void showImageButtonNextGame()
    {
    	this.imageButtonNextGame.setVisibility( 1 );
    }
	
}