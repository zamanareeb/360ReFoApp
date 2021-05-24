package com.example.a360refo.ui.body;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.a360refo.R;

public class BodyFragment extends Fragment {

    private BodyViewModel bodyViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bodyViewModel =
                new ViewModelProvider(this).get(BodyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_body, container, false);

        return root;
    }
}