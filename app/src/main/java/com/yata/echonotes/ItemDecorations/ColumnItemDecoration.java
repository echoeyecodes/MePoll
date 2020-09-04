package com.yata.echonotes.ItemDecorations;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

public class ColumnItemDecoration extends RecyclerView.ItemDecoration{
    private int spacing;

    private int top;
    private int left;
    private int bottom;
    private int right;

    public ColumnItemDecoration(int spacing){
        this.left = spacing;
        this.right = spacing;
        this.bottom = spacing;
        this.top = spacing;
    }

    public ColumnItemDecoration(int top, int right, int left, int bottom){
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }

    public ColumnItemDecoration(int vertical, int horizontal){
        this.top = vertical;
        this.bottom = vertical;
        this.left = horizontal;
        this.right = horizontal;
    }

    @Override
    public void getItemOffsets(@NonNull @NotNull Rect outRect, @NonNull @NotNull View view, @NonNull @NotNull RecyclerView parent, @NonNull @NotNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.top = top;
        outRect.bottom = bottom;
        outRect.left = left;
        outRect.right = right;
    }
}
