package model;

import com.ktv303.numeric.R;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class Buttons extends TextView {
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
	private int answer;
	private int id;

	
	
	
		public Buttons( int buttonId, Context content, Typeface font ){
			super( content );
			
			//  set font
			super.setTypeface( font );
			//  set text size
			super.setTextSize( 80 );
			//  set text color
			super.setTextColor( getResources().getColor( R.color.White ) );
			//  set background color
			super.setBackgroundColor(Color.TRANSPARENT);
			//  set height of number
			super.setHeight( 150 );
			//  set width of number
			super.setWidth( 150 );
			//  set horizontal and vertical alignment
			super.setGravity( Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL );
			//  set padding top
			super.setPadding( 0, 5, 0, 0 );
			
			super.setFocusable( true );
			
			super.setClickable(true);
			
			this.id = buttonId;
			
	        

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
		
		
		private void good(int id)
		// Kijkt welke knop ingedrukt is (weet niet of dit werkt) en stelt het bijbehorende hekje op groen
		{
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
				}
			
		}
		
		private void wrong(int id)
		// Kijkt welke knop ingedrukt is (weet niet of dit werkt) en stelt het bijbehorende hekje op rood
		{
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
				imageView1fout.setVisibility(ImageView.VISIBLE);
				imageView4goed = (ImageView) findViewById(R.id.imageView4goed);
				imageView4goed.setVisibility(ImageView.GONE);
				imageView3goed = (ImageView) findViewById(R.id.imageView3goed);
				imageView3goed.setVisibility(ImageView.GONE);
				imageView2goed = (ImageView) findViewById(R.id.imageView2goed);
				imageView2goed.setVisibility(ImageView.GONE);
				imageView1goed = (ImageView) findViewById(R.id.imageView1goed);
				imageView1goed.setVisibility(ImageView.GONE);
				}
			if(id==2){
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
				}
			if(id==3){
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
				}
			if(id==4){
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
				}
			
		}
		
		public void checkAnswer( int answer )
		{
			// Kijkt of het aangedrukte knopje een goed of fout antwoord is, dit klopt nog niet, kan jij ff uitzoeken?
			if( answer == 3)
			{
				//  correct answer was given
				this.good(id);
			} else {
				//  wrong answer was given, reset position
				this.wrong(id);
			}
		}
		
}

/**
// Bewaar deze shit ff zodat et niet nog is uitgeschreven hoeft te worden

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
					/
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
						}
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
					/
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
						}
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
				}
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
					}
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
				}
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
					}
				//Hierin switchen we tussen het dichte deurtje en het open deurtje
			}
		});
		**/




/**
<ImageButton
android:id="@+id/imageButtonDoor2"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_above="@+id/imageButtonGoBack"
android:layout_marginBottom="132dp"
android:layout_marginLeft="69dp"
android:layout_toRightOf="@+id/imageButtonDoor1"
android:background="@android:color/transparent"
android:contentDescription="@string/desc_button_door_2"
android:minHeight="200dp"
android:minWidth="200dp" />

<ImageButton
android:id="@+id/imageButtonDoor1"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_alignLeft="@+id/imageButtonGoBack"
android:layout_alignTop="@+id/imageButtonDoor2"
android:background="@android:color/transparent"
android:contentDescription="@string/desc_button_door_1"
android:minHeight="200dp"
android:minWidth="200dp" />

<ImageButton
android:id="@+id/imageButtonDoor3"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_alignTop="@+id/imageButtonDoor2"
android:layout_marginRight="64dp"
android:layout_toLeftOf="@+id/imageButtonDoor4"
android:background="@android:color/transparent"
android:contentDescription="@string/desc_button_door_3"
android:minHeight="200dp"
android:minWidth="200dp" />

<ImageButton
android:id="@+id/imageButtonDoor4"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_alignParentRight="true"
android:layout_alignTop="@+id/imageButtonDoor3"
android:layout_marginRight="34dp"
android:background="@android:color/transparent"
android:contentDescription="@string/desc_button_door_4"
android:minHeight="200dp"
android:minWidth="200dp" />
**/