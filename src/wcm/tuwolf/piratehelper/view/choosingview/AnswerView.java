package wcm.tuwolf.piratehelper.view.choosingview;

import itri.u9lab.towolf.ratiofixer.RatioFixer;
import wcm.tuwolf.piratehelper.R;
import wcm.tuwolf.piratehelper.model.choosingview.Answer;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AnswerView extends RelativeLayout{

	RatioFixer mRF;
	Answer mAnswer;
	int answer;
	TextView answerText;
	Button okBtn;
	
	public AnswerView(Context context, Answer gameAnswer) {
		super(context);
		mRF = RatioFixer.getGlobalRatioFixer();
		this.setBackgroundResource(R.drawable.main_bg);
		answerText = new TextView(context);
		
		// It seems that set gravity to center should put the text on the center of the TextView,
		// But it doesn't work...
		answerText.setGravity(CENTER_HORIZONTAL);
		this.addView(answerText,mRF.getLayoutParam(768, 200, 0, 400));
		okBtn = new Button(context);
		okBtn.setBackgroundResource(R.drawable.ok_btn);
		this.addView(okBtn,mRF.getLayoutParam(300, 150, 234, 900));
		okBtn.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction() == MotionEvent.ACTION_DOWN){
					okBtn.setBackgroundResource(R.drawable.ok_btn_pressed);
				}else if(event.getAction() == MotionEvent.ACTION_UP){
					okBtn.setBackgroundResource(R.drawable.ok_btn);
				}
				return false;
			}
		});
		mAnswer = gameAnswer;
		
	}
	
	public void setAnswerText(int a)
	{
		answer = a;
		answerText.setText(mAnswer.getAnswerString(a));
		answerText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
	}


	public void setOkClickListener(OnClickListener l)
	{
		okBtn.setOnClickListener(l);
	}
}
