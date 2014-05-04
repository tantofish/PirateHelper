package wcm.tuwolf.piratehelper.view.choosingview;

import java.util.ArrayList;

import wcm.tuwolf.piratehelper.model.choosingview.Answer;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.widget.Button;
import android.widget.RelativeLayout;
import itri.u9lab.towolf.ratiofixer.RatioRelativeLayout;

public class GamingView extends RatioRelativeLayout{

	Context mContext;
	int nPlayers;
	ArrayList<Integer> mPeopleState;
	ArrayList<Button> playerButtonList;
	
	int btnR = 120;	// Button Radius
	int circleCenterX = 384;
	int circleCenterY = 615;
	
	Button showAnsBtn;
	
	public GamingView(Context context) {
		super(context);
		mContext = context;
		// TODO Auto-generated constructor stub
		
		
		//this.addView(new Button(mContext), btnR, btnR, btnR/2, btnR/2);
	}
	
	public void setPeopleState(ArrayList<Integer> st){
		mPeopleState = st;
		nPlayers = st.size();
	}
	
	public void locateButtons(){
		double dTheta = (2 * Math.PI ) / nPlayers;
		double radius = 300.f-10.f-btnR/2.f;

		for(int i = 0 ; i < nPlayers ; i++){
			Button btn = new Button(mContext);
			btn.setBackgroundColor(assignColor(mPeopleState.get(i)));
			//playerButtonList.add(btn);
			
			double theta = -Math.PI / 2 + i * dTheta; 
			int x = (int) (circleCenterX + radius*Math.cos(theta));
			int y = (int) (circleCenterY + radius*Math.sin(theta));
			
			this.addView(btn, btnR, btnR, x-btnR/2, y-btnR/2);
		}
		
		showAnsBtn = new Button(mContext);
		this.addView(showAnsBtn, 150, 150);
		
		
		
	}
	
	public int assignColor(int state){
		switch(state){
		case Answer.GOOD_PEOPLE:
			return Color.GREEN;
		case Answer.NORMAL_PEOPLE:
			return Color.YELLOW;
		case Answer.BAD_PEOPLE:
			return Color.RED;
		}
		return Color.MAGENTA;
	}
}

