package com.yata.echonotes.BottomSheets;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.yata.echonotes.Adapters.ProfileListBottomSheetAdapter;
import com.yata.echonotes.Factory.AdapterAbstractFactory;
import com.yata.echonotes.Factory.AdapterFactory.ProfileListBottomSheetAdapterFactory;
import com.yata.echonotes.Factory.AdapterFactoryGenerator;
import com.yata.echonotes.Models.NewsModel;
import com.yata.echonotes.R;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class ProfileListDialogFragment extends BottomSheetDialogFragment {

    // TODO: Customize parameters
    public static ProfileListDialogFragment newInstance() {
        return new ProfileListDialogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile_list_dialog_list_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final RecyclerView recyclerView = view.findViewById(R.id.profile_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ProfileListBottomSheetAdapterFactory profileListBottomSheetAdapterFactory = (ProfileListBottomSheetAdapterFactory) AdapterFactoryGenerator.getAdapterFactory(AdapterFactoryGenerator.ADAPTER_TYPES.PROFILE_LIST);
        assert profileListBottomSheetAdapterFactory != null;
        String[] names ={"", "", ""};
        ProfileListBottomSheetAdapter bottomSheetAdapter = profileListBottomSheetAdapterFactory.profileListBottomSheetAdapter(new CustomDiffItemUtilCallback(), Arrays.asList(names));
        recyclerView.setAdapter(bottomSheetAdapter);
    }

    private static class CustomDiffItemUtilCallback extends DiffUtil.ItemCallback<String>{

        @Override
        public boolean areItemsTheSame(@NonNull @NotNull String oldItem, @NonNull @NotNull String newItem) {
            return newItem.equals(oldItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull @NotNull String oldItem, @NonNull @NotNull String newItem) {
            return newItem.equals(oldItem);
        }
    }


}