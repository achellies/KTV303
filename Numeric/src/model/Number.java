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
	
	public Number( int numberId, Context content, Typeface font )
	{
		super( content );
		
		//  set font
		super.setTypeface( font );
		//  set text size
		super.setTextSize( 50 );
		//  set text color
		super.setTextColor( getResources().getColor( R.color.Black ) );
		
		this.id = numberId;
	}

	public Number( int numberId, Context content, Typeface font, Point point )
	{
		this( numberId, content, font );
		
		this.paddingLeft = point.x;
		this.paddingTop = point.y;
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
	
}