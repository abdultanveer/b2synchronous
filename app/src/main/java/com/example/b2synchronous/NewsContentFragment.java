package com.example.b2synchronous;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

public class NewsContentFragment extends Fragment {


TextView tvContent;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_news_content, container,false);
        tvContent = view.findViewById(R.id.tvNewsContent);
        return view;
    }


    public void setHeadline(@NotNull String headline) {
        tvContent.setText(headline);
    }
}
