package net.s3gfault.capp.ide;

import jackpal.androidterm.emulatorview.EmulatorView;
import android.view.inputmethod.InputMethodManager;
import jackpal.androidterm.emulatorview.TermSession;
import android.util.AttributeSet;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

public class TermView extends EmulatorView
{
	public TermView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TermView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public TermView(Context context, TermSession session, DisplayMetrics metrics) {
        super(context, session, metrics);
		setTextSize(18);
    }

    public boolean onSingleTapUp(MotionEvent e) {
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 2);
        return super.onSingleTapUp(e);
    }
}
