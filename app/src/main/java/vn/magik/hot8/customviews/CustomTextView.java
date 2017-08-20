package vn.magik.hot8.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import vn.magik.hot8.R;

/**
 * Created by DkDarkness on 6/27/2016.
 */
public class CustomTextView extends android.support.v7.widget.AppCompatTextView {

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);

    }

    public CustomTextView(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/Trebuchet.ttf"), getTypeface().getStyle());
        }
    }
}
