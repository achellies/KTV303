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
		
		// gateID
		this.gateID = gateID;
		// leftMargin
		this.leftMargin = point.x;
		// topMargin
		this.topMargin = point.y;
		
		// RLP
		this.RLP = new RelativeLayout.LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT );
		// txtRLP
		this.txtRLP = new RelativeLayout.LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT );
		
		this.RLP.leftMargin = this.txtRLP.leftMargin = this.leftMargin;
		this.RLP.topMargin = this.txtRLP.topMargin = this.topMargin;
		
		this.txtView = new TextView( context );
		// set txtView font
		this.txtView.setTypeface( font );
		// set txtView size
		this.txtView.setTextSize( 40 );
		// set txtView color
		this.txtView.setTextColor( getResources().getColor( R.color.White ) );
		// set txtView shadow
		this.txtView.setShadowLayer(
		          20f,   //float radius
		          0f,  //float dx
		          0f,  //float dy 
		          0xFF000000 //int color
		          );
		// set txtView height
		this.txtView.setHeight( 110 );
		// set txtView width
		this.txtView.setWidth( 95 );
		// set gravity
		this.txtView.setGravity( Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL );
		// set padding
		this.txtView.setPadding( 0, 5, 0, 0 );
		
		// set background to null
		this.setBackgroundDrawable( getDrawable( "" ) );
		this.setImageDrawable( null );
		
		// rightAnswer
		this.rightAnswer = rightAnswer;
		
		// gate
		this.gate = this;
		
		// set OnClickListener
		super.setOnClickListener( new OnClickListener()
		{
			// set OnClick that checks if answer is right and performs either the good() or wrong() method
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
	
	// set gate background to green (right)
	public void good()
	{
		this.setBackgroundDrawable( this.getDrawable( "good" ) );
	}
	
	// set gate background to red (wrong)
	public void wrong()
	{
		this.setBackgroundDrawable( this.getDrawable( "wrong" ) );
		this.setFocusable( false );
	}
	
	// give right background to good() and wrong() method
	public Drawable getDrawable( String state )
	{
		Drawable drawable = null;
		// give gate 1 background depending if answer is right wrong or not answered
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
		// give gate 2 background depending if answer is right wrong or not answered
		} else if( this.gateID == 2 ) {
			if( state.equals( "good" ) )
			{
				drawable = getResources().getDrawable( R.drawable.gate_2_good );
			} else if( state.equals( "wrong" ) ) {
				drawable = getResources().getDrawable( R.drawable.gate_2_wrong );
			} else {
				drawable = getResources().getDrawable( R.drawable.gate_2 );
			}
		// give gate 3 background depending if answer is right wrong or not answered
		} else if( this.gateID == 3 ) {
			if( state.equals( "good" ) )
			{
				drawable = getResources().getDrawable( R.drawable.gate_3_good );
			} else if( state.equals( "wrong" ) ) {
				drawable = getResources().getDrawable( R.drawable.gate_3_wrong );
			} else {
				drawable = getResources().getDrawable( R.drawable.gate_3 );
			}
		// give gate 4 background depending if answer is right wrong or not answered
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
	
	// set text to txtView
	public void setText( String text )
	{
		this.txtView.setText( text );
	}
	
	// get text from txtView
	public String getTxtText()
	{
		return (String) this.txtView.getText();
	}
	
	// get RightAnswer
	public String getRightAnswer()
	{
		return this.rightAnswer;
	}
	
	// get gateID
	public int getGateID()
	{
		return this.gateID;
	}
	
	// get LeftMargin(X)
	public int getLeftMargin()
	{
		return this.leftMargin;
	}
	
	// get TopMargin(Y)
	public int getTopMargin()
	{
		return this.topMargin;
	}
	
	// get RLP
	public RelativeLayout.LayoutParams getRLP()
	{
		return this.RLP;
	}
	
	// get txtRLP
	public RelativeLayout.LayoutParams getTxtRLP()
	{
		return this.txtRLP;
	}
	
	// get txtView
	public TextView getTxtView()
	{
		return this.txtView;
	}
}
