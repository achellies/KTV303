package com.ktv303.numeric;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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



public class OmzettenActivity extends Activity
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
	private int highscore;
	//  int gameCount
	private int gameCount;
	//  int[] combiAlreadyAnswered
	private ArrayList<Integer> combiAlreadyAnswered;
	//  Typeface romansTypeFace
	private Typeface romansTypeFace;
	//  List Point startPoints
	private List<Point> startPoints;
	//  List Point goodPoints
	private List<Point> goodPoints;
	//  List allCombinations
	private List<Combination> allCombinations;
	//  RelativeLayout relativeLayout
	private RelativeLayout relativeLayout;
	
	// Background doors
	private ImageView imageViewOmzettenBackground;
	private ImageView imageView1goed;
	private ImageView imageView2goed;
	private ImageView imageView3goed;
	private ImageView imageView4goed;
	private ImageView imageView1fout;
	private ImageView imageView2fout;
	private ImageView imageView3fout;
	private ImageView imageView4fout;
	
	// Buttons doors
	private ImageButton imageButtonDoor1;
	private ImageButton imageButtonDoor2;
	private ImageButton imageButtonDoor3;
	private ImageButton imageButtonDoor4;
	

	
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
        
        
        //  set numberid and numbers array
        this.numberID = 0;
        this.numbers = new ArrayList<Number>();
        
        //  dragLayout
        this.relativeLayout = (RelativeLayout) findViewById( R.id.RelativeLayout );
        
        //  set font
        this.romansTypeFace = Typeface.createFromAsset( getAssets(), "fonts/font.ttf" );
        
        //  create four new startpoints for numbers
        this.startPoints = new ArrayList<Point>();
        this.startPoints.add( new Point( 40, 130 ) );
        this.startPoints.add( new Point( 160, 130 ) );
        this.startPoints.add( new Point( 40, 250 ) );
        this.startPoints.add( new Point( 160, 250 ) );
        
        
        
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
        	this.relativeLayout.addView( number, number.getRLP() );
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
		
    
		imageButtonDoor1 = (ImageButton) findViewById(R.id.imageButtonDoor1);
		
	    imageButtonDoor1.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0)
			{
				if(arg0 == imageButtonDoor1){
					//if(QuestionValue==true){
					imageViewOmzettenBackground = (ImageView) findViewById(R.id.imageViewOmzettenBackground);
					imageViewOmzettenBackground.setVisibility(ImageView.GONE);
					imageView4fout = (ImageView) findViewById(R.id.imageView4fout);
					imageView4fout.setVisibility(ImageView.GONE);
					imageView3fout = (ImageView) findViewById(R.id.imageView3fout);
					imageView3fout.setVisibility(ImageView.GONE);
					imageView2fout = (ImageView) findViewById(R.id.imageView2fout);
					imageView2fout.setVisibility(ImageView.GONE);
					imageView1fout = (ImageView) findViewById(R.id.imageView1fout);
					imageView1fout.setVisibility(ImageView.GONE);
					imageView4goed = (ImageView) findViewById(R.id.imageView4goed);
					imageView4goed.setVisibility(ImageView.GONE);
					imageView3goed = (ImageView) findViewById(R.id.imageView3goed);
					imageView3goed.setVisibility(ImageView.GONE);
					imageView2goed = (ImageView) findViewById(R.id.imageView2goed);
					imageView2goed.setVisibility(ImageView.GONE);
					imageView1goed = (ImageView) findViewById(R.id.imageView1goed);
					imageView1goed.setVisibility(ImageView.VISIBLE);
					/**}
					else{
						imageViewOmzettenBackground = (ImageView) findViewById(R.id.imageViewOmzettenBackground);
						imageViewOmzettenBackground.setVisibility(ImageView.GONE);
						imageView4fout = (ImageView) findViewById(R.id.imageView4fout);
						imageView4fout.setVisibility(ImageView.GONE);
						imageView3fout = (ImageView) findViewById(R.id.imageView3fout);
						imageView3fout.setVisibility(ImageView.GONE);
						imageView2fout = (ImageView) findViewById(R.id.imageView2fout);
						imageView2fout.setVisibility(ImageView.GONE);
						imageView1fout = (ImageView) findViewById(R.id.imageView1fout);
						imageView1fout.setVisibility(ImageView.VISIBLE);
						imageView4goed = (ImageView) findViewById(R.id.imageView4goed);
						imageView4goed.setVisibility(ImageView.GONE);
						imageView3goed = (ImageView) findViewById(R.id.imageView3goed);
						imageView3goed.setVisibility(ImageView.GONE);
						imageView2goed = (ImageView) findViewById(R.id.imageView2goed);
						imageView2goed.setVisibility(ImageView.GONE);
						imageView1goed = (ImageView) findViewById(R.id.imageView1goed);
						imageView1goed.setVisibility(ImageView.GONE);
						}**/
				}
				
				//Hierin switchen we tussen het dichte deurtje en het open deurtje
			}
		});
		
		imageButtonDoor2 = (ImageButton) findViewById(R.id.imageButtonDoor2);
		
		imageButtonDoor2.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0)
			{
				if(arg0 == imageButtonDoor2){
					//if(QuestionValue==true){
					imageViewOmzettenBackground = (ImageView) findViewById(R.id.imageViewOmzettenBackground);
					imageViewOmzettenBackground.setVisibility(ImageView.GONE);
					imageView4fout = (ImageView) findViewById(R.id.imageView4fout);
					imageView4fout.setVisibility(ImageView.GONE);
					imageView3fout = (ImageView) findViewById(R.id.imageView3fout);
					imageView3fout.setVisibility(ImageView.GONE);
					imageView2fout = (ImageView) findViewById(R.id.imageView2fout);
					imageView2fout.setVisibility(ImageView.GONE);
					imageView1fout = (ImageView) findViewById(R.id.imageView1fout);
					imageView1fout.setVisibility(ImageView.GONE);
					imageView4goed = (ImageView) findViewById(R.id.imageView4goed);
					imageView4goed.setVisibility(ImageView.GONE);
					imageView3goed = (ImageView) findViewById(R.id.imageView3goed);
					imageView3goed.setVisibility(ImageView.GONE);
					imageView2goed = (ImageView) findViewById(R.id.imageView2goed);
					imageView2goed.setVisibility(ImageView.VISIBLE);
					imageView1goed = (ImageView) findViewById(R.id.imageView1goed);
					imageView1goed.setVisibility(ImageView.GONE);
					/**}
					else{
						imageViewOmzettenBackground = (ImageView) findViewById(R.id.imageViewOmzettenBackground);
						imageViewOmzettenBackground.setVisibility(ImageView.GONE);
						imageView4fout = (ImageView) findViewById(R.id.imageView4fout);
						imageView4fout.setVisibility(ImageView.GONE);
						imageView3fout = (ImageView) findViewById(R.id.imageView3fout);
						imageView3fout.setVisibility(ImageView.GONE);
						imageView2fout = (ImageView) findViewById(R.id.imageView2fout);
						imageView2fout.setVisibility(ImageView.VISIBLE);
						imageView1fout = (ImageView) findViewById(R.id.imageView1fout);
						imageView1fout.setVisibility(ImageView.GONE);
						imageView4goed = (ImageView) findViewById(R.id.imageView4goed);
						imageView4goed.setVisibility(ImageView.GONE);
						imageView3goed = (ImageView) findViewById(R.id.imageView3goed);
						imageView3goed.setVisibility(ImageView.GONE);
						imageView2goed = (ImageView) findViewById(R.id.imageView2goed);
						imageView2goed.setVisibility(ImageView.GONE);
						imageView1goed = (ImageView) findViewById(R.id.imageView1goed);
						imageView1goed.setVisibility(ImageView.GONE);
						}**/
				}
				
				//Hierin switchen we tussen het dichte deurtje en het open deurtje
			}
		});
		
		imageButtonDoor3 = (ImageButton) findViewById(R.id.imageButtonDoor3);
		
		imageButtonDoor3.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0)
			{
				//if(QuestionValue==true){
				imageViewOmzettenBackground = (ImageView) findViewById(R.id.imageViewOmzettenBackground);
				imageViewOmzettenBackground.setVisibility(ImageView.GONE);
				imageView4fout = (ImageView) findViewById(R.id.imageView4fout);
				imageView4fout.setVisibility(ImageView.GONE);
				imageView3fout = (ImageView) findViewById(R.id.imageView3fout);
				imageView3fout.setVisibility(ImageView.GONE);
				imageView2fout = (ImageView) findViewById(R.id.imageView2fout);
				imageView2fout.setVisibility(ImageView.GONE);
				imageView1fout = (ImageView) findViewById(R.id.imageView1fout);
				imageView1fout.setVisibility(ImageView.GONE);
				imageView4goed = (ImageView) findViewById(R.id.imageView4goed);
				imageView4goed.setVisibility(ImageView.GONE);
				imageView3goed = (ImageView) findViewById(R.id.imageView3goed);
				imageView3goed.setVisibility(ImageView.VISIBLE);
				imageView2goed = (ImageView) findViewById(R.id.imageView2goed);
				imageView2goed.setVisibility(ImageView.GONE);
				imageView1goed = (ImageView) findViewById(R.id.imageView1goed);
				imageView1goed.setVisibility(ImageView.GONE);
				/**}
				else{
					imageViewOmzettenBackground = (ImageView) findViewById(R.id.imageViewOmzettenBackground);
					imageViewOmzettenBackground.setVisibility(ImageView.GONE);
					imageView4fout = (ImageView) findViewById(R.id.imageView4fout);
					imageView4fout.setVisibility(ImageView.GONE);
					imageView3fout = (ImageView) findViewById(R.id.imageView3fout);
					imageView3fout.setVisibility(ImageView.VISIBLE);
					imageView2fout = (ImageView) findViewById(R.id.imageView2fout);
					imageView2fout.setVisibility(ImageView.GONE);
					imageView1fout = (ImageView) findViewById(R.id.imageView1fout);
					imageView1fout.setVisibility(ImageView.GONE);
					imageView4goed = (ImageView) findViewById(R.id.imageView4goed);
					imageView4goed.setVisibility(ImageView.GONE);
					imageView3goed = (ImageView) findViewById(R.id.imageView3goed);
					imageView3goed.setVisibility(ImageView.GONE);
					imageView2goed = (ImageView) findViewById(R.id.imageView2goed);
					imageView2goed.setVisibility(ImageView.GONE);
					imageView1goed = (ImageView) findViewById(R.id.imageView1goed);
					imageView1goed.setVisibility(ImageView.GONE);
					}**/
				//Hierin switchen we tussen het dichte deurtje en het open deurtje
			}
		});
		
		imageButtonDoor4 = (ImageButton) findViewById(R.id.imageButtonDoor4);
		
		imageButtonDoor4.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0)
			{
				//if(QuestionValue==true){
				imageViewOmzettenBackground = (ImageView) findViewById(R.id.imageViewOmzettenBackground);
				imageViewOmzettenBackground.setVisibility(ImageView.GONE);
				imageView4fout = (ImageView) findViewById(R.id.imageView4fout);
				imageView4fout.setVisibility(ImageView.GONE);
				imageView3fout = (ImageView) findViewById(R.id.imageView3fout);
				imageView3fout.setVisibility(ImageView.GONE);
				imageView2fout = (ImageView) findViewById(R.id.imageView2fout);
				imageView2fout.setVisibility(ImageView.GONE);
				imageView1fout = (ImageView) findViewById(R.id.imageView1fout);
				imageView1fout.setVisibility(ImageView.GONE);
				imageView4goed = (ImageView) findViewById(R.id.imageView4goed);
				imageView4goed.setVisibility(ImageView.VISIBLE);
				imageView3goed = (ImageView) findViewById(R.id.imageView3goed);
				imageView3goed.setVisibility(ImageView.GONE);
				imageView2goed = (ImageView) findViewById(R.id.imageView2goed);
				imageView2goed.setVisibility(ImageView.GONE);
				imageView1goed = (ImageView) findViewById(R.id.imageView1goed);
				imageView1goed.setVisibility(ImageView.GONE);
				/**}
				else{
					imageViewOmzettenBackground = (ImageView) findViewById(R.id.imageViewOmzettenBackground);
					imageViewOmzettenBackground.setVisibility(ImageView.GONE);
					imageView4fout = (ImageView) findViewById(R.id.imageView4fout);
					imageView4fout.setVisibility(ImageView.VISIBLE);
					imageView3fout = (ImageView) findViewById(R.id.imageView3fout);
					imageView3fout.setVisibility(ImageView.GONE);
					imageView2fout = (ImageView) findViewById(R.id.imageView2fout);
					imageView2fout.setVisibility(ImageView.GONE);
					imageView1fout = (ImageView) findViewById(R.id.imageView1fout);
					imageView1fout.setVisibility(ImageView.GONE);
					imageView4goed = (ImageView) findViewById(R.id.imageView4goed);
					imageView4goed.setVisibility(ImageView.GONE);
					imageView3goed = (ImageView) findViewById(R.id.imageView3goed);
					imageView3goed.setVisibility(ImageView.GONE);
					imageView2goed = (ImageView) findViewById(R.id.imageView2goed);
					imageView2goed.setVisibility(ImageView.GONE);
					imageView1goed = (ImageView) findViewById(R.id.imageView1goed);
					imageView1goed.setVisibility(ImageView.GONE);
					}**/
				//Hierin switchen we tussen het dichte deurtje en het open deurtje
			}
		});
     
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
			
		});
	
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