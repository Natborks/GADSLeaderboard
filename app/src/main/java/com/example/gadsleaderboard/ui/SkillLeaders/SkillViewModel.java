package com.example.gadsleaderboard.ui.SkillLeaders;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.gadsleaderboard.models.SkillLeader;
import com.example.gadsleaderboard.repository.SkillLeaderRepository;

import java.util.List;

public class SkillViewModel extends AndroidViewModel {
    SkillLeaderRepository mSkillLeaderRepository;
    MutableLiveData<List<SkillLeader>> mSkillLeaderList;


    public SkillViewModel(@NonNull Application application) {
        super(application);

        mSkillLeaderRepository = new SkillLeaderRepository();
        mSkillLeaderList = mSkillLeaderRepository.getSkillLeaders();
    }

    public  MutableLiveData<List<SkillLeader>> getSkillLeaderList(){
        return mSkillLeaderList;
    }
}