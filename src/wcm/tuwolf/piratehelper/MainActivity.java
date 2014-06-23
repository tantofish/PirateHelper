package wcm.tuwolf.piratehelper;

import itri.u9lab.towolf.ratiofixer.RatioFixer;
import itri.u9lab.towolf.ratiofixer.RatioRelativeLayout;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    RatioRelativeLayout mView = new RatioRelativeLayout(this);
	    
	    //cyy setting global ratio fixer
	    RatioFixer.setGlobalRatioFixer(mView.getRatioFixer());
	    mView.setBackgroundResource(R.drawable.main_bg);
	    
	    
	    // Is there anyway that I don't have to set start_btn as a "final" Button?
	    // (when I have to use it in the onTouch function)
	    final Button start_btn = new Button(this);
	    start_btn.setBackgroundResource(R.drawable.start_btn);
	    mView.addView(start_btn, 300, 120, 234, 900);

	    
	    // Change activity to Subject Activity
	    start_btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(v.getContext(), SubjectActivity.class);
				startActivity(intent);
			}
		});
	    	
//	    Button bt2 = new Button(this);
//	    bt2.setText("Choosing");
//	    bt2.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				Intent intent = new Intent(MainActivity.this, ChoosingActivity.class);
//				startActivity(intent);
//			}
//		});
//	    mView.addView(bt2,300,100,234,200);
//	    
//	    Button bt3 = new Button(this);
//	    bt3.setText("Gaming");
//	    bt3.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				Intent intent = new Intent(MainActivity.this, GamingActivity.class);
//				startActivity(intent);
//			}
//		});
//	    mView.addView(bt3,300,100,234,350);
	    

	    
	    mView.setToContentView(this);
	}	
}
