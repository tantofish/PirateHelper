package wcm.tuwolf.piratehelper;

import java.util.ArrayList;
import java.util.Arrays;

import wcm.tuwolf.piratehelper.model.choosingview.Answer;
import wcm.tuwolf.piratehelper.view.gamingactivity.CircleView;
import wcm.tuwolf.piratehelper.view.gamingactivity.GamingView;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;


public class GamingActivity extends Activity{
	GamingView gView;
	CircleView cView;
	ArrayList<Integer> mPeopleState;
	Answer mAnswer;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		gView = new GamingView(this);
		mAnswer = new Answer(5);	// just for argument passing, that 5 means nothing;
		gView.setBackgroundColor(Color.BLACK);
		cView = gView.getCircleView();
		
		//Handling parameters transfer
		Bundle bundle = this.getIntent().getExtras();
		int[] intArray = bundle.getIntArray("PEOPLE_STATE");
		mPeopleState = IntArraytoArrayList(intArray);
		cView.setPeopleState(mPeopleState);
		cView.locateButtons();
		
		gView.setToContentView(this);
		//gView.showAnsBtn.setOnTouchListener(new showAnswerBtnTouchListener());
		
		gView.goodAns_tv.append(mAnswer.getAnswerString(mAnswer.GOOD_PEOPLE));
		gView.badAns_tv.append(mAnswer.getAnswerString(mAnswer.BAD_PEOPLE));
		gView.noobAns_tv.append(mAnswer.getAnswerString(mAnswer.NORMAL_PEOPLE));
		
	}
	
	public ArrayList<Integer> IntArraytoArrayList(int[] intArray){
		
		Integer[] integerArray = new Integer[intArray.length];
		int idx = 0;
		for( int intValue : intArray) {
		    integerArray[idx++] = intValue;
		}
		return new ArrayList<Integer>(Arrays.asList(integerArray));
	}
	

	
}






