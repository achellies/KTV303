package model;

import com.ktv303.numeric.OmzettenActivity;
import com.ktv303.numeric.R;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

public class Gate extends ImageButton {
	
	//  int gateID
	private int gateID;
	//  TextView txtView
	private TextView txtView;
	//  int marginLeft
	private int leftMargin;
	//  int marginTop
	private int topMargin;
	//  RelativeLayout.LayoutParams RLP
	private RelativeLayout.LayoutParams RLP;
//  RelativeLayout.LayoutParams txtRLP
	private RelativeLayout.LayoutParams txtRLP;
	//  String rightAnswer
	private String rightAnswer;
	//  Gate gate
	private Gate gate;
	
	public Gate( int gateID, Context context, Typeface font, Point point, String rightAnswer, final OmzettenActivity activity )
	{
		super( context );
		super.setFocusable( true );
		
		this.gateID = gateID;
		this.leftMargin = point.x;
		this.topMargin = point.y;
		
		this.RLP = new RelativeLayout.LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT );
		this.txtRLP = new RelativeLayout.LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT );
		
		this.RLP.leftMargin = this.txtRLP.leftMargin = this.leftMargin;
		this.RLP.topMargin = this.txtRLP.topMargin = this.topMargin;
		
		this.txtView = new TextView( context );
		this.txtView.setTypeface( font );
		this.txtView.setTextSize( 40 );
		this.txtView.setTextColor( getResources().getColor( R.color.White ) );
		this.txtView.setShadowLayer(
		          20f,   //float radius
		          0f,  //float dx
		          0f,  //float dy 
		          0xFF000000 //int color
		          );
		this.txtView.setHeight( 110 );
		this.txtView.setWidth( 95 );
		this.txtView.setGravity( Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL );
		this.txtView.setPadding( 0, 5, 0, 0 );
		
		this.setBackgroundDrawable( getDrawable( "" ) );
		this.setImageDrawable( null );
		
		this.rightAnswer = rightAnswer;
		
		this.gate = this;
		
		super.setOnClickListener( new OnClickListener()
		{
			@Override
			public void onClick(View arg0) {
				if( gate.getTxtText().equals( gate.getRightAnswer() ) )
				{
					gate.good();
					activity.showImageButtonNextGame();
				} else {
					gate.wrong();
				}
			}
		});
	}
	
	public void good()
	{
		this.setBackgroundDrawable( this.getDrawable( "good" ) );
	}
	
	public void wrong()
	{
		this.setBackgroundDrawable( this.getDrawable( "wrong" ) );
		this.setFocusable( false );
	}
	
	public Drawable getDrawable( String state )
	{
		Drawable drawable = null;
		
		if( this.gateID == 1 )
		{
			if( state.equals( "good" ) )
			{
				drawable = getResources().getDrawable( R.drawable.gate_1_good );
			} else if( state.equals( "wrong" ) ) {
				drawable = getResources().getDrawable( R.drawable.gate_1_wrong );
			} else {
				drawable = getResources().getDrawable( R.drawable.gate_1 );
			}
		} else if( this.gateID == 2 ) {
			if( state.equals( "good" ) )
			{
				drawable = getResources().getDrawable( R.drawable.gate_2_good );
			} else if( state.equals( "wrong" ) ) {
				drawable = getResources().getDrawable( R.drawable.gate_2_wrong );
			} else {
				drawable = getResources().getDrawable( R.drawable.gate_2 );
			}
		} else if( this.gateID == 3 ) {
			if( state.equals( "good" ) )
			{
				drawable = getResources().getDrawable( R.drawable.gate_3_good );
			} else if( state.equals( "wrong" ) ) {
				drawable = getResources().getDrawable( R.drawable.gate_3_wrong );
			} else {
				drawable = getResources().getDrawable( R.drawable.gate_3 );
			}
		} else if( this.gateID == 4 ) {
			if( state.equals( "good" ) )
			{
				drawable = getResources().getDrawable( R.drawable.gate_4_good );
			} else if( state.equals( "wrong" ) ) {
				drawable = getResources().getDrawable( R.drawable.gate_4_wrong );
			} else {
				drawable = getResources().getDrawable( R.drawable.gate_4 );
			}
		}
		
		return drawable;
	}
	
	public void setText( String text )
	{
		this.txtView.setText( text );
	}
	
	public String getTxtText()
	{
		return (String) this.txtView.getText();
	}
	
	public String getRightAnswer()
	{
		return this.rightAnswer;
	}
	
	public int getGateID()
	{
		return this.gateID;
	}
	
	public int getLeftMargin()
	{
		return this.leftMargin;
	}
	
	public int getTopMargin()
	{
		return this.topMargin;
	}
	
	public RelativeLayout.LayoutParams getRLP()
	{
		return this.RLP;
	}
	
	public RelativeLayout.LayoutParams getTxtRLP()
	{
		return this.txtRLP;
	}
	
	public TextView getTxtView()
	{
		return this.txtView;
	}
}
