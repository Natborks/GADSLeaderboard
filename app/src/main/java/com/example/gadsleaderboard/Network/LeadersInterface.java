package com.example.gadsleaderboard.Network;

import com.example.gadsleaderboard.models.LearningLeader;
import com.example.gadsleaderboard.models.SkillLeader;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LeadersInterface {
    @GET("/api/hours")
    Call<List<LearningLeader>> getLearningLeaders();

    @GET("/api/skilliq")
    Call<List<SkillLeader>> getSkillLeaders();
}
