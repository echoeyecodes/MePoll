package com.yata.echonotes.Factory.AdapterFactory;

import android.content.Context;
import androidx.recyclerview.widget.DiffUtil;
import com.yata.echonotes.Adapters.FeedAdapter;
import com.yata.echonotes.Adapters.FeedPollMutualVoterAdapter;
import com.yata.echonotes.Adapters.FeedPollOptionsAdapter;
import com.yata.echonotes.Adapters.ProfileItemsAdapter;
import com.yata.echonotes.Factory.AdapterAbstractFactory;
import com.yata.echonotes.Models.NewsModel;

import java.util.List;

public class ProfileItemAdapterFactory extends AdapterAbstractFactory {
    @Override
    public FeedAdapter feedAdapter(DiffUtil.ItemCallback<NewsModel> itemCallback, List<NewsModel> newsModels, Context context) {
        return null;
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
        return new ProfileItemsAdapter(context);
    }
}
