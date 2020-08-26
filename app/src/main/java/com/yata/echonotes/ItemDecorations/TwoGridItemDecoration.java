package com.yata.echonotes.ItemDecorations;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

public class TwoGridItemDecoration extends RecyclerView.ItemDecoration{
    private int spacing;

    public TwoGridItemDecoration(int spacing){
        this.spacing = spacing;
    }

    @Override
    public void getItemOffsets(@NonNull @NotNull Rect outRect, @NonNull @NotNull View view, @NonNull @NotNull RecyclerView parent, @NonNull @NotNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = spacing;
        outRect.right= spacing;
        outRect.top = spacing;
        outRect.bottom = spacing;
    }
}
