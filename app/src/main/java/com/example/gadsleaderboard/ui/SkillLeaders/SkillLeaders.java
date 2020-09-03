package com.example.gadsleaderboard.ui.SkillLeaders;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.adapters.SkillLeaderAdapter;
import com.example.gadsleaderboard.models.SkillLeader;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class SkillLeaders extends Fragment {

    private SkillViewModel mSkillViewModel;
    private List<SkillLeader> mSkillLeaders;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skill, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rv_skillLeaders);
        final SkillLeaderAdapter skillLeaderAdapter = new SkillLeaderAdapter(getContext(), mSkillLeaders);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(skillLeaderAdapter);

        mSkillViewModel =  ViewModelProviders.of(this).get(SkillViewModel.class);
        mSkillViewModel.getSkillLeaderList()
                .observe(getViewLifecycleOwner(), new Observer<List<SkillLeader>>() {
                    @Override
                    public void onChanged(List<SkillLeader> skillLeaders) {
                        mSkillLeaders = skillLeaders;
                        skillLeaderAdapter.setSkillLeaders(mSkillLeaders);
                    }
                });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSkillLeaders = new ArrayList<>();
    }
}
