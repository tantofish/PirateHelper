package wcm.tuwolf.piratehelper.view.gamingactivity;

import itri.u9lab.towolf.ratiofixer.RatioFixer;
import itri.u9lab.towolf.ratiofixer.RatioRelativeLayout;

import java.util.ArrayList;

import wcm.tuwolf.piratehelper.R;
import wcm.tuwolf.piratehelper.model.choosingview.Answer;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GamingView extends RatioRelativeLayout{

	Context mContext;
	public Button showAnsBtn;
	CircleView cView;
	
	public TextView goodAns_tv;
	public TextView badAns_tv;
	public TextView noobAns_tv;
	
	
	public GamingView(Context context) {
		super(context);
		mContext = context;
		
		//Circle View
		cView = new CircleView(context);
		
		goodAns_tv = new TextView(context);
		badAns_tv = new TextView(context);
		noobAns_tv = new TextView(context);
		
		
		//Show Answer Button
		showAnsBtn = new Button(mContext);
		showAnsBtn.setBackgroundResource(R.drawable.showans_btn);
		this.addView(showAnsBtn,300,150,768/2-150,1230-150-10);
		
		this.addView(cView, 768, 768, 0, 290);
		
		goodAns_tv.setText("好人：");
		goodAns_tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
		goodAns_tv.setTextColor(Color.WHITE);
		this.addView(goodAns_tv, 768, 90, 0, 0);
		badAns_tv.setText("壞人：");
		badAns_tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
		badAns_tv.setTextColor(Color.WHITE);
		this.addView(badAns_tv, 768, 90, 0, 100);
		noobAns_tv.setText("菜鳥：");
		noobAns_tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
		noobAns_tv.setTextColor(Color.WHITE);
		this.addView(noobAns_tv, 768, 90, 0, 200);
		HideAnswerText();
		
		
		showAnsBtn.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if (event.getAction() == MotionEvent.ACTION_DOWN ) {
					cView.setButtonAnswers();
					ShowAnswerText();
					showAnsBtn.setBackgroundResource(R.drawable.showans_btn_pressed);
	                return true;
	            }else if(event.getAction() == MotionEvent.ACTION_UP){
	            	cView.setButtonQuestions();
	            	HideAnswerText();
	            	showAnsBtn.setBackgroundResource(R.drawable.showans_btn);
	            	return true;
	            }
				return false;
			}
		});
	}
	
	public CircleView getCircleView(){
		return cView;
	}
	
	public void ShowAnswerText(){
		goodAns_tv.setVisibility(View.VISIBLE);
		badAns_tv.setVisibility(View.VISIBLE);
		noobAns_tv.setVisibility(View.VISIBLE);
	}
	public void HideAnswerText(){
		goodAns_tv.setVisibility(View.INVISIBLE);
		badAns_tv.setVisibility(View.INVISIBLE);
		noobAns_tv.setVisibility(View.INVISIBLE);
	}
	
	
}

