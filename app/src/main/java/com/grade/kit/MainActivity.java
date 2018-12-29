package com.grade.kit;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.grade.kit.databinding.ActivityGradeBinding;
import com.grade.kit.util.DialogUtil;

public class MainActivity extends AppCompatActivity {
  private ActivityGradeBinding binding;
  private Context context;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    context = this;
    binding = DataBindingUtil.setContentView(this, R.layout.activity_grade);
    binding.hello.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        DialogUtil.getErrorDialog(context, "23425").show();
      }
    });
  }
}
