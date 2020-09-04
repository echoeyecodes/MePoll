package com.yata.echonotes.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.yata.echonotes.Models.NewsModel;
import com.yata.echonotes.R;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProfileItemsAdapter extends RecyclerView.Adapter<ProfileItemsAdapter.ProfileItemsViewHolder> {

    private Context context;

    public ProfileItemsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ProfileItemsViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_profile_info_item, parent, false);
        return new ProfileItemsViewHolder(view);

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ProfileItemsViewHolder holder, int position) {

        switch (position){
            case  0:
                holder.textView.setText("Lives in Ogun Nigeria");
                holder.textView.setCompoundDrawables(context.getDrawable(R.drawable.ic_baseline_home_24), null, null, null);
                break;
            case  1:
                holder.textView.setText("Currently Single");
                holder.textView.setCompoundDrawables(context.getDrawable(R.drawable.ic_baseline_favorite_24), null, null, null);
                break;
            case  2:
                holder.textView.setText("Followed by 4 people");
                holder.textView.setCompoundDrawables(context.getDrawable(R.drawable.ic_person_outline_24px), null, null, null);
                break;
        }

    }

    protected static class ProfileItemsViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        public ProfileItemsViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.profile_info_item_text);
        }
    }
}
