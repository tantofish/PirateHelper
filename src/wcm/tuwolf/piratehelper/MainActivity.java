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
	    
	    // OnTouch Listener is implemented for start button image 
	    start_btn.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction() == MotionEvent.ACTION_DOWN){
					start_btn.setBackgroundResource(R.drawable.start_btn_pressed);
				}else if(event.getAction() == MotionEvent.ACTION_UP){
					start_btn.setBackgroundResource(R.drawable.start_btn);
				}
				// TODO Auto-generated method stub
				return false;
			}
		});
	    
	    final ImageView logo_iv = new ImageView(this);
	    logo_iv.setBackgroundResource(R.drawable.logo);
	    mView.addView(logo_iv, 600, 160, 50, 120);
	    
	    final Animation alphaAnim = new AlphaAnimation(0.4f, 1.0f);
	    alphaAnim.setDuration(500);
	    alphaAnim.setRepeatCount(Animation.INFINITE);
	    alphaAnim.setRepeatMode(Animation.REVERSE);
	    
	    final Animation scaleAnim = new ScaleAnimation( 1.1f, 0.9f, 0.9f, 1.2f, 300, 80);
	    scaleAnim.setDuration( 500 );
	    scaleAnim.setRepeatCount(Animation.INFINITE);
	    scaleAnim.setRepeatMode(Animation.REVERSE);
	    
	    
	    logo_iv.setOnTouchListener(new OnTouchListener() {
	    	int animSwitch = 1;
			@Override
			
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if(event.getAction() == MotionEvent.ACTION_DOWN){
					if(animSwitch == 1){
						logo_iv.startAnimation(scaleAnim);
						animSwitch = 0;
					}else if(animSwitch == 0){
						logo_iv.startAnimation(alphaAnim);
						animSwitch = 1;
					}
				}
				return false;
			}
		});
	    

	    
	    mView.setToContentView(this);
	}	
}
