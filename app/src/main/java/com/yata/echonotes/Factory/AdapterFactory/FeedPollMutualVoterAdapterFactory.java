package com.yata.echonotes.Factory.AdapterFactory;

import android.content.Context;
import androidx.recyclerview.widget.DiffUtil;
import com.yata.echonotes.Adapters.*;
import com.yata.echonotes.Factory.AdapterAbstractFactory;
import com.yata.echonotes.Interfaces.MutualsContainerClicked;
import com.yata.echonotes.Models.NewsModel;

import java.util.List;

public class FeedPollMutualVoterAdapterFactory extends AdapterAbstractFactory {
    @Override
    public FeedAdapter feedAdapter(DiffUtil.ItemCallback<NewsModel> itemCallback, List<NewsModel> newsModels, Context context, MutualsContainerClicked mutualsContainerClicked) {
        return null;
    }

    @Override
    public FeedPollOptionsAdapter feedMediaAdapter(DiffUtil.ItemCallback<NewsModel> itemCallback, List<String> options) {
        return null;
    }

    @Override
    public FeedPollMutualVoterAdapter feedPollMutualVoterAdapter(DiffUtil.ItemCallback<NewsModel> itemCallback, List<String> urls) {
        return new FeedPollMutualVoterAdapter(itemCallback, urls);
    }

    @Override
    public ProfileItemsAdapter profileItemsAdapter(Context context) {
        return null;
    }

    @Override
    public AddOptionsAdapter addOptionsAdapter(Context context, String[] options) {
        return null;
    }

    @Override
    public ProfileListBottomSheetAdapter profileListBottomSheetAdapter(DiffUtil.ItemCallback<String> itemCallback, List<String> urls) {
        return null;
    }
}
