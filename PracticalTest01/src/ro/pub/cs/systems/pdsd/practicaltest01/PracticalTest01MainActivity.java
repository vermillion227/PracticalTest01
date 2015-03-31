package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;

public class PracticalTest01MainActivity extends Activity {

	
	boolean email_ok, phone_ok;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_main);
		
		final EditText email = (EditText)findViewById(R.id.email_et);
		final EditText phone = (EditText)findViewById(R.id.phone_et);
		
		final CheckBox chk_email = (CheckBox)findViewById(R.id.check_email);
		final CheckBox chk_phone = (CheckBox)findViewById(R.id.check_phone);
		
		if ((savedInstanceState != null) && (savedInstanceState.getString("email") != null)) {
		    email.setText(savedInstanceState.getString("email"));
		}
		
		if ((savedInstanceState != null) && (savedInstanceState.getString("phone") != null)) {
		    phone.setText(savedInstanceState.getString("phone"));
		}
		
		email.addTextChangedListener(new TextWatcher(){
			public void afterTextChanged(Editable s) {}
	        public void beforeTextChanged(CharSequence s, int start, int count, int after){}
	        public void onTextChanged(CharSequence s, int start, int before, int count){
	        	if (android.util.Patterns.EMAIL_ADDRESS.matcher(s).matches()) {
	        		chk_email.setSelected(true);
	        		email_ok = true;
	        	}
	        	email_ok = false;
	        }
		});
		
		phone.addTextChangedListener(new TextWatcher(){
			public void afterTextChanged(Editable s) {
				System.out.println("Pe aici");
	        	if (s.length() >= 10) {
	        		System.out.println("si pe aici");
	        		chk_phone.setSelected(true);
	        	}
	        }
	        public void beforeTextChanged(CharSequence s, int start, int count, int after){
	        	System.out.println("Pe aici");
	        	if (s.length() >= 10) {
	        		Log.d("dbg","si pe aici");
	        		chk_phone.setSelected(true);
	        	}
	        }
	        public void onTextChanged(CharSequence s, int start, int before, int count){
	        	System.out.println("Pe aici");
	        	if (s.length() >= 10) {
	        		Log.d("dbg","si pe aici");
	        		chk_phone.setSelected(true);
	        		phone_ok = true;
	        	}
	        	phone_ok = false;
	        }
		});
	}
	 
	  @Override
	  protected void onPause() {
	    super.onPause();
	    // ...
	  }

	  @Override
	  protected void onSaveInstanceState(Bundle savedInstanceState) {
	    super.onSaveInstanceState(savedInstanceState);
	    EditText email = (EditText)findViewById(R.id.email_et);
	    savedInstanceState.putString("email", email.getText().toString());
	    
	    EditText phone = (EditText)findViewById(R.id.phone_et);
	    savedInstanceState.putString("phone", phone.getText().toString());
	  }
	  
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_main, menu);
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
