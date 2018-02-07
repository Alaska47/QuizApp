package com.akotnana.quizapp.utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by anees on 2/6/2018.
 */

public class FontManager {
    Context context;
    public static Typeface typeFace;

    public FontManager(Context context) {
        this.context = context;
        this.typeFace = Typeface.createFromAsset(context.getAssets(),"fonts/Ubuntu-R.ttf");
    }

    public Typeface getTypeFace() {
        return this.typeFace;
    }
}
