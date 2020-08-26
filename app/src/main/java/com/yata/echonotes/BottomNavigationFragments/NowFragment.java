package com.yata.echonotes.BottomNavigationFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yata.echonotes.Adapters.NoteAdapter;
import com.yata.echonotes.Factory.AdapterFactory.NoteAdapterFactory;
import com.yata.echonotes.Factory.AdapterFactoryGenerator;
import com.yata.echonotes.Factory.NoteAdapterTypes;
import com.yata.echonotes.ItemDecorations.TwoGridItemDecoration;
import com.yata.echonotes.Models.NoteModel;
import com.yata.echonotes.R;
import com.yata.echonotes.utils.IntToDpConverter;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class NowFragment extends Fragment {
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

        recyclerView = view.findViewById(R.id.fragment_now_recycler_view);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.addItemDecoration(new TwoGridItemDecoration(IntToDpConverter.intToDp(10)));

        NoteAdapterFactory noteAdapterFactory = (NoteAdapterFactory) AdapterFactoryGenerator.getAdapterFactory(NoteAdapterTypes.NOTE);
        NoteItemCallback noteItemCallback = new NoteItemCallback();

        NoteModel noteModel = new NoteModel("The beginning of the end", getResources().getString(R.string.note_content), null, "12345");
        NoteModel noteModel1 = new NoteModel("2020 Goals", getResources().getString(R.string.note_content), null, "12345");
        NoteModel noteModel2 = new NoteModel("The subtle art", getResources().getString(R.string.note_content), null, "12345");
        NoteModel noteModel3 = new NoteModel("The beginning of the end", getResources().getString(R.string.note_content), null, "12345");
        NoteModel noteModel4 = new NoteModel("2020 Goals", getResources().getString(R.string.note_content), null, "12345");
        NoteModel noteModel5 = new NoteModel("The subtle art", getResources().getString(R.string.note_content), null, "12345");

        assert noteAdapterFactory != null;
        NoteAdapter noteAdapter = noteAdapterFactory.getNoteAdapter(noteItemCallback, Arrays.asList(noteModel, noteModel1, noteModel2, noteModel3, noteModel4, noteModel5));
        recyclerView.setAdapter(noteAdapter);
        noteAdapter.notifyDataSetChanged();
    }

    private static class NoteItemCallback extends DiffUtil.ItemCallback<NoteModel>{

        @Override
        public boolean areItemsTheSame(@NonNull @NotNull NoteModel oldItem, @NonNull @NotNull NoteModel newItem) {
            return newItem.getId().equals(oldItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull @NotNull NoteModel oldItem, @NonNull @NotNull NoteModel newItem) {
            return newItem.getContent().equals(oldItem.getContent());
        }
    }

}
