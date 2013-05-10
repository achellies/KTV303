package com.ktv303.numeric;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Buttons;
import model.Combination;
import model.Number;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class OmzettenActivity extends Activity
{
	//  ImageButton imageButtonGoBack
	private ImageButton imageButtonGoBack;
	//  ImageButton imageButtonNext
	private ImageButton imageButtonNext;
	//  List Number numbers
	private List<Buttons> buttons;
	//  int numberID
	private int buttonID;
	//  int highscore
	private int highscore;
	//  int gameCount
	private int gameCount;
	//  int[] combiAlreadyAnswered
	private ArrayList<Integer> combiAlreadyAnswered;
	//  Typeface romansTypeFace
	private Typeface romansTypeFace;
	//  List Point startPoints
	private List<Point> startPoints;
	//  List allCombinations
	private List<Combination> allCombinations;
	//  RelativeLayout relativeLayout
	private RelativeLayout ButtonLayout;
	

	

	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        setContentView( R.layout.activity_omzetten );
        
        //  set imagebuttons
        this.imageButtonGoBack = (ImageButton) findViewById( R.id.imageButtonGoBack );
        this.imageButtonNext = (ImageButton) findViewById( R.id.imageButtonNext );
        
        //  get Extra's
        Bundle bundle = getIntent().getExtras();
        this.highscore = bundle.getInt( "highscore" );
        this.gameCount = bundle.getInt( "gameCount" ) + 1;
        this.combiAlreadyAnswered = bundle.getIntegerArrayList( "combiAlreadyAnswered" );
        
        
        //  set buttonid and buttons array
        this.buttonID = 0;
        this.buttons = new ArrayList<Buttons>();
        
        //  ButtonLayout
        this.ButtonLayout = (RelativeLayout) findViewById( R.id.ButtonLayout );
        
        //  set font
        this.romansTypeFace = Typeface.createFromAsset( getAssets(), "fonts/font.ttf" );
        
        //  create four new startpoints for numbers
        this.startPoints = new ArrayList<Point>();
        this.startPoints.add( new Point( 34, 155 ) );
        this.startPoints.add( new Point( 227, 155 ) );
        this.startPoints.add( new Point( 424, 155 ) );
        this.startPoints.add( new Point( 610, 155 ) );
        this.startPoints.add( new Point( 227, 50 ) );
        
        //  shuffle the list with startpoints
        //shuffleList( this.startPoints );
        
        //  add four new buttons
        this.buttons.add( new Buttons( 1, this, this.romansTypeFace, this.startPoints.get(0) ) );
        this.buttons.add( new Buttons( 2, this, this.romansTypeFace, this.startPoints.get(1) ) );
        this.buttons.add( new Buttons( 3, this, this.romansTypeFace, this.startPoints.get(2) ) );
        this.buttons.add( new Buttons( 4, this, this.romansTypeFace, this.startPoints.get(3) ) );
        this.buttons.add( new Buttons( 5, this, this.romansTypeFace, this.startPoints.get(4) ) );
        
        //  set combinations for exercises        
        this.allCombinations = new ArrayList<Combination>();
        this.allCombinations.add( new Combination( "I", "V", "X", "L", "…Èn = " ) );
        this.allCombinations.add( new Combination( "IV", "XV", "LXX", "XC", "Negentig = " ) );
        this.allCombinations.add( new Combination( "III", "V", "XIV", "L", "Veertien = " ) );
        this.allCombinations.add( new Combination( "I", "II", "IV", "VI", "Twee = " ) );
        this.allCombinations.add( new Combination( "L", "LX", "LXX", "C", "Honderd = " ) );
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
        
	    //  set new texts based on random number and combination
        this.buttons.get( 0 ).setText( allCombinations.get( r ).getOption( 0 ) );
        this.buttons.get( 1 ).setText( allCombinations.get( r ).getOption( 1 ) );
        this.buttons.get( 2 ).setText( allCombinations.get( r ).getOption( 2 ) );
        this.buttons.get( 3 ).setText( allCombinations.get( r ).getOption( 3 ) );
        this.buttons.get( 4 ).setText( allCombinations.get( r ).getOption( 4 ) );
        
        for( Buttons buttons : this.buttons )
        {
        	this.ButtonLayout.addView( buttons, buttons.getRLP() );
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
		
    
	

		
     /**
		this.imageButtonNext.setOnClickListener( new OnClickListener()
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
			
		});**/
	
	}
    
    /**public static void shuffleList( List<Point> a )
	{
	    int n = a.size();
	    Random random = new Random();
	    random.nextInt();
	    for (int i = 0; i < n; i++)
	    {
	    	int change = i + random.nextInt(n - i);
	    	swap(a, i, change);
	    }
	}
    
	private static void swap(List<Point> a, int i, int change)
	{
		Point helper = a.get(i);
	    a.set(i, a.get(change));
	    a.set(change, helper);
	}
	**/
	
}