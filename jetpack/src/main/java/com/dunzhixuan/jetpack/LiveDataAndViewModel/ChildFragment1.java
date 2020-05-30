package com.dunzhixuan.jetpack.LiveDataAndViewModel;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dunzhixuan.jetpack.R;

import java.util.Objects;

public class ChildFragment1 extends Fragment {
  TextView textView;
  private MyNameViewModel myNameViewModel;

  @Nullable
  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_child1, container, false);

    textView = view.findViewById(R.id.textview);
//    myNameViewModel = new ViewModelProvider(this).get(MyNameViewModel.class);
    myNameViewModel = new ViewModelProvider(requireActivity()).get(MyNameViewModel.class);
//    myNameViewModel = new ViewModelProvider(getViewModelStore(), new ViewModelProvider.NewInstanceFactory()).get(MyNameViewModel.class);
//    myNameViewModel = ViewModelProviders.of(requireActivity()).get(MyNameViewModel.class);
//    myNameViewModel.init();
    myNameViewModel
        .getName()
        .observe(
            getViewLifecycleOwner(),
            new Observer<String>() {
              @Override
              public void onChanged(@Nullable String s) {
                textView.setText(s);
              }
            });
    myNameViewModel.updateName("孙悟空");

    view.findViewById(R.id.btn_click)
        .setOnClickListener(
            new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                myNameViewModel.updateName("沙悟净");
//                startActivity(new Intent(getContext(), SecondActivity.class));
              }
            });
    return view;
  }
}
