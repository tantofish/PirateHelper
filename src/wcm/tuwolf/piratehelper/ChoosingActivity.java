package wcm.tuwolf.piratehelper;

import java.util.ArrayList;

import wcm.tuwolf.piratehelper.view.choosingview.ChoosingView;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ChoosingActivity extends Activity{
	
	ChoosingView mView;
	Button startBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		

		Bundle bundle = this.getIntent().getExtras();
		int nPlayers = bundle.getInt("Player_Number");
		String goodGuySubject = bundle.getString("GoodGuy_Subject");
		String badGuySubject = bundle.getString("BadGuy_Subject");
		String newBieSubject = bundle.getString("NewBie_Subject");
		
		
		
//	 int nPlayers = 5;	
//	 String goodGuySubject = "GoodGuy_Subject";
//		String badGuySubject = "BadGuy_Subject";
//		String newBieSubject = "NewBie_Subject";
		
		mView = new ChoosingView(this,nPlayers);
		mView.setAnswer(goodGuySubject, newBieSubject, badGuySubject);
		mView.setPeopleItemClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mView.setCurrentPeople(v.getId());
			}
		});
		
		
		startBtn = mView.mBV.startBtn;
		startBtn.setOnClickListener(new startBtnClickListener());
//		mView.setAnswerViewOkClickLsitener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		mView.setToContentView(this);
	}
	class startBtnClickListener implements View.OnClickListener{
		@Override
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(ChoosingActivity.this, GamingActivity.class);
			Bundle bundle = new Bundle();
			ArrayList<Integer> mPeopleState;
			mPeopleState = mView.mPeopleState;
			
			bundle.putIntArray("PEOPLE_STATE", convertIntegers(mPeopleState));
			intent.putExtras(bundle);
			startActivity(intent);
		}
	}
	public static int[] convertIntegers(ArrayList<Integer> integers)
	{
	    int[] ret = new int[integers.size()];
	    for (int i=0; i < ret.length; i++)
	    {
	        ret[i] = integers.get(i).intValue();
	    }
	    return ret;
	}
}


