package com.yata.echonotes.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.*;
import com.yata.echonotes.BottomSheets.ProfileListDialogFragment;
import com.yata.echonotes.Factory.AdapterFactory.FeedPollAdapterFactory;
import com.yata.echonotes.Factory.AdapterFactory.FeedPollMutualVoterAdapterFactory;
import com.yata.echonotes.Factory.AdapterFactoryGenerator;
import com.yata.echonotes.Interfaces.MutualsContainerClicked;
import com.yata.echonotes.ItemDecorations.ColumnItemDecoration;
import com.yata.echonotes.Models.NewsModel;
import com.yata.echonotes.R;
import com.yata.echonotes.utils.IntToDpConverter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FeedAdapter extends ListAdapter<NewsModel, FeedAdapter.FeedViewHolder> {
    private List<NewsModel> newsModels;
    private Context context;
    private MutualsContainerClicked mutualsContainerClicked;

    public FeedAdapter(@NonNull @NotNull DiffUtil.ItemCallback<NewsModel> diffCallback, List<NewsModel> newsModels, Context context, MutualsContainerClicked mutualsContainerClicked) {
        super(diffCallback);
        this.newsModels = newsModels;
        this.context = context;
        this.mutualsContainerClicked = mutualsContainerClicked;
    }

    @NonNull
    @NotNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_feed_item, parent, false);
        return new FeedViewHolder(view);

    }

    @Override
    public int getItemCount() {
        return newsModels.size();
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FeedViewHolder holder, int position) {

        holder.recyclerView.addItemDecoration(new ColumnItemDecoration(IntToDpConverter.intToDp(10), IntToDpConverter.intToDp(5)));
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

        FeedPollAdapterFactory feedPollAdapterFactory = (FeedPollAdapterFactory) AdapterFactoryGenerator.getAdapterFactory(AdapterFactoryGenerator.ADAPTER_TYPES.FEED_POLL);
        assert feedPollAdapterFactory != null;
        FeedPollOptionsAdapter adapter = feedPollAdapterFactory.feedMediaAdapter(new CustomDiffItemUtilCallback(), newsModels.get(position).getOptions());

        FeedPollMutualVoterAdapterFactory feedPollMutualVoterAdapterFactory = (FeedPollMutualVoterAdapterFactory) AdapterFactoryGenerator.getAdapterFactory(AdapterFactoryGenerator.ADAPTER_TYPES.POLL_MUTUAL);
        assert feedPollMutualVoterAdapterFactory != null;

        List<String> mutuals = newsModels.get(position).getMutal_voters();
        if(mutuals.size() ==0 ){
            holder.mutuals_recycler_view.setVisibility(View.GONE);
            holder.mutuals_recycler_view_text.setVisibility(View.GONE);
        }else{
            FeedPollMutualVoterAdapter feedPollMutualVoterAdapter = feedPollMutualVoterAdapterFactory.feedPollMutualVoterAdapter(new CustomDiffItemUtilCallback(), newsModels.get(position).getMutal_voters());
            holder.mutuals_recycler_view.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            holder.mutuals_recycler_view.setAdapter(feedPollMutualVoterAdapter);
        }

        holder.recyclerView.setAdapter(adapter);

        holder.mutual_voters_container.setOnClickListener(v ->{
            mutualsContainerClicked.onMutualsContainerClicked();
        });

    }

    protected static class FeedViewHolder extends RecyclerView.ViewHolder{
        private final RecyclerView recyclerView;
        private final RecyclerView mutuals_recycler_view;
        private final TextView mutuals_recycler_view_text;
        private final LinearLayout mutual_voters_container;

        public FeedViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            recyclerView = itemView.findViewById(R.id.poll_options_recycler_view);
            mutuals_recycler_view = itemView.findViewById(R.id.mutual_voters_recycler_view);
            mutuals_recycler_view_text = itemView.findViewById(R.id.mutual_voters_recycler_view_text);
            mutual_voters_container = itemView.findViewById(R.id.mutual_voters_container);
        }
    }

    private static class CustomDiffItemUtilCallback extends DiffUtil.ItemCallback<NewsModel>{

        @Override
        public boolean areItemsTheSame(@NonNull @NotNull NewsModel oldItem, @NonNull @NotNull NewsModel newItem) {
            return newItem.getTitle().equals(oldItem.getTitle());
        }

        @Override
        public boolean areContentsTheSame(@NonNull @NotNull NewsModel oldItem, @NonNull @NotNull NewsModel newItem) {
            return newItem.getDescription().equals(oldItem.getDescription());
        }
    }
}
