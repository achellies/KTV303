package com.ktv303.numeric;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;

public class OmzettenActivity extends Activity
{
	private ImageButton imageButtonGoBack;
	private int X;
	private int Y;
	
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
 
	}
    
    // events when touching the screen
    public boolean onTouchEvent(MotionEvent event)
    {
        int eventaction = event.getAction(); 
        
        X = (int) event.getX(); 
        Y = (int) event.getY();
        Button buttonDrag = (Button) findViewById( R.id.buttonDrag );
        LayoutParams layoutP = (LayoutParams) buttonDrag.getLayoutParams();
        
        switch (eventaction )
        { 
        	case MotionEvent.ACTION_DOWN:
        		// touch down so check if the finger is on a ball
        		
        		break;
        	case MotionEvent.ACTION_MOVE:   // touch drag with the ball
        		// move the balls the same as the finger
        		layoutP.height = Y;
        		layoutP.width = X;
        		buttonDrag.setLayoutParams( layoutP );
        		break;
        	case MotionEvent.ACTION_UP: 
        		// touch drop - just do things here after dropping
        		
        		break;
        }
        
        return true; 
    }
    
}