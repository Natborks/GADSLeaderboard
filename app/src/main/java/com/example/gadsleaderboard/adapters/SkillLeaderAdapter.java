package com.example.gadsleaderboard.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.Models.LearningLeader;
import com.example.gadsleaderboard.R;

public class SkillLeaderAdapter extends RecyclerView.Adapter<SkillLeaderAdapter.SkillLeaderViewHolder>{

    @NonNull
    @Override
    public SkillLeaderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SkillLeaderViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class SkillLeaderViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView country;
        private TextView learningHours;

        public SkillLeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            country = itemView.findViewById(R.id.country);
            learningHours = itemView.findViewById(R.id.learning_hours);
        }

        public void bind(LearningLeader learningLeader){
            name.setText(learningLeader.getName());
            country.setText(learningLeader.getCountry());
            learningHours.setText(learningLeader.getNumberOfLearningHours());
        }
    }
}
