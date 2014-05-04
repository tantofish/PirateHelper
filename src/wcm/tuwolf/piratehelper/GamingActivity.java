package wcm.tuwolf.piratehelper;

import java.util.ArrayList;
import java.util.Arrays;

import wcm.tuwolf.piratehelper.view.gamingactivity.GamingView;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class GamingActivity extends Activity{
	GamingView mView;
	ArrayList<Integer> mPeopleState;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mView = new GamingView(this);
		mView.setBackgroundColor(Color.WHITE);
		
		Bundle bundle = this.getIntent().getExtras();
		int[] intArray = bundle.getIntArray("PEOPLE_STATE");
		
		mPeopleState = IntArraytoArrayList(intArray);
		mView.setPeopleState(mPeopleState);
		mView.locateButtons();
		
		mView.setToContentView(this);
		//mView.showAnsBtn.setOnClickListener(new showAnswerBtnClickListener());
		mView.showAnsBtn.setOnTouchListener(new showAnswerBtnTouchListener());
	}
	
	public ArrayList<Integer> IntArraytoArrayList(int[] intArray){
		
		Integer[] integerArray = new Integer[intArray.length];
		int idx = 0;
		for( int intValue : intArray) {
		    integerArray[idx++] = intValue;
		}
		return new ArrayList<Integer>(Arrays.asList(integerArray));
	}
	

	class showAnswerBtnTouchListener implements View.OnTouchListener{
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			if (event.getAction() == MotionEvent.ACTION_DOWN ) {
				mView.setButtonAnswers();
                return true;
            }else if(event.getAction() == MotionEvent.ACTION_UP){
            	mView.setButtonQuestions();
            }

            
			
			return false;
		}
	}
	
}






