package wcm.tuwolf.piratehelper.view.choosingview;

import itri.u9lab.towolf.ratiofixer.RatioFixer;
import itri.u9lab.towolf.ratiofixer.RatioRelativeLayout;

import java.util.ArrayList;

import wcm.tuwolf.piratehelper.model.choosingview.Answer;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ChoosingView extends RatioRelativeLayout {

	RatioFixer mRF;

	Context mContext;
	CircleView mCV;
	BottomView mBV;

	AnswerView mAV;

	String goodAnswer, normalAnswer, badAnswer;

	ArrayList<Integer> mPeopleState;

	public ChoosingView(Context context, int peopleNum) {
		super(context);
		// TODO Auto-generated constructor stub

		mRF = this.getRatioFixer();
		mPeopleState = new ArrayList<Integer>();
		mContext = context;
		mCV = new CircleView(context);
		mCV.setPeopleNum(peopleNum);
		mBV = new BottomView(context);

		this.addView(mCV, 768, 615, 0, 0);
		this.addView(mBV);

		mAV = new AnswerView(context);
		mAV.setVisibility(INVISIBLE);

		mAV.setOkClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mAV.setVisibility(INVISIBLE);
				mCV.decideCurrentPeople(mAV.answer);
			}
		});
		this.addView(mAV, 768, 1230, 0, 0);

	}

	public void setAnswer(String good, String normal, String bad) {
		goodAnswer = good;
		normalAnswer = normal;
		badAnswer = bad;
	}

	public void setAnswerViewOkClickLsitener(OnClickListener l) {
		mAV.setOkClickListener(l);
	}

	public void setPeopleItemClickListener(OnClickListener listener) {
		mCV.setPeopleItemClickListener(listener);
	}

	public void setHighlightPeople(int n) {
		mCV.setCurrentPeople(n);
	}

	public void setRemainNumber(int good, int normal, int bad) {
		mBV.setRemainNumber(good, normal, bad);
	}

	class CircleView extends RelativeLayout {
		int currentPeople = 0;
		ArrayList<Button> peopleItemList;

		public CircleView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			this.setBackgroundColor(Color.RED);
			// this.setLayoutParams(mRF.getLayoutParam(768, 615, 0, 0));

			peopleItemList = new ArrayList<Button>();

		}

		public void setPeopleNum(int n) {
			for (int i = 0; i < n; i++) {
				Button b = new Button(mContext);
				b.setId(i);
				b.setBackgroundColor(Color.BLUE);
				peopleItemList.add(b);
				mPeopleState.add(-1);
			}

			int w = 120;
			int h = 120;

			int d = 28;
			int floor = 1;
			for (int i = 0; i < peopleItemList.size(); i++) {
				floor = i / 5 + 1;
				int woffset = (d * (i + 1) + (w * i)) % 740;
				this.addView(peopleItemList.get(i),
						mRF.getLayoutParam(w, h, woffset, (h + d) * floor));
			}
		}

		public void setCurrentPeople(int n) {
			currentPeople = n;
			for (int i = 0; i < peopleItemList.size(); i++) {
				if (i == n)
					peopleItemList.get(i).setBackgroundColor(Color.MAGENTA);
				else if (mPeopleState.get(i) == Answer.GOOD_PEOPLE)
					peopleItemList.get(i).setBackgroundColor(Color.GREEN);
				else if (mPeopleState.get(i) == Answer.NORMAL_PEOPLE)
					peopleItemList.get(i).setBackgroundColor(Color.YELLOW);
				else if (mPeopleState.get(i) == Answer.BAD_PEOPLE)
					peopleItemList.get(i).setBackgroundColor(Color.RED);
				else
					peopleItemList.get(i).setBackgroundColor(Color.BLUE);
			}

			// cyy TODO use another arraylist to save the status

			// peopleItemList.get(currentPeople).setBackgroundColor(Color.BLUE);
			// currentPeople = n;
			// peopleItemList.get(n).setBackgroundColor(Color.MAGENTA);

		}

		public void decideCurrentPeople(Answer a) {
			// switch(a.getValue())
			// {
			// case Answer.GOOD_PEOPLE:
			// peopleItemList.get(currentPeople).setBackgroundColor(Color.GREEN);
			// break;
			// case Answer.NORMAL_PEOPLE:
			// peopleItemList.get(currentPeople).setBackgroundColor(Color.YELLOW);
			// break;
			// case Answer.BAD_PEOPLE:
			// peopleItemList.get(currentPeople).setBackgroundColor(Color.RED);
			// break;
			//
			// }
			mPeopleState.set(currentPeople, a.getValue());
			setCurrentPeople(++currentPeople % mPeopleState.size()) ;

		}

		public void setPeopleItemClickListener(OnClickListener listener) {
			for (int i = 0; i < peopleItemList.size(); i++) {
				peopleItemList.get(i).setOnClickListener(listener);
			}
		}

	}

	class BottomView extends RelativeLayout {
		Button goodManBtn, normalManBtn, badManBtn;
		TextView goodManText, normalManText, badManText;

		public BottomView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			this.setBackgroundColor(Color.GREEN);
			this.setLayoutParams(mRF.getLayoutParam(768, 615, 0, 615));

			int w = 200, h = 150, d = 42;
			goodManBtn = new Button(mContext);
			goodManBtn.setText("選好人");
			goodManBtn.setBackgroundColor(Color.CYAN);
			goodManBtn.setOnClickListener(new showAnswerViewListener(
					new Answer(Answer.GOOD_PEOPLE)));
			goodManText = new TextView(mContext);
			goodManText.setBackgroundColor(Color.DKGRAY);
			this.addView(goodManBtn, mRF.getLayoutParam(w, h, d, 100));
			this.addView(goodManText, mRF.getLayoutParam(w, h, d, 100 + h + d));

			normalManBtn = new Button(mContext);
			normalManBtn.setBackgroundColor(Color.CYAN);
			normalManBtn.setText("選菜鳥");
			normalManBtn.setOnClickListener(new showAnswerViewListener(
					new Answer(Answer.NORMAL_PEOPLE)));
			normalManText = new TextView(mContext);
			normalManText.setBackgroundColor(Color.DKGRAY);
			this.addView(normalManBtn, mRF.getLayoutParam(w, h, d * 2 + w, 100));
			this.addView(normalManText,
					mRF.getLayoutParam(w, h, d * 2 + w, 100 + h + d));

			badManBtn = new Button(mContext);
			badManBtn.setBackgroundColor(Color.CYAN);
			badManBtn.setText("選壞人");
			badManBtn.setOnClickListener(new showAnswerViewListener(new Answer(
					Answer.BAD_PEOPLE)));
			badManText = new TextView(mContext);
			badManText.setBackgroundColor(Color.DKGRAY);
			// badManBtn.setOnClickListener()
			this.addView(badManBtn,
					mRF.getLayoutParam(w, h, d * 3 + w * 2, 100));
			this.addView(badManText,
					mRF.getLayoutParam(w, h, d * 3 + w * 2, 100 + h + d));

		}

		public void setRemainNumber(int good, int normal, int bad) {
			goodManBtn.setText(Integer.toString(good));
			normalManBtn.setText(Integer.toString(normal));
			badManBtn.setText(Integer.toString(bad));

		}

		class showAnswerViewListener implements View.OnClickListener {
			Answer mAnswer;

			public showAnswerViewListener(Answer a) {
				// TODO Auto-generated constructor stub
				mAnswer = a;
			}

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mAV.setAnswer(mAnswer);
				mAV.setVisibility(VISIBLE);
			}

		} // end of showAnswerViewListener

	}// end of BottomView

}// end of ChoosingView
