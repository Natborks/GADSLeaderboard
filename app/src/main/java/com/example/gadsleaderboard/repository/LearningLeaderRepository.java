package com.example.gadsleaderboard.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.gadsleaderboard.Network.ApiClient;
import com.example.gadsleaderboard.Network.LeadersInterface;
import com.example.gadsleaderboard.models.LearningLeader;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningLeaderRepository {

    public MutableLiveData<List<LearningLeader>> getLearningLeaders(){

        LeadersInterface leadersInterface = ApiClient.getRetrofitInstance().
                create(LeadersInterface.class);

        final MutableLiveData<List<LearningLeader>> listMutableLiveData = new MutableLiveData<>();

        Call<List<LearningLeader>> call = leadersInterface.getLearningLeaders();
        call.enqueue(new Callback<List<LearningLeader>>() {
            @Override
            public void onResponse(Call<List<LearningLeader>> call, Response<List<LearningLeader>> response) {
                listMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<LearningLeader>> call, Throwable t) {

            }
        });

        return listMutableLiveData;
    }
}
