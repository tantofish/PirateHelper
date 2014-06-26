package wcm.tuwolf.piratehelper.view.gamingactivity;

import java.util.ArrayList;

import wcm.tuwolf.piratehelper.R;
import wcm.tuwolf.piratehelper.model.choosingview.Answer;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;
import itri.u9lab.towolf.ratiofixer.RatioFixer;
import itri.u9lab.towolf.ratiofixer.RatioRelativeLayout;


public class CircleView extends RelativeLayout{

	Context mContext;
	
	int nPlayers;
	ArrayList<Integer> mPeopleState;
	ArrayList<Button> playerButtonList;
	
	
	//Player Circle Attributes & Parameters
	int btnW;	// Button Width
	int btnH;	// Button Height
	int circleCenterX;
	int circleCenterY;
	double circleRadius;
	ViewGroup.LayoutParams mLP;
	
	
	public CircleView(Context context) {
		super(context);
		mContext = context;
		playerButtonList = new ArrayList<Button>();
		mLP = this.getLayoutParams();
		this.setBackgroundResource(R.drawable.main_bg);
	}

	
	public void locateButtons(){
		
		RatioFixer rf = RatioFixer.getGlobalRatioFixer();
		
		btnW = 128;	// Button Width
		btnH = 128;	// Button Height
		
		circleCenterX = 384;
		circleCenterY = 384;
		
		
		
		circleRadius =290-btnW/2.f;
		
		double dTheta = (2 * Math.PI ) / (double) nPlayers;
		

		for(int i = 0 ; i < nPlayers ; i++){
			Button btn = new Button(mContext);
			btn.setBackgroundResource(R.drawable.question);
			playerButtonList.add(btn);
			
			
			
			double theta = -Math.PI / 2 + i * dTheta; 
			int x = (int) (circleCenterX + circleRadius*Math.cos(theta));
			int y = (int) (circleCenterY + circleRadius*Math.sin(theta));
			
			
			this.addView(btn, rf.getLayoutParam(128, 128, x-btnW/2, y-btnH/2));
		
		}

	}
	
	
	//Interfaces
	public void setPeopleState(ArrayList<Integer> st){
		mPeopleState = st;
		nPlayers = st.size();
	}
	public void setButtonAnswers(){
		for(int i = 0 ; i < nPlayers ; i++){
			Button btn = playerButtonList.get(i);
			btn.setBackgroundResource(assignButtonImage(mPeopleState.get(i)));
		}
	}
	public void setButtonQuestions(){
		for(int i = 0 ; i < nPlayers ; i++){
			Button btn = playerButtonList.get(i);
			btn.setBackgroundResource(R.drawable.question);
		}
	}
	
	
	//
	int assignButtonImage(int state){
		switch(state){
		case Answer.GOOD_PEOPLE:
			return R.drawable.goodguy;
		case Answer.NORMAL_PEOPLE:
			return R.drawable.newbie;
		case Answer.BAD_PEOPLE:
			return R.drawable.badguy;
		}
		return Color.MAGENTA;
	}
	
}
