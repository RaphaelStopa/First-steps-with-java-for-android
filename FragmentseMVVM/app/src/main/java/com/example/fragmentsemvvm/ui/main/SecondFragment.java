package com.example.fragmentsemvvm.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.fragmentsemvvm.R;
import com.example.fragmentsemvvm.SecondViewModel;

public class SecondFragment extends Fragment {

    private SecondViewModel mViewModel;

    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    int clicado = 0;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity()).get(SecondViewModel.class);

        View root = inflater.inflate(R.layout.second_fragment, container, false);

        TextView textView = root.findViewById(R.id.textView);

        mViewModel.getText().observe(getViewLifecycleOwner(),
                new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        textView.setText(s);
                    }
                });

        Button button = root.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicado++;
                mViewModel.setText("Clicado:" +clicado);
            }
        });

        return root;
    }
}