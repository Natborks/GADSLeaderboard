package com.example.gadsleaderboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.models.LearningLeader;
import com.example.gadsleaderboard.R;

import java.util.List;

public class LearningLeaderAdapter
        extends RecyclerView.Adapter<LearningLeaderAdapter.learningLeaderViewHodler>{
    Context mContext;
    List<LearningLeader> mLearningLeaders;

    public LearningLeaderAdapter(Context context, List<LearningLeader> learningLeaders) {
        mContext = context;
        mLearningLeaders = learningLeaders;
    }

    @NonNull
    @Override
    public learningLeaderViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_learning_leader, parent, false);

        return new learningLeaderViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull learningLeaderViewHodler holder, int position) {
        holder.bind(mLearningLeaders.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class learningLeaderViewHodler extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView country;
        private TextView learningHours;

        public learningLeaderViewHodler(@NonNull View itemView) {
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
