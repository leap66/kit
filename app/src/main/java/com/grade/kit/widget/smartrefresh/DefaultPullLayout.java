package com.grade.kit.widget.smartrefresh;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;

import com.grade.kit.widget.smartrefresh.base.support.impl.Pullable;

public class DefaultPullLayout extends NestedScrollView implements Pullable {
  public DefaultPullLayout(Context context) {
    super(context);
  }

  public DefaultPullLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public DefaultPullLayout(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  public boolean isGetBottom() {
    return false;
  }

  @Override
  public boolean isGetTop() {
    return true;
  }
}
