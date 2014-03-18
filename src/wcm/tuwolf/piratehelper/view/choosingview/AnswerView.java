package wcm.tuwolf.piratehelper.view.choosingview;

import itri.u9lab.towolf.ratiofixer.RatioFixer;
import wcm.tuwolf.piratehelper.model.choosingview.Answer;
import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AnswerView extends RelativeLayout{

	RatioFixer mRF;
	Answer answer;
	TextView answerText;
	Button okBtn;
	
	public AnswerView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		mRF = RatioFixer.getGlobalRatioFixer();
		this.setBackgroundColor(Color.WHITE);
		answerText = new TextView(context);
		this.addView(answerText,mRF.getLayoutParam(300, 100, 234, 500));
		
		okBtn = new Button(context);
		this.addView(okBtn,mRF.getLayoutParam(300, 100, 234, 700));
		
	}
	
	public void setAnswer(Answer a)
	{
		answer = a;
		answerText.setText(a.toString());
	}


	public void setOkClickListener(OnClickListener l)
	{
		okBtn.setOnClickListener(l);
	}
}
