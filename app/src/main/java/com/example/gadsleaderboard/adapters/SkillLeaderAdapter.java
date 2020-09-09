package com.example.gadsleaderboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.models.SkillLeader;
import com.example.gadsleaderboard.R;

import java.util.List;

public class SkillLeaderAdapter extends RecyclerView.Adapter<SkillLeaderAdapter.SkillLeaderViewHolder>{
    Context mContext;
    List<SkillLeader> mSkillLeaders;

    public SkillLeaderAdapter(Context context, List<SkillLeader> SkillLeaders) {
        mContext = context;
        mSkillLeaders = SkillLeaders;
    }

    @NonNull
    @Override
    public SkillLeaderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_skill_leader, parent, false);

        return new SkillLeaderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillLeaderViewHolder holder, int position) {
        holder.bind(mSkillLeaders.get(position));
    }

    @Override
    public int getItemCount() {
        return mSkillLeaders.size();
    }

    public void setSkillLeaders(List<SkillLeader> skillLeaders) {
        this.mSkillLeaders = skillLeaders;
        notifyDataSetChanged();
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

        public void bind(SkillLeader learningLeader){
            name.setText(learningLeader.getName());
            country.setText(learningLeader.getCountry());
            String learning = "Skill IQ score " + learningLeader.getScore() + ", ";
            learningHours.setText(learning);
        }
    }
}
