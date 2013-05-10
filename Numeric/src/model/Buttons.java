package model;

import com.ktv303.numeric.R;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class Buttons extends TextView{
	private ImageView imageViewOmzettenBackground;
	private ImageView imageView1goed;
	private ImageView imageView2goed;
	private ImageView imageView3goed;
	private ImageView imageView4goed;
	private ImageView imageView1fout;
	private ImageView imageView2fout;
	private ImageView imageView3fout;
	private ImageView imageView4fout;
	

	private RelativeLayout.LayoutParams RLP;
	private int startX;
	private int startY;
	private int id;
	private RelativeLayout ButtonLayout;
	private RelativeLayout RelativeLayout;

	

	
	
		public Buttons( int buttonId, Context content, Typeface font ){
			super( content );
			
			//  set font
			super.setTypeface( font );
			//  set text size
			super.setTextSize( 80 );
			//  set text color
			
			
			//  set background color	
			super.setBackgroundColor(Color.TRANSPARENT);
			//  set height of number
			super.setHeight( 150 );
			//  set width of number
			//  set horizontal and vertical alignment
			super.setGravity( Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL );
			//  set padding top
			super.setPadding( 0, 5, 0, 0 );
			// set id
			super.setId(buttonId);
			
			super.setFocusable( true );
			
			super.setClickable(true);
					
			this.id = buttonId;
			
				if(id==5){
				TextView textviewvraag5 = (TextView) findViewById( id );
				textviewvraag5.setTextColor(getResources().getColor( R.color.Black));
				}
				if(id==4){
				TextView textviewvraag4 = (TextView) findViewById( id );	
				textviewvraag4.setTextColor(getResources().getColor( R.color.White));	
				}
				if(id==3){
				TextView textviewvraag3 = (TextView) findViewById( id );	
				textviewvraag3.setTextColor(getResources().getColor( R.color.White));	
				}
				if(id==2){
				TextView textviewvraag2 = (TextView) findViewById( id );	
				textviewvraag2.setTextColor(getResources().getColor( R.color.White));	
				}
				if(id==1){
				TextView textviewvraag1 = (TextView) findViewById( id );
				textviewvraag1.setTextColor(getResources().getColor( R.color.White));	
				}
				
				if(id==5){
				TextView textviewvraag5 = (TextView) findViewById( id );
				textviewvraag5.setWidth( 600 );
				}
				if(id==4){
				TextView textviewvraag4 = (TextView) findViewById( id );	
				textviewvraag4.setWidth( 150 );	
				}
				if(id==3){
				TextView textviewvraag3 = (TextView) findViewById( id );	
				textviewvraag3.setWidth( 150 );	
				}
				if(id==2){
				TextView textviewvraag2 = (TextView) findViewById( id );	
				textviewvraag2.setWidth( 150 );	
				}
				if(id==1){
				TextView textviewvraag1 = (TextView) findViewById( id );
				textviewvraag1.setWidth( 150 );	
				}
				
				
			
			addListenerOnButton();


		}
			
	    public Buttons( int buttonId, Context content, Typeface font, Point startPoint )
		{
	    	this( buttonId, content, font );	
			this.RLP = new RelativeLayout.LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT );
	    	this.startX = this.RLP.leftMargin = startPoint.x;
			this.startY = this.RLP.topMargin = startPoint.y;
		}
		public int getID()
		{
			return this.id;
		}
		
		public RelativeLayout.LayoutParams getRLP()
		{
			return this.RLP;
		}
			
		
	
		
	public void addListenerOnButton()
	{
		TextView textviewclick = (TextView) findViewById( id );

		textviewclick.setOnClickListener(new OnClickListener(){

		public void onClick(View arg0) {
			TextView textviewclick = (TextView) findViewById( id );
		
			
			if(textviewclick.getText().toString().equals("X") || textviewclick.getText().toString().equals("XC") || textviewclick.getText().toString().equals("XIV") || textviewclick.getText().toString().equals("II") || textviewclick.getText().toString().equals("C")) {
						if(id==1){
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
						Log.d("hoi", String.valueOf(id));
						}
						if(id==2){
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
						Log.d("hoi", String.valueOf(id));
						}
						if(id==3){
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
						Log.d("hoi", String.valueOf(id));
						}
						if(id==4){
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
						Log.d("hoi", String.valueOf(id));
						}
			}
			else{
					if(id==1){
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
					Log.d("hoi", String.valueOf(id));

					}
					if(id==2){
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
					Log.d("hoi", String.valueOf(id));
					}
					if(id==3){
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
					Log.d("hoi", String.valueOf(id));
					}
					if(id==4){
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
					Log.d("hoi", String.valueOf(id));
					}
			
			}
		}
		});
		
	}
		
		/**public void checkAnswer()
		{
	        RelativeLayout = (RelativeLayout) findViewById( R.id.RelativeLayout );
			// Kijkt of het aangedrukte knopje een goed of fout antwoord is, dit klopt nog niet, kan jij ff uitzoeken?
			if(answer == true)
			{
				//  correct answer was given
				good(RelativeLayout);
				Log.d("hoi", String.valueOf(id));


			}
			else {
				//  wrong answer was given
				wrong(RelativeLayout);
				Log.println(id, "yolo", String.valueOf(id));
			}
		}**/

	
		
}

