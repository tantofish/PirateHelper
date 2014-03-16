package wcm.tuwolf.piratehelper.view.choosingview;

import java.util.ArrayList;

import itri.u9lab.towolf.ratiofixer.RatioFixer;
import itri.u9lab.towolf.ratiofixer.RatioRelativeLayout;
import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ChoosingView extends RatioRelativeLayout{

	RatioFixer mRF;
	
	Context mContext;
	CircleView mCV;
	BottomView mBV;
	public ChoosingView(Context context,int peopleNum) {
		super(context);
		// TODO Auto-generated constructor stub
		
		mRF = this.getRatioFixer();
		mContext = context;
		mCV = new CircleView(context);
		mCV.setPeopleNum(peopleNum);
		mBV = new BottomView(context);
		
		this.addView(mCV,768,615,0,0);
		this.addView(mBV);
		
		
	}

	
	public void setPeopleItemClickListener(OnClickListener listener)
	{
		mCV.setPeopleItemClickListener(listener);
	}
	
	public void setHighlightPeople(int n)
	{
		mCV.setHighlightPeople(n);
	}
	
	public void setRemainNumber(int good,int normal,int bad)
	{
		mBV.setRemainNumber(good, normal, bad);
	}
	
	class CircleView extends RelativeLayout
	{
		int currentHighlight = -1;
		ArrayList<Button> peopleItemList;
		public CircleView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			this.setBackgroundColor(Color.RED);
//			this.setLayoutParams(mRF.getLayoutParam(768, 615, 0, 0));
			peopleItemList = new ArrayList<Button>();
			
			
		}
		
		public void setPeopleNum(int n)
		{
			for(int i = 0;i<n;i++)
			{
				Button b = new Button(mContext);
				b.setId(i);
				b.setBackgroundColor(Color.BLUE);
				peopleItemList.add(b);
			}
			
			int w = 120;
			int h = 120;
			
			int d = 28;
			int floor = 1;
			for(int i = 0;i < peopleItemList.size();i++)
			{
				floor = i/5+1;
			    int woffset = (d*(i+1) + (w*i))%740;
				this.addView(peopleItemList.get(i),mRF.getLayoutParam(w,h,woffset,(h+d)*floor ));
			}
		}
		
		public void setHighlightPeople(int n)
		{
			for( int i = 0 ;i< peopleItemList.size();i++)
			{
				peopleItemList.get(i).setBackgroundColor(Color.BLUE);
			}
			currentHighlight = n;
			peopleItemList.get(n).setBackgroundColor(Color.YELLOW);
		
		}
		
		public void setPeopleItemClickListener(OnClickListener listener)
		{
			for(int i = 0 ;i< peopleItemList.size();i++)
			{
				peopleItemList.get(i).setOnClickListener(listener);
			}
		}
		

		
	}
	
	class BottomView extends RelativeLayout
	{
		Button goodManBtn,normalManBtn,badManBtn;
		TextView goodManText, normalManText, badManText;
		public BottomView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			this.setBackgroundColor(Color.GREEN);
			this.setLayoutParams(mRF.getLayoutParam(768, 615, 0, 615));
			
			int w =200 , h = 150 ,d = 42;
			goodManBtn = new Button(mContext);
			goodManBtn.setText("選好人");
			goodManBtn.setBackgroundColor(Color.CYAN);
			goodManText = new TextView(mContext);
			goodManText.setBackgroundColor(Color.DKGRAY);
			this.addView(goodManBtn,mRF.getLayoutParam(w, h, d, 100));
			this.addView(goodManText,mRF.getLayoutParam(w, h, d, 100 + h + d));
			
			normalManBtn = new Button(mContext);
			normalManBtn.setBackgroundColor(Color.CYAN);
			normalManBtn.setText("選菜鳥");
			normalManText = new TextView(mContext);
			normalManText.setBackgroundColor(Color.DKGRAY);
			this.addView(normalManBtn,mRF.getLayoutParam(w, h, d*2+w, 100));
			this.addView(normalManText,mRF.getLayoutParam(w, h, d*2+w, 100 + h + d));
			
			badManBtn = new Button(mContext);
			badManBtn.setBackgroundColor(Color.CYAN);
			badManBtn.setText("選壞人");
			badManText = new TextView(mContext);
			badManText.setBackgroundColor(Color.DKGRAY);
			this.addView(badManBtn,mRF.getLayoutParam(w, h, d*3+w*2, 100));
			this.addView(badManText,mRF.getLayoutParam(w, h, d*3+w*2, 100 + h + d));
			
		}
		
		public void setRemainNumber(int good,int normal, int bad)
		{
			goodManBtn.setText(Integer.toString(good));
			normalManBtn.setText(Integer.toString(normal));
			badManBtn.setText(Integer.toString(bad));
			
		}
	}
}
