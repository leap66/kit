package com.grade.kit.widget.sweet;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.grade.kit.R;
import com.grade.kit.databinding.DialogSweetBinding;
import com.grade.kit.widget.sweet.widget.SweetClickListener;
import com.grade.kit.widget.sweet.widget.SweetInterface;
import com.grade.kit.widget.sweet.widget.SweetType;

/**
 * SweetDialog :
 * <p>
 * </> Created by ylwei on 2018/3/28.
 */
public class SweetDialog extends Dialog implements SweetInterface<SweetDialog> {
  private DialogSweetBinding binding;
  private SweetClickListener onCancelListener;
  private SweetClickListener onConfirmListener;
  private boolean auto;

  public SweetDialog(@NonNull Context context) {
    super(context, R.style.style_dialog);
    binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.dialog_sweet,
        null, false);
    binding.setPresenter(new Presenter());
    setCanceledOnTouchOutside(false);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(binding.getRoot());
    initComponent();
  }

  private void initComponent() {
    Window window = getWindow();
    if (window == null)
      return;
    WindowManager.LayoutParams lp = window.getAttributes();
    lp.width = getScreenWidth() * 3 / 4;
    window.setAttributes(lp);
  }

  public class Presenter {

    public void onCancel() {
      dismiss();
      if (onCancelListener != null)
        onCancelListener.onClick(SweetDialog.this);
    }

    public void onConfirm() {
      if (auto)
        dismiss();
      if (onConfirmListener != null)
        onConfirmListener.onClick(SweetDialog.this);
    }
  }

  @Override
  public SweetDialog setHead(String title) {
    binding.titleTv.setVisibility(title == null ? View.GONE : View.VISIBLE);
    binding.titleTv.setText(title);
    return this;
  }

  @Override
  public SweetDialog setContent(String content) {
    binding.contentTv.setVisibility(content == null ? View.GONE : View.VISIBLE);
    binding.contentTv.setText(content);
    return this;
  }

  @Override
  public SweetDialog setCancel(String content) {
    if (content == null) {
      binding.cancelBtn.setVisibility(View.GONE);
      binding.sweetLine.setVisibility(View.GONE);
    } else {
      binding.cancelBtn.setText(content);
    }
    return this;
  }

  @Override
  public SweetDialog setConfirm(String content) {
    if (content == null) {
      binding.confirmBtn.setVisibility(View.GONE);
      binding.sweetLine.setVisibility(View.GONE);
    } else {
      binding.confirmBtn.setText(content);
    }
    return this;
  }

  @Override
  public SweetDialog setOnCancelListener(SweetClickListener listener) {
    onCancelListener = listener;
    return this;
  }

  @Override
  public SweetDialog setOnConfirmListener(SweetClickListener listener) {
    onConfirmListener = listener;
    return this;
  }

  @Override
  public SweetDialog setEnableOnBack(boolean support) {
    setCancelable(support);
    return this;
  }

  @Override
  public SweetDialog setHead(int title) {
    setHead(getContext().getString(title));
    return this;
  }

  @Override
  public SweetDialog setContent(int content) {
    setContent(getContext().getString(content));
    return this;
  }

  @Override
  public SweetDialog setCancel(int content) {
    setCancel(getContext().getString(content));
    return this;
  }

  @Override
  public SweetDialog setConfirm(int content) {
    setConfirm(getContext().getString(content));
    return this;
  }

  @Override
  public SweetDialog setImageResId(int resId) {
    binding.customIv.setVisibility(resId == 0 ? View.GONE : View.VISIBLE);
    binding.customIv.setImageResource(resId);
    return this;
  }

  @Override
  public SweetDialog setType(SweetType type) {
    if (type != null) {
      binding.customIv.setVisibility(View.VISIBLE);
      switch (type) {
        case SUCCESS:
          binding.customIv.setImageResource(R.mipmap.ic_dialog_success);
          break;
        case FAILED:
          binding.customIv.setImageResource(R.mipmap.ic_dialog_failed);
          break;
        case WARNING:
          binding.customIv.setImageResource(R.mipmap.ic_dialog_warning);
          break;
      }
    }
    return this;
  }

  @Override
  public SweetDialog setAutoDismiss(boolean auto) {
    this.auto = auto;
    return this;
  }


  /**
   * 获取屏幕宽度
   */
  private int getScreenWidth() {
    DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
    return metrics.widthPixels;
  }
}
