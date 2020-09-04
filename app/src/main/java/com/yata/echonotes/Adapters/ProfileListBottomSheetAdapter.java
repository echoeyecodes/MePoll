package com.yata.echonotes.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.yata.echonotes.Models.NewsModel;
import com.yata.echonotes.R;

import java.util.List;

public class ProfileListBottomSheetAdapter extends ListAdapter<String, ProfileListBottomSheetAdapter.ViewHolder> {

    private List<String> users;

    public ProfileListBottomSheetAdapter(DiffUtil.ItemCallback<String> itemCallback, List<String> users) {
        super(itemCallback);
        this.users = users;
    }


    @NonNull
    @Override
    public ProfileListBottomSheetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(ProfileListBottomSheetAdapter.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    protected static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            // TODO: Customize the item layout
            super(inflater.inflate(R.layout.fragment_profile_list_dialog_list_dialog_item, parent, false));
        }
    }
}
