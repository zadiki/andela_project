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
        import com.zitafutemain.andeleproject.models.IqskillResponse;


public class IqFragmentAdapter extends ListAdapter<IqskillResponse,IqFragmentAdapter.IqSkillFragmentViewHolder> {


    public IqFragmentAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<IqskillResponse> DIFF_CALLBACK = new DiffUtil.ItemCallback<IqskillResponse>() {
        @Override
        public boolean areItemsTheSame(@NonNull IqskillResponse oldItem, @NonNull IqskillResponse newItem) {
            return newItem.getName().equals(newItem.getName());
        }

        @Override
        public boolean areContentsTheSame(@NonNull IqskillResponse oldItem, @NonNull IqskillResponse newItem) {
            return oldItem.getName().equals(oldItem.getName()) &&
                    newItem.getBadgeUrl().equals(newItem.getBadgeUrl()) &&
                    newItem.getCountry().equals(oldItem.getCountry());
        }
    };


    @NonNull
    @Override
    public IqSkillFragmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new IqSkillFragmentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_leader, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull IqSkillFragmentViewHolder holder, int position) {
        IqskillResponse response = getItem(position);
        if (response != null) {
            holder.bind(response);
        }
    }

    class IqSkillFragmentViewHolder extends RecyclerView.ViewHolder{
        TextView userName, description;
        ImageView badgeImage;

        public IqSkillFragmentViewHolder(@NonNull View view) {
            super(view);
            userName = view.findViewById(R.id.main_name);
            description = view.findViewById(R.id.description);
            badgeImage=view.findViewById(R.id.badgeImage);
        }

        public void bind(IqskillResponse iqskillResponse) {
            userName.setText(iqskillResponse.getName());
            description.setText(String.format("%s skill IQ Score, %s", iqskillResponse.getScore(), iqskillResponse.getCountry()));
            Glide.with(itemView.getContext()).load(iqskillResponse.getBadgeUrl()).into(badgeImage);

        }
    }
}

