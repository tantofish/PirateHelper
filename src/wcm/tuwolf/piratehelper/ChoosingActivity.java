package wcm.tuwolf.piratehelper;

import wcm.tuwolf.piratehelper.view.choosingview.ChoosingView;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class ChoosingActivity extends Activity{
	
	ChoosingView mView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		mView = new ChoosingView(this,15);

		mView.setPeopleItemClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mView.setHighlightPeople(v.getId());
			}
		});
		
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

}
