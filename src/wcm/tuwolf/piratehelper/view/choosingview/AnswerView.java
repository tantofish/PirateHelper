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
	Answer mAnswer;
	int answer;
	TextView answerText;
	Button okBtn;
	
	public AnswerView(Context context, Answer gameAnswer) {
		super(context);
		// TODO Auto-generated constructor stub
		mRF = RatioFixer.getGlobalRatioFixer();
		this.setBackgroundColor(Color.WHITE);
		answerText = new TextView(context);
		this.addView(answerText,mRF.getLayoutParam(300, 100, 234, 500));
		
		okBtn = new Button(context);
		this.addView(okBtn,mRF.getLayoutParam(300, 100, 234, 700));
		
		mAnswer = gameAnswer;
		
	}
	
	public void setAnswerText(int a)
	{
		answer = a;
		answerText.setText(mAnswer.getAnswerString(a));
	}


	public void setOkClickListener(OnClickListener l)
	{
		okBtn.setOnClickListener(l);
	}
}
