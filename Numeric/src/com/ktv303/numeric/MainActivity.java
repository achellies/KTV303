package com.ktv303.numeric;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity
{
	
	ImageButton imageButton;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addListenerOnButton();
    }
    
    public void addListenerOnButton()
    {
    	 
		imageButton = (ImageButton) findViewById(R.id.imageButtonMenuOmzetten);
 
		imageButton.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View arg0)
			{
				Intent omzettenScreen = new Intent( getApplicationContext(), OmzettenActivity.class );
				startActivity( omzettenScreen );
			}
			
		});
		
	}
    
}
