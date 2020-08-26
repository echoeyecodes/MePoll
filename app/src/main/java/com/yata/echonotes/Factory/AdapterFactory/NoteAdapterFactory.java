package com.yata.echonotes.Factory.AdapterFactory;

import androidx.recyclerview.widget.DiffUtil;
import com.yata.echonotes.Adapters.NoteAdapter;
import com.yata.echonotes.Factory.AdapterAbstractFactory;
import com.yata.echonotes.Models.NoteModel;

import java.util.List;

public class NoteAdapterFactory extends AdapterAbstractFactory {

    @Override
    public NoteAdapter getNoteAdapter(DiffUtil.ItemCallback<NoteModel> noteModelItemCallback, List<NoteModel> noteModels) {
        return new NoteAdapter(noteModelItemCallback, noteModels);
    }

}
