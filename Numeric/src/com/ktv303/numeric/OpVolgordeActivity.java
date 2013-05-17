package com.ktv303.numeric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import model.Combination;
import model.Number;
import model.UserFunctions;

public class OpVolgordeActivity extends Activity
{
	//  ImageButton imageButtonGoBack
	private ImageButton imageButtonGoBack;
	//  ImageButton imageButtonNext
	private ImageButton imageButtonNext;
	//  List Number numbers
	private List<Number> numbers;
	//  int numberID
	private int numberID;
	//  int highscore
	private int highScore;
	//  int gameCount
	private int gameCount;
	//  int[] combiAlreadyAnswered
	private ArrayList<Integer> combiAlreadyAnswered;
	//  Typeface romansTypeFace
	private Typeface romansTypeFace;
	//  RelativeLayout dragLayout
	private RelativeLayout dragLayout;
	//  List Point startPoints
	private List<Point> startPoints;
	//  List Point goodPoints
	private List<Point> goodPoints;
	//  List allCombinations
	private List<Combination> allCombinations;
	//  UserFunctions userFunctions;
	private UserFunctions userFunctions;
	//  TextView textViewHighScore
	private TextView textViewHighScore;
	
	@Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        //  set op_volgorde screen content
        setContentView( R.layout.activity_op_volgorde );
        
        this.userFunctions = new UserFunctions();
        
        //  set imagebuttons
        this.imageButtonGoBack = (ImageButton) findViewById( R.id.imageButtonGoBack );
        this.imageButtonNext = (ImageButton) findViewById( R.id.imageButtonNext );
        //  set TextViews
        this.textViewHighScore = (TextView) findViewById( R.id.textViewHighScoreOpVolgorde );
        
        //  get Extra's
        Bundle bundle = getIntent().getExtras();
        this.gameCount = bundle.getInt( "gameCount" ) + 1;
        this.combiAlreadyAnswered = bundle.getIntegerArrayList( "combiAlreadyAnswered" );
        
        if( this.userFunctions.isUserLoggedIn( getApplicationContext() ) )
        {
        	this.highScore = this.userFunctions.getUserHighScore( getApplicationContext() );
        	this.textViewHighScore.setText( "Highscore: " + String.valueOf( this.highScore ) );
        }
        
        //  set numberid and numbers array
        this.numberID = 0;
        this.numbers = new ArrayList<Number>();
        
        //  dragLayout
        this.dragLayout = (RelativeLayout) findViewById( R.id.dragLayout );
        
        //  set font
        this.romansTypeFace = Typeface.createFromAsset( getAssets(), "fonts/font.ttf" );
        
        //  create four new startpoints for numbers
        this.startPoints = new ArrayList<Point>();
        this.startPoints.add( new Point( 40, 130 ) );
        this.startPoints.add( new Point( 160, 130 ) );
        this.startPoints.add( new Point( 40, 250 ) );
        this.startPoints.add( new Point( 160, 250 ) );
        
        //  create four new goodpoints for numbers
        this.goodPoints = new ArrayList<Point>();
        this.goodPoints.add( new Point( 353, 269 ) );
        this.goodPoints.add( new Point( 464, 224 ) );
        this.goodPoints.add( new Point( 578, 176 ) );
        this.goodPoints.add( new Point( 690, 126 ) );
        
        //  shuffle the list with startpoints
        shuffleList( this.startPoints );
        
        //  add four new numbers
        this.numbers.add( new Number( 1, this, this.romansTypeFace, this.startPoints.get(0), this.goodPoints.get(0) ) );
        this.numbers.add( new Number( 2, this, this.romansTypeFace, this.startPoints.get(1), this.goodPoints.get(1) ) );
        this.numbers.add( new Number( 3, this, this.romansTypeFace, this.startPoints.get(2), this.goodPoints.get(2) ) );
        this.numbers.add( new Number( 4, this, this.romansTypeFace, this.startPoints.get(3), this.goodPoints.get(3) ) );
        
        //  set combinations for exercises        
        this.allCombinations = new ArrayList<Combination>();
        this.allCombinations.add( new Combination( "I", "V", "X", "L" ) );
        this.allCombinations.add( new Combination( "IV", "XV", "LXX", "XC" ) );
        this.allCombinations.add( new Combination( "III", "V", "XIV", "L" ) );
        this.allCombinations.add( new Combination( "I", "II", "IV", "VI" ) );
        this.allCombinations.add( new Combination( "L", "LX", "LXX", "C" ) );
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
        this.numbers.get( 0 ).setText( allCombinations.get( r ).getOption( 0 ) );
        this.numbers.get( 1 ).setText( allCombinations.get( r ).getOption( 1 ) );
        this.numbers.get( 2 ).setText( allCombinations.get( r ).getOption( 2 ) );
        this.numbers.get( 3 ).setText( allCombinations.get( r ).getOption( 3 ) );
        
        for( Number number : this.numbers )
        {
        	this.dragLayout.addView( number, number.getRLP() );
        }
        
        addListenerOnButton();
    }
	
	public void addListenerOnButton()
    {
		//  set onclick listener for imageButtonGoBack
		this.imageButtonGoBack.setOnClickListener( new OnClickListener()
		{
			
			@Override
			public void onClick( View arg0 )
			{
				//  finish the activity
				Intent i = new Intent( getApplicationContext(), MainActivity.class );
				startActivity(i);
			}
			
		});
		
		//  set onclick listener for imageButtonNext
		this.imageButtonNext.setOnClickListener( new OnClickListener()
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
				} else {
					Intent i = new Intent( getApplicationContext(), MainActivity.class );
					startActivity(i);
				}
				finish();
			}
			
		});
		
	}
	
	// events when touching the screen
    public boolean onTouchEvent(MotionEvent event)
    {
        int eventaction = event.getAction(); 
        
        //  get the X and Y coordinate from touch screen
        int X = (int) event.getX();
        int Y = (int) event.getY();
        
        switch (eventaction )
        { 
        	case MotionEvent.ACTION_DOWN:
        		//  when user press on the screen
        		//  reset numberID
        		this.numberID = 0;
            	for( Number number : this.numbers )
            	{
            		//  check if finger was on a number
            		if( X > number.getMarginLeft() && X < number.getMarginLeft() + number.getMeasuredWidth() && Y > number.getMarginTop() && Y < number.getMarginTop() + number.getMeasuredHeight() && number.isFocusable() )
            		{
            			//  set the right numberID
                    	this.numberID = number.getID();
                    	break;
                    }
                }
        	break;
        	case MotionEvent.ACTION_MOVE:
        		//  when user move his finger on screen
        		if( this.numberID > 0 )
        		{
        			//  if numberID is bigger than 0
                	this.numbers.get( this.numberID - 1 ).moveNumber( X - 50, Y - 50 );
                }
        	break;
        	case MotionEvent.ACTION_UP: 
        		//  when user release finger from screen
        		if( this.numberID > 0 )
        		{
        			//  if numberID is bigger than 0
        			this.numbers.get( this.numberID - 1 ).checkAnswer( X, Y );
        			
        			Boolean allDone = true;
        			
        			for( Number number : this.numbers )
        			{
        				if( number.isFocusable() )
        				{
        					allDone = false;
        				}
        			}
        			
        			if( allDone )
        			{
        				this.imageButtonNext.setVisibility( 1 );
        			}
        		}
        	break;
        }
        
        this.dragLayout.requestLayout();
        return true; 
    }
    
    public static void shuffleList( List<Point> a )
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
	
}
