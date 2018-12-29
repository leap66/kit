package com.grade.kit.widget.validator.rules;

import android.widget.TextView;

import com.grade.kit.widget.validator.Rule;

/**
 * ConfirmationRule : 输入字段效验
 * <p>
 * </> Created by ylwei on 2018/3/29.
 */
public class ConfirmationRule implements Rule {
  private String message;
  private TextView field;

  public ConfirmationRule(TextView field, String message) {
    this.field = field;
    this.message = message;
  }

  @Override
  public boolean validate(String value) {
    return field.getText().toString().equals(value);
  }

  @Override
  public String getErrorMessage() {
    return message;
  }
}
