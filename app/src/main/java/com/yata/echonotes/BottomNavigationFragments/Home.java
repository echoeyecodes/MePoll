package com.yata.echonotes.BottomNavigationFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yata.echonotes.Adapters.FeedAdapter;
import com.yata.echonotes.Factory.AdapterFactory.FeedAdapterFactory;
import com.yata.echonotes.Factory.AdapterFactoryGenerator;
import com.yata.echonotes.ItemDecorations.ColumnItemDecoration;
import com.yata.echonotes.Models.NewsModel;
import com.yata.echonotes.R;
import com.yata.echonotes.utils.IntToDpConverter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Home extends Fragment {
    private FloatingActionButton floatingActionButton;

    public Home(){

    }

private RecyclerView recyclerView;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_now, container, false);
    }


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.feed_recycler_view);
        floatingActionButton = view.findViewById(R.id.home_floating_button);

        FeedAdapterFactory feedAdapterFactory = (FeedAdapterFactory) AdapterFactoryGenerator.getAdapterFactory(AdapterFactoryGenerator.ADAPTER_TYPES.FEED);
        CustomDiffItemUtilCallback customDiffItemUtilCallback = new CustomDiffItemUtilCallback();

        List<String> options1 = new ArrayList<>();
        options1.add("");
        options1.add("");
        options1.add("");

        List<String> options2 = new ArrayList<>();
        options2.add("");
        options2.add("");

        List<String> options3 = new ArrayList<>();
        options3.add("");
        options3.add("");
        options3.add("");
        options3.add("");

        NewsModel newsModel = new NewsModel("12", "", "", "", options1, options2);
        NewsModel newsModel1 = new NewsModel("1", "", "", "", options2, new ArrayList<>());
        NewsModel newsModel2 = new NewsModel("111", "", "", "", options3, options1);
        assert feedAdapterFactory != null;
        FeedAdapter feedAdapter = feedAdapterFactory.feedAdapter(customDiffItemUtilCallback, Arrays.asList(newsModel, newsModel1, newsModel2), getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new ColumnItemDecoration(IntToDpConverter.intToDp(15)));
        recyclerView.setAdapter(feedAdapter);
        floatingActionButton.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.fragment_add_post));

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
