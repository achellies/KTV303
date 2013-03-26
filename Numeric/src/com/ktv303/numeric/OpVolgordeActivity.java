package com.ktv303.numeric;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class OpVolgordeActivity extends Activity {
	
	private ImageButton imageButtonGoBack;
	
	@Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        setContentView( R.layout.activity_op_volgorde );
        
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
	
}
