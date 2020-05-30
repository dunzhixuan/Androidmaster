package com.dunzhixuan.jetpack.LiveDataAndViewModel;

import androidx.lifecycle.Observer;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.dunzhixuan.jetpack.R;

public class ChildFragment2 extends Fragment {

	private MyNameViewModel myNameViewModel;
	TextView textView;
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.fragment_child2, container, false);
		textView = view.findViewById(R.id.txv_name);
		Log.e("ChildFragment","onCreateView");

		return view;
	}

	@Override
	public void onResume() {
		Log.e("ChildFragment","onResume");
		super.onResume();
		myNameViewModel = new ViewModelProvider(requireActivity(), new ViewModelProvider.NewInstanceFactory()).get(MyNameViewModel.class);
//		myNameViewModel = ViewModelProviders.of(requireActivity()).get(MyNameViewModel.class);

		myNameViewModel.getName().observe(getViewLifecycleOwner(), new Observer<String>() {
			@Override
			public void onChanged(@Nullable String name) {
				textView.setText(name);
			}
		});
	}
}
