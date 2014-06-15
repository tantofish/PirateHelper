package wcm.tuwolf.piratehelper;

import java.util.ArrayList;
import java.util.Arrays;

import wcm.tuwolf.piratehelper.view.gamingactivity.CircleView;
import wcm.tuwolf.piratehelper.view.gamingactivity.GamingView;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class GamingActivity extends Activity{
	GamingView gView;
	CircleView cView;
	ArrayList<Integer> mPeopleState;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		gView = new GamingView(this);
		gView.setBackgroundColor(Color.WHITE);
		cView = gView.getCircleView();
		
		//Handling parameters transfer
		Bundle bundle = this.getIntent().getExtras();
		int[] intArray = bundle.getIntArray("PEOPLE_STATE");
		mPeopleState = IntArraytoArrayList(intArray);
		cView.setPeopleState(mPeopleState);
		cView.locateButtons();
		
		gView.setToContentView(this);
		gView.showAnsBtn.setOnTouchListener(new showAnswerBtnTouchListener());
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
				cView.setButtonAnswers();
                return true;
            }else if(event.getAction() == MotionEvent.ACTION_UP){
            	cView.setButtonQuestions();
            	return true;
            }
			return false;
		}
	}
	
}






