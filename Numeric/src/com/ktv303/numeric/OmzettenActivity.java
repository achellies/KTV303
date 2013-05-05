package com.ktv303.numeric;

import model.Number;
import android.app.Activity;
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

public class OmzettenActivity extends Activity
{
	private ImageView imageViewOmzettenBackground;
	private ImageView imageView1goed;
	private ImageView imageView2goed;
	private ImageView imageView3goed;
	private ImageView imageView4goed;
	private ImageView imageView1fout;
	private ImageView imageView2fout;
	private ImageView imageView3fout;
	private ImageView imageView4fout;
	
	private ImageButton imageButtonGoBack;
	private ImageButton imageButtonDoor1;
	private ImageButton imageButtonDoor2;
	private ImageButton imageButtonDoor3;
	private ImageButton imageButtonDoor4;
	

	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        setContentView( R.layout.activity_omzetten );
        
      
      
        addListenerOnButton();

    }
    
    public void addListenerOnButton()
    {
    	 
		imageButtonGoBack = (ImageButton) findViewById(R.id.imageButtonGoBack);
 
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
      
	
	}
    
    }