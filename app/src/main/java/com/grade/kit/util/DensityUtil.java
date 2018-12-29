package com.grade.kit.util;

import android.content.Context;

/**
 * DensityUtil : 手机分辨率转换工具
 * <p>
 * </> Created by ylwei on 2018/2/26.
 */
public class DensityUtil {

  /**
   * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
   */
  public static int dip2px(Context context, float dpValue) {
    final float scale = context.getResources().getDisplayMetrics().density;
    return (int) (dpValue * scale + 0.5f);
  }

  private DensityUtil() {
    throw new UnsupportedOperationException("单位工具类不能初始化对象");
  }

}