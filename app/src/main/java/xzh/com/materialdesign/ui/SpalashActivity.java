package xzh.com.materialdesign.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import xzh.com.materialdesign.R;
import xzh.com.materialdesign.utils.UIHelper;

/**
 * Created by xiangzhihong on 2016/3/2 on 12:21.
 */
public class SpalashActivity extends AppCompatActivity {
    @InjectView(R.id.spalash_image)
    ImageView spalashImage;

    private Context mContext;
    private Animation mFadeIn;
    private Animation mFadeInScale;
    private Animation mFadeOut;
    private Drawable mPicture;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalash);
        ButterKnife.inject(this);
        mContext = SpalashActivity.this;
        init();
    }

    private void init() {
        initAnimation();
        initBg();
        initAnimationLisener();
        //默认启动渐变动画
        spalashImage.startAnimation(mFadeIn);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void initBg() {
        mPicture = getResources().getDrawable(R.drawable.spalash_bg);
        spalashImage.setImageDrawable(mPicture);

    }

    private void initAnimation() {
        mFadeIn = AnimationUtils.loadAnimation(mContext,
                R.anim.spalash_fade_in);
        mFadeIn.setDuration(1000);
        mFadeInScale = AnimationUtils.loadAnimation(mContext,
                R.anim.spalash_fade_in_scale);
        mFadeInScale.setDuration(6000);
        mFadeOut = AnimationUtils.loadAnimation(mContext,
                R.anim.spalash_fade_out);
        mFadeOut.setDuration(1000);
    }

    /**
     * 渐变动画-->放大动画-->渐隐动画
     */
    private void initAnimationLisener() {
        mFadeIn.setAnimationListener(new AnimationListener() {

            public void onAnimationStart(Animation animation) {

            }

            public void onAnimationRepeat(Animation animation) {

            }

            public void onAnimationEnd(Animation animation) {
                spalashImage.startAnimation(mFadeInScale);
            }
        });
        mFadeInScale.setAnimationListener(new AnimationListener() {

            public void onAnimationStart(Animation animation) {

            }

            public void onAnimationRepeat(Animation animation) {

            }

            public void onAnimationEnd(Animation animation) {
                spalashImage.startAnimation(mFadeOut);
            }
        });
        mFadeOut.setAnimationListener(new AnimationListener() {

            public void onAnimationStart(Animation animation) {

            }

            public void onAnimationRepeat(Animation animation) {

            }

            public void onAnimationEnd(Animation animation) {
                UIHelper.openClass(mContext,MainActivity.class);
            }
        });
    }

}
