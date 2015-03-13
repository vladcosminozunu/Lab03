package com.example.phonedialer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class PhoneDialerActivity extends Activity {
	
	
	final protected int buttonIds[] = {
		R.id.button0,
		R.id.button1,
		R.id.button2,
		R.id.button3,
		R.id.button4,
		R.id.button5,
		R.id.button6,
		R.id.button7,
		R.id.button8,
		R.id.button9,
		R.id.button10,
		R.id.button11
	};

	final protected int imageButtonIds[]= {
			R.id.imageButton1,
			R.id.imageButton2,
			R.id.imageButton3
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);
        MyButtonListener mb = new MyButtonListener();
        for (int k=0; k<buttonIds.length; k++) {
        	Button b = (Button)findViewById(buttonIds[k]);
        	b.setOnClickListener(mb);
        }
        
        for(int k=0; k<imageButtonIds.length; k++){
        	ImageButton ib = (ImageButton) findViewById(imageButtonIds[k]);
        	ib.setOnClickListener(mb);
        }
        
        
    }
        protected class MyButtonListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(v instanceof Button){
				String value = ((Button)v).getText().toString();
				EditText edit = (EditText) findViewById(R.id.editText1);
				edit.setText(edit.getText().toString() + value);
			}
			else if(v instanceof ImageButton){
				
				// backspace
				if(v.getId() == R.id.imageButton1){
					EditText edit = (EditText) findViewById(R.id.editText1);
					String text = edit.getText().toString();
					if(!text.equals("")){
						text = text.substring(0, text.length() - 1);
					}
					edit.setText(text);
					
				}
				
				// call 
				else if(v.getId() == R.id.imageButton2){
					Intent intent = new Intent(Intent.ACTION_CALL);
					EditText edit = (EditText) findViewById(R.id.editText1);
					
					String phoneNumber = edit.getText().toString();
					intent.setData(Uri.parse("tel:"+ phoneNumber));
					startActivity(intent);
				}
				
				//hangup
				else if(v.getId() == R.id.imageButton3){
					finish();
				}
			}
		}
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.phone_dialer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
