package com.example.gadsleaderboard.ui.LearningLeaders;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.gadsleaderboard.models.LearningLeader;
import com.example.gadsleaderboard.repository.LearningLeaderRepository;

import java.util.List;

public class LearningViewModel extends AndroidViewModel {

    MutableLiveData<List<LearningLeader>> mLearningLeader;

    LearningLeaderRepository mLearningLeaderRepository;

    public LearningViewModel(@NonNull Application application) {
        super(application);
        mLearningLeaderRepository = new LearningLeaderRepository();
        mLearningLeader = mLearningLeaderRepository.getLearningLeaders();
    }

    public MutableLiveData<List<LearningLeader>> getLearningLeader() {
        return mLearningLeader;
    }
}
