package model;

import com.ktv303.numeric.R;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Number extends TextView {
	private RelativeLayout.LayoutParams RLP;
	private int originalX;
	private int originalY;
	private int goodX;
	private int goodY;
	private int id;
	
	public Number( int numberId, Context content, Typeface font )
	{
		super( content );
		
		//  set font
		super.setTypeface( font );
		//  set text size
		super.setTextSize( 50 );
		//  set text color
		super.setTextColor( getResources().getColor( R.color.White ) );
		//  set background color
		super.setBackgroundColor( getResources().getColor( R.color.Grey ) );
		//  set height of number
		super.setHeight( 50 );
		//  set width of number
		super.setWidth( 50 );
		//  set horizontal and vertical alignment
		super.setGravity( Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL );
		//  set padding top
		super.setPadding( 0, 5, 0, 0 );
		
		super.setFocusable( true );
		
		this.id = numberId;
	}

	public Number( int numberId, Context content, Typeface font, Point startPoint, Point goodPoint )
	{
		this( numberId, content, font );
		
		this.RLP = new RelativeLayout.LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT );
		this.originalX = this.RLP.leftMargin = startPoint.x;
		this.originalY = this.RLP.topMargin = startPoint.y;
		this.goodX = goodPoint.x;
		this.goodY = goodPoint.y;
	}
	
	public void moveNumber( int X, int Y )
	{
		this.RLP.leftMargin = X;
		this.RLP.topMargin = Y;
	}
	
	public int getMarginLeft()
	{
		return this.RLP.leftMargin;
	}
	
	public int getMarginTop()
	{
		return this.RLP.topMargin;
	}
	
	public int getID()
	{
		return this.id;
	}
	
	private void good()
	{
		this.setBackgroundColor( getResources().getColor( R.color.Green ) );
		this.moveNumber( this.goodX - 25, this.goodY - 25 );
		this.setFocusable( false );
	}
	
	private void wrong()
	{
		this.setBackgroundColor( getResources().getColor( R.color.Red ) );
		this.resetPosition();
	}
	
	public void checkAnswer( int X, int Y )
	{
		if( ( ( this.goodX - 15 ) < X && X < ( this.goodX + 15 ) ) && ( ( this.goodY - 15 ) < Y && Y < ( this.goodY + 15 ) ) )
		{
			//  correct answer was given
			this.good();
		} else {
			//  wrong answer was given, reset position
			this.wrong();
		}
	}
	
	public void resetPosition()
	{
		this.moveNumber( this.originalX, this.originalY );
	}
	
	public RelativeLayout.LayoutParams getRLP()
	{
		return this.RLP;
	}
	
}