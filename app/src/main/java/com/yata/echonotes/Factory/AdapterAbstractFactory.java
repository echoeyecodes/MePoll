package com.yata.echonotes.Factory;

import android.content.Context;
import androidx.recyclerview.widget.DiffUtil;
import com.yata.echonotes.Adapters.*;
import com.yata.echonotes.Models.NewsModel;

import java.util.List;

public abstract class AdapterAbstractFactory {

    public abstract FeedAdapter feedAdapter(DiffUtil.ItemCallback<NewsModel> itemCallback, List<NewsModel> newsModels, Context context);
    public abstract FeedPollOptionsAdapter feedMediaAdapter(DiffUtil.ItemCallback<NewsModel> itemCallback, List<String> options);
    public abstract FeedPollMutualVoterAdapter feedPollMutualVoterAdapter(DiffUtil.ItemCallback<NewsModel> itemCallback, List<String> urls);
    public abstract ProfileItemsAdapter profileItemsAdapter(Context context);
    public abstract AddOptionsAdapter addOptionsAdapter(Context context, String[] options);

}
