package com.ktv303.numeric;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import model.Number;

public class OpVolgordeActivity extends Activity
{
	//  imageButtonGoBack
	private ImageButton imageButtonGoBack;
	//  numbers
	private Number[] numbers;
	//  numberID
	private int numberID;
	//  romansTypeFace
	private Typeface romansTypeFace;
	//  dragLayout
	private RelativeLayout dragLayout;
	
	@Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        setContentView( R.layout.activity_op_volgorde );
        
        this.numberID = 0;
        this.numbers = new Number[4];
        
        //  dragLayout
        this.dragLayout = (RelativeLayout) findViewById( R.id.dragLayout );
        
        //  set font
        this.romansTypeFace = Typeface.createFromAsset( getAssets(), "fonts/font.ttf" );
        
        List<Point> startPoints = new ArrayList<Point>();
        startPoints.add( new Point( 80, 170 ) );
        startPoints.add( new Point( 160, 170 ) );
        startPoints.add( new Point( 80, 250 ) );
        startPoints.add( new Point( 160, 250 ) );
        
        shuffleList( startPoints );        
        
        //  number 1
        Point number1GoodPoint = new Point( 352, 279 );
        this.numbers[0] = new Number( 1, this, this.romansTypeFace, startPoints.get(0), number1GoodPoint );
        this.numbers[0].setText( "I" );
        
        //  number 2
        Point number2GoodPoint = new Point( 462, 228 );
        this.numbers[1] = new Number( 2, this, this.romansTypeFace, startPoints.get(1), number2GoodPoint );
        this.numbers[1].setText( "V" );
        
        //  number 3
        Point number3GoodPoint = new Point( 574, 179 );
        this.numbers[2] = new Number( 3, this, this.romansTypeFace, startPoints.get(2), number3GoodPoint );
        this.numbers[2].setText( "X" );
        
        //  number 4
        Point number4GoodPoint = new Point( 690, 125 );
        this.numbers[3] = new Number( 4, this, this.romansTypeFace, startPoints.get(3), number4GoodPoint );
        this.numbers[3].setText( "L" );
        
        for( Number number : this.numbers )
        {
        	this.dragLayout.addView( number, number.getRLP() );
        }
        
        addListenerOnButton();
    }
	
	public void addListenerOnButton()
    {
		
		imageButtonGoBack = (ImageButton) findViewById( R.id.imageButtonGoBack );
		
		imageButtonGoBack.setOnClickListener( new OnClickListener()
		{
			
			@Override
			public void onClick( View arg0 )
			{
				finish();
			}
			
		});
		
	}
	
	// events when touching the screen
    public boolean onTouchEvent(MotionEvent event)
    {
        int eventaction = event.getAction(); 
        
        int X = (int) event.getX(); 
        int Y = (int) event.getY();
        
        switch (eventaction )
        { 
        	case MotionEvent.ACTION_DOWN:
        		// touch down so check if the finger is on a ball
        		Log.v( "TOUCHDOWN", "TOUCHDOWN" );
        		this.numberID = 0;
            	for( Number number : this.numbers )
            	{
            		// check all the bounds of the number (square)
            		if( X > number.getMarginLeft() && X < number.getMarginLeft() + number.getMeasuredWidth() && Y > number.getMarginTop() && Y < number.getMarginTop() + number.getMeasuredHeight() && number.isFocusable() )
            		{
                    	this.numberID = number.getID();
                    	Log.v( "setted numberID:", String.valueOf( this.numberID ) );
                    	break;
                    }
                  }
        		break;
        	case MotionEvent.ACTION_MOVE:
        		Log.v( "MOVE", "X: " + X + " Y: " + Y );
        		if( this.numberID > 0 )
        		{
                	this.numbers[ this.numberID - 1 ].moveNumber( X - 25, Y - 25 );
                }
        		break;
        	case MotionEvent.ACTION_UP: 
        		// touch drop - just do things here after dropping
        		if( this.numberID > 0 )
        		{
        			if( this.numberID == 1 )
        			{
        				this.numbers[0].checkAnswer( X, Y );
        			} else if( this.numberID == 2 ) {
        				this.numbers[1].checkAnswer( X, Y );
        			} else if( this.numberID == 3 ) {
        				this.numbers[2].checkAnswer( X, Y );
        			} else if( this.numberID == 4 ) {
        				this.numbers[3].checkAnswer( X, Y );
        			}
        		}
        		break;
        }
        
        this.dragLayout.requestLayout();
        return true; 
    }
    
    public static void shuffleList(List<Point> a)
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
