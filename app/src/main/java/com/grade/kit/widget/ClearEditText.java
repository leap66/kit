package com.grade.kit.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.grade.kit.R;
import com.grade.kit.listener.OnTextChangedListener;

/**
 * ClearEditText : 统一输入框控件
 * <p>
 * </> Created by ylwei on 2018/2/24.
 */
public class ClearEditText extends AppCompatEditText {
  private Drawable clearIcon;

  public ClearEditText(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  private void init() {
    setSelectAllOnFocus(true);
    setClearIcon(R.mipmap.ic_clear);
    addTextChangedListener(new OnTextChangedListener() {
      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        updateClearIcon(!empty(s.toString()) && hasFocus());
      }
    });
  }

  @Override
  protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
    super.onFocusChanged(focused, direction, previouslyFocusedRect);
    boolean empty = empty(String.valueOf(getText()));
    updateClearIcon(focused && !empty);
  }

  @Override
  @SuppressLint("ClickableViewAccessibility")
  public boolean onTouchEvent(MotionEvent event) {
    if (event.getAction() == MotionEvent.ACTION_UP) {
      if (getCompoundDrawables()[2] != null) {
        if (event.getX() > (getWidth() - getTotalPaddingRight())
            && (event.getX() < ((getWidth() - getPaddingRight())))) {
          this.setText(null);
        }
      }
    }
    return super.onTouchEvent(event);
  }

  private void updateClearIcon(boolean show) {
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1],
        show ? clearIcon : null, getCompoundDrawables()[3]);
    setCompoundDrawablePadding(dip2px(5));
  }

  public void setClearIcon(int clearResId) {
    if (clearResId != 0)
      clearIcon = ContextCompat.getDrawable(getContext(), clearResId);
    if (clearIcon != null)
      clearIcon.setBounds(0, 0, clearIcon.getIntrinsicWidth(), clearIcon.getIntrinsicHeight());
  }

  private int dip2px(float dpValue) {
    final float scale = getResources().getDisplayMetrics().density;
    return (int) (dpValue * scale + 0.5f);
  }

  private boolean empty(String object) {
    return null == object || "".equals(object);
  }
}
