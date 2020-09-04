package com.yata.echonotes.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.yata.echonotes.Models.NewsModel;
import com.yata.echonotes.R;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FeedPollMutualVoterAdapter extends ListAdapter<NewsModel, FeedPollMutualVoterAdapter.FeedMediaViewHolder> {

    private List<String> urls;
    public FeedPollMutualVoterAdapter(@NonNull @NotNull DiffUtil.ItemCallback<NewsModel> diffCallback, List<String> urls) {
        super(diffCallback);
        this.urls = urls;
    }

    @NonNull
    @NotNull
    @Override
    public FeedMediaViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_mutal_voters, parent, false);
        return new FeedMediaViewHolder(view);

    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FeedMediaViewHolder holder, int position) {

    }

    protected static class FeedMediaViewHolder extends RecyclerView.ViewHolder{

        public FeedMediaViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }
}
