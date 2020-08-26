package com.yata.echonotes.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textview.MaterialTextView;
import com.yata.echonotes.Models.NoteModel;
import com.yata.echonotes.R;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NoteAdapter extends ListAdapter<NoteModel, NoteAdapter.NoteViewHolder> {

    private final List<NoteModel> noteModels;

    public NoteAdapter(@NonNull @NotNull DiffUtil.ItemCallback<NoteModel> diffCallback, List<NoteModel> noteModels) {
        super(diffCallback);
        this.noteModels =noteModels;
    }


    @NonNull
    @NotNull
    @Override
    public NoteAdapter.NoteViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_note_item, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NoteAdapter.NoteViewHolder holder, int position) {

        holder.note_title.setText(noteModels.get(position).getTitle());
        holder.note_content.setText(noteModels.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return noteModels.size();
    }

    protected static class NoteViewHolder extends RecyclerView.ViewHolder{
    private MaterialTextView note_title;
    private MaterialTextView note_content;

        public NoteViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            note_title = itemView.findViewById(R.id.note_title_item);
            note_content = itemView.findViewById(R.id.note_content_item);

        }
    }
}
