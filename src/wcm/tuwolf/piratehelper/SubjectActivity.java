package wcm.tuwolf.piratehelper;

import itri.u9lab.towolf.ratiofixer.RatioRelativeLayout;
import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
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
	TextView BadGuy;
	TextView newBie;
	Button doneBt;
	EditText goodGuySubjectEdTxt;
	EditText badGuySubjectEdTxt;
	EditText newBieSubjectEdTxt;
	Editable newBieText;
	Editable goodGuyText;
	Editable badGuyText;
	
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    RatioRelativeLayout mView = new RatioRelativeLayout(this);
	    mView.setBackgroundColor(Color.WHITE);

	    
	    nPlayerText = new TextView(this);
	    goodGuy = new TextView(this);
	    BadGuy  = new TextView(this);
	    newBie  = new TextView(this);
	    doneBt = new Button(this);
	    goodGuySubjectEdTxt = new EditText(this);
	    badGuySubjectEdTxt  = new EditText(this);
	    newBieSubjectEdTxt  = new EditText(this);
	    
	    
	    Spinner nPlayerSpinner = new Spinner(this);
	    mView.addView(nPlayerSpinner, 150, 100, 250, 170);
	    
	    nPlayerText.setText("人數:");
	    mView.addView(nPlayerText, 200, 100, 50, 200);
	    
	    goodGuy.setText("好人:");
	    mView.addView(goodGuy, 200, 100, 50, 400);
	    mView.addView(goodGuySubjectEdTxt, 500, 100, 250, 380);
	    goodGuySubjectEdTxt.setHint("Ex:蘋果");
	    
	    BadGuy.setText("壞人:");
	    mView.addView(BadGuy, 200, 100, 50, 600);
	    mView.addView(badGuySubjectEdTxt, 500, 100, 250, 580);
	    badGuySubjectEdTxt.setHint("Ex:一種水果");
	    
	    
	    newBie.setText("菜鳥:");
	    mView.addView(newBie, 200, 100, 50, 800);
	    mView.addView(newBieSubjectEdTxt, 500, 100, 250, 780);
	    newBieSubjectEdTxt.setHint("Ex:香蕉");
	    
	    doneBt.setText("Done");
	    mView.addView(doneBt, 200, 100, 550, 1080);
	    
	    
	    ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,new Integer[]{5,6,7,8,9,10});
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    nPlayerSpinner.setAdapter(adapter);
	    
	    
	    doneBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				newBieText  = newBieSubjectEdTxt.getText();
				goodGuyText = goodGuySubjectEdTxt.getText();
				badGuyText  = badGuySubjectEdTxt.getText();
				
				//Log.d("Answer1", newBieText.toString());
				//Log.d("Answer1", goodGuyText.toString());
				//Log.d("Answer1", badGuyText.toString());
				
				Intent intent = new Intent();
				intent.setClass(SubjectActivity.this, ChoosingActivity.class);
				Bundle bundle = new Bundle();

				bundle.putString("GoodGuy_Subject", goodGuyText.toString());
				bundle.putString("BadGuy_Subject" , badGuyText.toString());
				bundle.putString("New_Bie_Subject", newBieText.toString());
				bundle.putInt("Player_Number", nPlayers);
				
				intent.putExtras(bundle);
				startActivity(intent);
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
	    
            
	   	
	    mView.setToContentView(this);

	}	
	

}
