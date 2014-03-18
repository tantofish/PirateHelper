package wcm.tuwolf.piratehelper.model.choosingview;

import android.graphics.Color;

public class Answer {

	public final static int GOOD_PEOPLE = 0;
	public final static int NORMAL_PEOPLE = 1;
	public final static int BAD_PEOPLE = 2;
	
	public static String goodAnswer ="defaultGood";
	public static String normalAnswer ="defaultNormal";
	public static String badAnswer ="defaultBad";
	
	int mAnswer;
	
	public Answer(int a)
	{
		mAnswer = a;
	}
	
	public int getValue()
	{
		return mAnswer;
	}
	public String toString()
	{
		switch(mAnswer)
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
	
	static public void setAnswerString(String g,String n,String b)
	{
		goodAnswer = g;
		normalAnswer = n;
		badAnswer = b;
	}
}
