package com.ktv303.numeric;

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
        
        //  reset numberID
        this.numberID = 0;
        this.numbers = new Number[4];
        Log.v( "numbers:", this.numbers.toString() );
        
        //  dragLayout
        this.dragLayout = (RelativeLayout) findViewById( R.id.dragLayout );
        
        //  set font
        this.romansTypeFace = Typeface.createFromAsset( getAssets(), "fonts/font.ttf" );
        
        //  number 1
        Point point1 = new Point( 80, 170 );
        this.numbers[0] = new Number( this, this.romansTypeFace, point1 );
        this.numbers[0].setText( "I" );
        
        //  number 2
        Point point2 = new Point( 80, 250 );
        this.numbers[1] = new Number( this, this.romansTypeFace, point2 );
        this.numbers[1].setText( "V" );
        
        //  number 3
        Point point3 = new Point( 160, 170 );
        this.numbers[2] = new Number( this, this.romansTypeFace, point3 );
        this.numbers[2].setText( "X" );
        
        //  number 4
        Point point4 = new Point( 160, 250 );
        this.numbers[3] = new Number( this, this.romansTypeFace, point4 );
        this.numbers[3].setText( "L" );
        
        for( Number number : this.numbers )
        {
        	number.refresh();
        	this.dragLayout.addView( number );
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
            		if( X > number.getPaddingLeft() && X < number.getPaddingLeft() + 50 && Y > number.getPaddingTop() && Y < number.getPaddingTop() + 50 )
            		{
                    	this.numberID = number.getID();
                    	Log.v( "setted numberID:", String.valueOf( this.numberID ) );
                    	break;
                    }
                  }
        		break;
        	case MotionEvent.ACTION_MOVE:
        		Log.v( "MOVE", "MOVE" );
        		if( this.numberID > 0 )
        		{
                	this.numbers[ this.numberID - 1 ].setPaddingLeft( X - 25 );
                	this.numbers[ this.numberID - 1 ].setPaddingTop( Y - 25 );
        			this.numbers[ this.numberID - 1 ].refresh();
                }
        		break;
        	case MotionEvent.ACTION_UP: 
        		// touch drop - just do things here after dropping
        		
        		break;
        }
        
        this.dragLayout.requestLayout();
        return true; 
    }
	
}
