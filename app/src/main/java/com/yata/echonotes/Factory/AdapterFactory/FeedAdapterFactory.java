package com.yata.echonotes.Factory.AdapterFactory;

import android.content.Context;
import androidx.recyclerview.widget.DiffUtil;
import com.yata.echonotes.Adapters.*;
import com.yata.echonotes.Factory.AdapterAbstractFactory;
import com.yata.echonotes.Models.NewsModel;

import java.util.List;

public class FeedAdapterFactory extends AdapterAbstractFactory {

    @Override
    public FeedAdapter feedAdapter(DiffUtil.ItemCallback<NewsModel> itemCallback, List<NewsModel> newsModels, Context context) {
        return new FeedAdapter(itemCallback, newsModels, context);
    }

    @Override
    public FeedPollOptionsAdapter feedMediaAdapter(DiffUtil.ItemCallback<NewsModel> itemCallback, List<String> options) {
        return null;
    }

    @Override
    public FeedPollMutualVoterAdapter feedPollMutualVoterAdapter(DiffUtil.ItemCallback<NewsModel> itemCallback, List<String> urls) {
        return null;
    }

    @Override
    public ProfileItemsAdapter profileItemsAdapter(Context context) {
        return null;
    }

    @Override
    public AddOptionsAdapter addOptionsAdapter(Context context, String[] options) {
        return null;
    }
}
