package com.ktv303.numeric;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class OmzettenActivity extends Activity
{
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
        
        //Hier moeten de goeie en de foute antwoorden allebij op visible(0) gezet worden.
        //in de code hieronder worden een van de 2 visible gemaakt afhankelijk van het antwoord.
        
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
		
    
		//imageButtonDoor1 = (ImageButton) findViewById(R.id.imageButtonDoor1);
		
	    imageButtonDoor1.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0)
			{
				//Hierin switchen we tussen het dichte deurtje en het open deurtje
			}
		});
		
		//imageButtonDoor2 = (ImageButton) findViewById(R.id.imageButtonDoor2);
		
		imageButtonDoor2.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0)
			{
				//Hierin switchen we tussen het dichte deurtje en het open deurtje
			}
		});
		
		//imageButtonDoor3 = (ImageButton) findViewById(R.id.imageButtonDoor3);
		
		imageButtonDoor3.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0)
			{
				//Hierin switchen we tussen het dichte deurtje en het open deurtje
			}
		});
		
		//imageButtonDoor4 = (ImageButton) findViewById(R.id.imageButtonDoor4);
		
		imageButtonDoor4.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View agr0)
			{
				//Hierin switchen we tussen het dichte deurtje en het open deurtje
			}
		});
 
	}
    }