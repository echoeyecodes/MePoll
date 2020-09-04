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

public class FeedPollOptionsAdapter extends ListAdapter<NewsModel, FeedPollOptionsAdapter.FeedMediaViewHolder> {

    private List<String> options;
    public FeedPollOptionsAdapter(@NonNull @NotNull DiffUtil.ItemCallback<NewsModel> diffCallback, List<String> options) {
        super(diffCallback);
        this.options = options;
    }

    @NonNull
    @NotNull
    @Override
    public FeedMediaViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_poll_button, parent, false);
        return new FeedMediaViewHolder(view);

    }

    @Override
    public int getItemCount() {
        return options.size();
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
