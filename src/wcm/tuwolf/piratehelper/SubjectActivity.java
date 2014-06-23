package wcm.tuwolf.piratehelper;

import itri.u9lab.towolf.ratiofixer.RatioRelativeLayout;
import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SubjectActivity extends Activity{
	static Integer nPlayers;
	static string goodGuySubject;
	static string badGuySubject;
	static string newBieSubject;
	
	
	TextView nPlayerText;
	TextView goodGuy;
	TextView badGuy;
	TextView newBie;
	Button nextBtn;
	EditText goodGuySubjectEdTxt;
	EditText badGuySubjectEdTxt;
	EditText newBieSubjectEdTxt;
	Editable newBieText;
	Editable goodGuyText;
	Editable badGuyText;
	Spinner nPlayerSpinner;
	
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    RatioRelativeLayout mView = new RatioRelativeLayout(this);
	    mView.setBackgroundResource(R.drawable.main_bg);

	    
	    nPlayerText = new TextView(this);
	    goodGuy = new TextView(this);
	    badGuy  = new TextView(this);
	    newBie  = new TextView(this);
	    nextBtn = new Button(this);
	    goodGuySubjectEdTxt = new EditText(this);
	    badGuySubjectEdTxt  = new EditText(this);
	    newBieSubjectEdTxt  = new EditText(this);
	    nPlayerSpinner = new Spinner(this);
	    
    
	   
	    setFormats(mView);
	    addListeners(mView);

	   	
	    mView.setToContentView(this);

	}
	public void setFormats(RatioRelativeLayout mView){
		
		goodGuySubjectEdTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
	    badGuySubjectEdTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
	    newBieSubjectEdTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
	    
	    mView.addView(nPlayerSpinner, 150, 100, 250, 260);
	    ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,new Integer[]{5,6,7,8,9,10});
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    nPlayerSpinner.setAdapter(adapter);
	    
	    
	    nPlayerText.setText("人數:");
	    nPlayerText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
	    nPlayerText.setTypeface(Typeface.DEFAULT_BOLD);
	    mView.addView(nPlayerText, 200, 100, 50, 260);
	    
	    goodGuy.setText("好人:");
	    goodGuy.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
	    goodGuy.setTypeface(Typeface.DEFAULT_BOLD);
	    mView.addView(goodGuy, 200, 100, 50, 440);
	    mView.addView(goodGuySubjectEdTxt, 500, 100, 250, 450);
	    goodGuySubjectEdTxt.setText("Ex:蘋果");
	    //goodGuySubjectEdTxt.setHint("例：蘋果");
	    
	    badGuy.setText("壞人:");
	    badGuy.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
	    badGuy.setTypeface(Typeface.DEFAULT_BOLD);
	    mView.addView(badGuy, 200, 100, 50, 620);
	    mView.addView(badGuySubjectEdTxt, 500, 100, 250, 630);
	    badGuySubjectEdTxt.setText("Ex:一種水果");
	    //badGuySubjectEdTxt.setHint("例：一種水果");
	    
	    newBie.setText("菜鳥:");
	    newBie.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
	    newBie.setTypeface(Typeface.DEFAULT_BOLD);
	    mView.addView(newBie, 200, 100, 50, 800);
	    mView.addView(newBieSubjectEdTxt, 500, 100, 250, 810);
	    newBieSubjectEdTxt.setText("例：香蕉");
	    //newBieSubjectEdTxt.setHint("例：香蕉");
	    
	    nextBtn.setBackgroundResource(R.drawable.next_btn);
	    mView.addView(nextBtn, 200, 100, 284, 1050);
	}
	public void addListeners(RatioRelativeLayout mView){
		nextBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				newBieText  = newBieSubjectEdTxt.getText();
				goodGuyText = goodGuySubjectEdTxt.getText();
				badGuyText  = badGuySubjectEdTxt.getText();

				Intent intent = new Intent();
				intent.setClass(SubjectActivity.this, ChoosingActivity.class);
				Bundle bundle = new Bundle();

				bundle.putString("GoodGuy_Subject", goodGuyText.toString());
				bundle.putString("BadGuy_Subject" , badGuyText.toString());
				bundle.putString("NewBie_Subject", newBieText.toString());
				bundle.putInt("Player_Number", nPlayers);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
	    nextBtn.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction() == MotionEvent.ACTION_DOWN){
					nextBtn.setBackgroundResource(R.drawable.next_btn_pressed);
				}else if(event.getAction() == MotionEvent.ACTION_UP){
					nextBtn.setBackgroundResource(R.drawable.next_btn);
				}
				// TODO Auto-generated method stub
				return false;
			}
		});
	    
	    
	    
	    nPlayerSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
				// TODO Auto-generated method stub
				SubjectActivity.nPlayers = (Integer) adapterView.getSelectedItem();
				//Log.d("QQ", SubjectActivity.nPlayers.toString());
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				//Toast.makeText(SubjectActivity.this, "not selected", Toast.LENGTH_LONG).show();
			}
	    	
	    });
	    
	    OnKeyListener kl = new OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER))   
	            {  
					InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(goodGuySubjectEdTxt.getWindowToken(), 0);
					return true;
	            }else{
	            	return false;
	            }
				
			}
		};
		
	    goodGuySubjectEdTxt.setOnKeyListener(kl);
	    badGuySubjectEdTxt.setOnKeyListener(kl);
	    newBieSubjectEdTxt.setOnKeyListener(kl);
	}
	

}
