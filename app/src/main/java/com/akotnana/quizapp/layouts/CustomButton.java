package com.akotnana.quizapp.layouts;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.akotnana.quizapp.R;

import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by anees on 2/7/2018.
 */

public class CustomButton extends RelativeLayout {

    FancyButton preClick;
    FancyButton postClick;

    public CustomButton(Context context) {
        super(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.preClick = (FancyButton) findViewById(R.id.pre_clicked);
        this.postClick = (FancyButton) findViewById(R.id.post_clicked);

        final FancyButton postButton = this.postClick;
        final FancyButton preButton = this.preClick;

        this.preClick.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    setSelected();
                }
                return true;
            }
        });

        this.postClick.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    setUnselected();
                }
                return true;
            }
        });
    }

    public void setText(String a) {
        this.preClick.setText(a);
        this.preClick.setCustomTextFont("Ubuntu-R");
        this.postClick.setText(a);
        this.preClick.setCustomTextFont("Ubuntu-R");
    }

    public void setUnselected() {
        if(this.postClick.getVisibility() == VISIBLE && this.postClick.getAlpha() == 1f) {
            this.preClick.setClickable(false);
            this.preClick.setClickable(false);
            this.preClick.setAlpha(0f);
            this.preClick.setVisibility(VISIBLE);
            this.preClick.animate().alpha(1f).setDuration(250).setStartDelay(125).setListener(null);
            final FancyButton postButton = this.postClick;
            final FancyButton preButton = this.preClick;
            this.postClick.animate().alpha(0f).setDuration(250).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    postButton.setVisibility(View.GONE);
                    preButton.setClickable(true);
                    postButton.setClickable(true);
                }
            });
            onViewTouchedListener.onViewTouched(false);
        }
    }

    public void setSelected() {
        if(this.preClick.getVisibility() == VISIBLE && this.preClick.getAlpha() == 1f) {
            this.postClick.setClickable(false);
            this.postClick.setClickable(false);
            this.postClick.setAlpha(0f);
            this.postClick.setVisibility(VISIBLE);
            this.postClick.animate().alpha(1f).setDuration(250).setStartDelay(125).setListener(null);
            final FancyButton postButton = this.postClick;
            final FancyButton preButton = this.preClick;
            this.preClick.animate().alpha(0f).setDuration(250).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    preButton.setVisibility(View.GONE);
                    postButton.setClickable(true);
                    preButton.setClickable(true);
                }
            });
            onViewTouchedListener.onViewTouched(true);
        }
    }

    private OnViewTouchedListener onViewTouchedListener;
    public interface OnViewTouchedListener {
        //true if clicked first time, false if clicked second time
        public void onViewTouched(boolean clicked);
    }

    public void setOnViewTouchedListener(OnViewTouchedListener listener) {
        onViewTouchedListener = listener;
    }

}
