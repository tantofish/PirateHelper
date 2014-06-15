package wcm.tuwolf.piratehelper.view.gamingactivity;

import itri.u9lab.towolf.ratiofixer.RatioFixer;
import itri.u9lab.towolf.ratiofixer.RatioRelativeLayout;

import java.util.ArrayList;

import wcm.tuwolf.piratehelper.R;
import wcm.tuwolf.piratehelper.model.choosingview.Answer;
import android.content.Context;
import android.graphics.Color;
import android.widget.Button;

public class GamingView extends RatioRelativeLayout{

	Context mContext;
	public Button showAnsBtn;
	CircleView cView;
	
	public GamingView(Context context) {
		super(context);
		mContext = context;
		
		//Circle View
		cView = new CircleView(context);
		cView.setBackgroundColor(Color.DKGRAY);
		
		//Show Answer Button
		showAnsBtn = new Button(mContext);
		showAnsBtn.setText("Show Answer");
		this.addView(showAnsBtn,300,150,768/2-150,1230-150-10);
		
		this.addView(cView, 768, 768, 0, 290);
	}
	
	public CircleView getCircleView(){
		return cView;
	}
	
}

