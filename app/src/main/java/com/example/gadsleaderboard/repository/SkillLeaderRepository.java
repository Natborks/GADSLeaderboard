package com.example.gadsleaderboard.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.gadsleaderboard.Network.ApiClient;
import com.example.gadsleaderboard.Network.LeadersInterface;
import com.example.gadsleaderboard.models.SkillLeader;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillLeaderRepository {

    public MutableLiveData<List<SkillLeader>> getSkillLeaders(){

        final MutableLiveData<List<SkillLeader>> skillLeaders = new MutableLiveData<>();

        LeadersInterface leadersInterface = ApiClient.getRetrofitInstance().
                create(LeadersInterface.class);

        Call<List<SkillLeader>> call = leadersInterface.getSkillLeaders();
        call.enqueue(new Callback<List<SkillLeader>>() {
            @Override
            public void onResponse(Call<List<SkillLeader>> call, Response<List<SkillLeader>> response) {
                skillLeaders.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<SkillLeader>> call, Throwable t) {

            }
        });

        return skillLeaders;
    }
}
