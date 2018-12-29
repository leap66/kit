package com.grade.kit.widget.smartrefresh.base.support.impl;

import com.grade.kit.widget.smartrefresh.base.layout.PullRefreshLayout;

public interface Loadable {

  void setPullRefreshLayout(PullRefreshLayout refreshLayout);

  boolean onScroll(float y);

  void onScrollChange(int state);

  boolean onStartFling(float offsetTop);

  void startLoad();

  void stopLoad();
}
