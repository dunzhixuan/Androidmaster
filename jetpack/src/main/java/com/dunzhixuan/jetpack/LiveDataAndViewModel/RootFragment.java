package com.dunzhixuan.jetpack.LiveDataAndViewModel;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dunzhixuan.jetpack.R;

import static android.widget.Toast.LENGTH_SHORT;

public class RootFragment extends Fragment {

		ChildFragment1 fragment1;
		ChildFragment2 fragment2;
		FragmentTransaction fragmentTransaction;

		@Nullable
		@Override
		public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
				View view = inflater.inflate(R.layout.fragment_root, container, false);
				fragment1 = new ChildFragment1();
				fragment2 = new ChildFragment2();
				fragmentTransaction = getChildFragmentManager().beginTransaction();
				view.findViewById(R.id.btn_child1).setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View v) {
								getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment1).show(fragment1).commit();
						}
				});

				view.findViewById(R.id.btn_child2).setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View v) {
								getChildFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment2).show(fragment2).commit();
						}
				});

				return view;
		}

	public static RootFragment newInstance() {
		return new RootFragment();
	}
}
