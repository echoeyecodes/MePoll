package com.yata.echonotes.Factory;

import androidx.recyclerview.widget.DiffUtil;
import com.yata.echonotes.Adapters.NoteAdapter;
import com.yata.echonotes.Models.NoteModel;

import java.util.List;

public abstract class AdapterAbstractFactory {

    public abstract NoteAdapter getNoteAdapter(DiffUtil.ItemCallback<NoteModel> noteModelItemCallback, List<NoteModel> noteModels);
}
