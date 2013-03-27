package model;

import com.ktv303.numeric.R;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Typeface;
import android.widget.TextView;

public class Number extends TextView {
	private int paddingLeft;
	private int paddingTop;
	private int id;
	private static int count = 1;
	private boolean goRight = true;
	private boolean goDown = true;
	
	public Number( Context content, Typeface font )
	{
		super( content );
		
		//  set font
		super.setTypeface( font );
		//  set text size
		super.setTextSize( 50 );
		//  set text color
		super.setTextColor( getResources().getColor( R.color.Black ) );
		
		this.id = count;
		count++;
	}

	public Number( Context content, Typeface font, Point point )
	{
		this( content, font );
		
		this.paddingLeft = point.x;
		this.paddingTop = point.y;
	}
	
	public static int getCount()
	{
		return count;
	}
	
	public void setPaddingLeft( int newPaddingLeft )
	{
		this.paddingLeft = newPaddingLeft;
	}
	
	public int getPaddingLeft()
	{
		return this.paddingLeft;
	}
	
	public void setPaddingTop( int newPaddingTop )
	{
		this.paddingTop = newPaddingTop;
	}
	
	public int getPaddingTop()
	{
		return this.paddingTop;
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public void refresh()
	{
		this.setPadding( this.paddingLeft, this.paddingTop, 0, 0 );
	}
	
	public void moveNumber( int goX, int goY )
	{
		if( this.paddingLeft > 270 )
		{
			this.goRight = false;
		}
		if( this.paddingLeft < 0 )
		{
			this.goRight = true;
		}
		if( this.paddingTop > 400 )
		{
			this.goDown = false;
		}
		if( this.paddingTop < 0 )
		{
			this.goDown = true;
		}
		
		//  move the x
		if( this.goRight )
		{
			this.paddingLeft += goX;
		} else {
			this.paddingLeft -= goX;
		}
		
		//  move the y
		if( this.goDown )
		{
			this.paddingTop += goY;
		} else {
			this.paddingTop -= goY;
		}
	}
	
}