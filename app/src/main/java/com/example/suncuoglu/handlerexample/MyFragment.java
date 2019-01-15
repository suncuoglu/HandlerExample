package com.example.suncuoglu.handlerexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyFragment extends Fragment {
    TextView textView;
    String name;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        textView = view.findViewById(R.id.textView2);
        textView.setText(name);
        return view;
    }
    public void setText(String name) {
        name="Welcome Fragment";
        this.name = name;
    }

    public static MyFragment newInstance(String name) {
        MyFragment myFragment = new MyFragment();
        myFragment.setText(name);
        return myFragment;
    }
}
