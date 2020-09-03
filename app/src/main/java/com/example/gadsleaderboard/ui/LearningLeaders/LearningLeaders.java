package com.example.gadsleaderboard.ui.LearningLeaders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.adapters.LearningLeaderAdapter;
import com.example.gadsleaderboard.models.LearningLeader;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class LearningLeaders extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private LearningViewModel mLearningViewModel;
    private List<LearningLeader> mLearningLeaders;
    private LearningLeaderAdapter mLearningLeaderAdapter;

    public static LearningLeaders newInstance(int index) {
        LearningLeaders fragment = new LearningLeaders();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mLearningLeaders = new ArrayList<>();
        RecyclerView recyclerView = root.findViewById(R.id.rv_learning_leader);
        mLearningLeaderAdapter = new LearningLeaderAdapter(getContext(), mLearningLeaders);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mLearningLeaderAdapter);

        mLearningViewModel = ViewModelProviders.of(this).get(LearningViewModel.class);

        mLearningViewModel.getLearningLeader()
                .observe(getViewLifecycleOwner(), new Observer<List<LearningLeader>>() {
                    @Override
                    public void onChanged(List<LearningLeader> learningLeaders) {
                        mLearningLeaders = learningLeaders;
                        mLearningLeaderAdapter.setLearningLeader(mLearningLeaders);
                    }
                });

        return root;
    }
}