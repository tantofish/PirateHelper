package wcm.tuwolf.piratehelper;

import itri.u9lab.towolf.ratiofixer.RatioRelativeLayout;
import android.R.string;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
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
	
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    RatioRelativeLayout mView = new RatioRelativeLayout(this);
	    mView.setBackgroundColor(Color.WHITE);

	    
	    TextView nPlayerText = new TextView(this);
	    TextView goodGuy = new TextView(this);
	    TextView BadGuy  = new TextView(this);
	    TextView newBie  = new TextView(this);
	    Button doneBt = new Button(this);
	    EditText goodGuySubjectEdTxt = new EditText(this);
	    EditText BadGuySubjectEdTxt  = new EditText(this);
	    EditText newBieSubjectEdTxt  = new EditText(this);
	    
	    
	    Spinner nPlayerSpinner = new Spinner(this);
	    mView.addView(nPlayerSpinner, 150, 100, 250, 170);
	    
	    nPlayerText.setText("人　　數:");
	    mView.addView(nPlayerText, 200, 100, 50, 200);
	    
	    goodGuy.setText("好人題目:");
	    mView.addView(goodGuy, 200, 100, 50, 400);
	    
	    mView.addView(goodGuySubjectEdTxt, 500, 100, 250, 380);
	    
	    
	    BadGuy.setText("壞人題目:");
	    mView.addView(BadGuy, 200, 100, 50, 600);
	    mView.addView(BadGuySubjectEdTxt, 500, 100, 250, 580);
	    
	    newBie.setText("菜鳥題目:");
	    mView.addView(newBie, 200, 100, 50, 800);
	    mView.addView(newBieSubjectEdTxt, 500, 100, 250, 780);
	    
	    doneBt.setText("Done");
	    mView.addView(doneBt, 200, 100, 550, 1080);
	    
	    
	    ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,new Integer[]{5,6,7,8,9,10});
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    nPlayerSpinner.setAdapter(adapter);
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
	    
	    //goodGuySubject.setOnEditorActionListener();
            
	   
	    doneBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent intent = new Intent();
				finish();
			}
		});
	    	
	    mView.setToContentView(this);

	}	
	

}
