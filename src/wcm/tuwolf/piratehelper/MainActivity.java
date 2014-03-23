package wcm.tuwolf.piratehelper;

import itri.u9lab.towolf.ratiofixer.RatioFixer;
import itri.u9lab.towolf.ratiofixer.RatioRelativeLayout;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;


public class MainActivity extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    RatioRelativeLayout mView = new RatioRelativeLayout(this);
	    
	    //cyy setting global ratio fixer
	    RatioFixer.setGlobalRatioFixer(mView.getRatioFixer());
	    mView.setBackgroundColor(Color.WHITE);

	    Button bt1 = new Button(this);
	    bt1.setText("我換");
	    
	    //add bt1 to mView at (0,0) with width = 200 and height = 300
	    mView.addView(bt1, 300, 100, 234, 500);

	    //TextView tv1 = new TextView(this);
	    //tv1.setText("Hello World");
	    //tv1.setBackgroundColor(Color.CYAN);

	    //add tv1 to mView at (300,400) with wrap_content width and height
	    //mView.addView(tv1, RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT, 300, 400);
	    bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(v.getContext(), SubjectActivity.class);
				startActivity(intent);
			}
		});
	    	
	    Button bt2 = new Button(this);
	    bt2.setText("choosing activity");
	    bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, ChoosingActivity.class);
				startActivity(intent);
			}
		});
	    mView.addView(bt2,300,100,234,200);
	    
	    mView.setToContentView(this);

	}	
	
}
