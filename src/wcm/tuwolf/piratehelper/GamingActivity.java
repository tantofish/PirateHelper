package wcm.tuwolf.piratehelper;

import wcm.tuwolf.piratehelper.view.choosingview.GamingView;
import android.app.Activity;
import android.os.Bundle;

public class GamingActivity extends Activity{
	GamingView mView;
	protected void onCreate(Bundle savedInstanceState) {
		mView = new GamingView(this);
	}
}

