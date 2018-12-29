package com.grade.kit.widget.validator.rules;

import com.grade.kit.widget.validator.Rule;

import java.util.regex.Pattern;

/**
 * RegexRule : 正则效验
 * <p>
 * </> Created by ylwei on 2018/3/29.
 */
public class RegexRule implements Rule {
  private String regex;
  private String message;

  public RegexRule(String regex, String message) {
    this.regex = regex;
    this.message = message;
  }

  @Override
  public boolean validate(String value) {
    return Pattern.compile(regex).matcher(value).matches();
  }

  @Override
  public String getErrorMessage() {
    return message;
  }
}
