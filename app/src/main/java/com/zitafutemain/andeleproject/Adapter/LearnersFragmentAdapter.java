package com.zitafutemain.andeleproject.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zitafutemain.andeleproject.R;
import com.zitafutemain.andeleproject.models.LearningResponse;

public class LearnersFragmentAdapter extends ListAdapter<LearningResponse, LearnersFragmentAdapter.LearnersFragmentViewHolder> {


    public LearnersFragmentAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<LearningResponse> DIFF_CALLBACK = new DiffUtil.ItemCallback<LearningResponse>() {
        @Override
        public boolean areItemsTheSame(@NonNull LearningResponse oldItem, @NonNull LearningResponse newItem) {
            return newItem.getName().equals(newItem.getName());
        }

        @Override
        public boolean areContentsTheSame(@NonNull LearningResponse oldItem, @NonNull LearningResponse newItem) {
            return oldItem.getName().equals(oldItem.getName()) &&
                    newItem.getBadgeUrl().equals(newItem.getBadgeUrl()) &&
                    newItem.getCountry().equals(oldItem.getCountry());
        }
    };


    @NonNull
    @Override
    public LearnersFragmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LearnersFragmentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_leader, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LearnersFragmentViewHolder holder, int position) {
        LearningResponse response = getItem(position);
        if (response != null) {
            holder.bind(response);
        }
    }

    static class LearnersFragmentViewHolder extends RecyclerView.ViewHolder {
        TextView userName, description;
        ImageView badgeImage;

        public LearnersFragmentViewHolder(@NonNull View view) {
            super(view);
            userName = view.findViewById(R.id.main_name);
            description = view.findViewById(R.id.description);
            badgeImage=view.findViewById(R.id.badgeImage);
        }

        public void bind(LearningResponse learningResponse) {
            userName.setText(learningResponse.getName());
            description.setText(String.format("%s learning hours, %s", learningResponse.getHours(), learningResponse.getCountry()));
            Glide.with(itemView.getContext()).load(learningResponse.getBadgeUrl()).into(badgeImage);
        }
    }
}
