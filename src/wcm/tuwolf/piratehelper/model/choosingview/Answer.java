package wcm.tuwolf.piratehelper.model.choosingview;

import android.graphics.Color;

public class Answer {

	public final static int GOOD_PEOPLE = 0;
	public final static int NORMAL_PEOPLE = 1;
	public final static int BAD_PEOPLE = 2;
	
	public String goodAnswer ="defaultGood";
	public String normalAnswer ="defaultNormal";
	public String badAnswer ="defaultBad";
	
	private final NeedPeopleNumberSet NeedPeopleNumberSet[] = {
		new NeedPeopleNumberSet(3, 1, 2),
		new NeedPeopleNumberSet(3, 1, 2),
		new NeedPeopleNumberSet(3, 1, 2),
		new NeedPeopleNumberSet(3, 1, 2),
		new NeedPeopleNumberSet(3, 1, 2),
		new NeedPeopleNumberSet(3, 1, 2),
		new NeedPeopleNumberSet(3, 1, 2),
		new NeedPeopleNumberSet(3, 1, 2),
		new NeedPeopleNumberSet(3, 1, 2),
		new NeedPeopleNumberSet(3, 1, 2)
	};
	
	NeedPeopleNumberSet mNeedPeopleNumberSet;
	//int mAnswer;
	
	public Answer(int peopleNumber)
	{
		mNeedPeopleNumberSet = getNeedPeopleNumber(peopleNumber);
		//mAnswer = a;
	}
	
	public int needGood()
	{
		return mNeedPeopleNumberSet.needGood;
	}
	public int needNormal()
	{
		return mNeedPeopleNumberSet.needNormal;
	}
	public int needBad()
	{
		return mNeedPeopleNumberSet.needBad;
	}
//	public int getValue()
//	{
//		return mAnswer;
//	}
//	
	public  NeedPeopleNumberSet getNeedPeopleNumber(int peopleNum)
	{
		return NeedPeopleNumberSet[peopleNum];
	}
	public String getAnswerString(int answer)
	{
		switch(answer)
		{
			case GOOD_PEOPLE:
				return goodAnswer;
			case NORMAL_PEOPLE:
				return normalAnswer;
			case BAD_PEOPLE:
				return badAnswer;
		
		}
		return null;
	}
	
	public void setAnswerString(String g,String n,String b)
	{
		goodAnswer = g;
		normalAnswer = n;
		badAnswer = b;
	}
	
	public class NeedPeopleNumberSet
	{
		public int needGood, needNormal, needBad;
		NeedPeopleNumberSet(int ng,int nn, int nb){
		
			needGood = ng;
			needNormal = nn;
			needBad = nb;
			
		}
	}
}
