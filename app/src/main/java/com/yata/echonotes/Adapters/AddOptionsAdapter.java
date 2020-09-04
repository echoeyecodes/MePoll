package com.yata.echonotes.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputEditText;
import com.yata.echonotes.R;
import org.jetbrains.annotations.NotNull;

public class AddOptionsAdapter extends RecyclerView.Adapter<AddOptionsAdapter.ProfileItemsViewHolder> {

    private Context context;
    private String[] options;

    public AddOptionsAdapter(Context context, String[] options) {
        this.context = context;
        this.options = options;
    }

    @NonNull
    @NotNull
    @Override
    public ProfileItemsViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_add_option_input_text, parent, false);
        return new ProfileItemsViewHolder(view);

    }

    @Override
    public int getItemCount() {
        return options.length;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ProfileItemsViewHolder holder, int position) {

        holder.textInputEditText.setHint("Option " + (position+1));

        if(position == 0 || position == 1){
            holder.delete_btn.setVisibility(View.GONE);
        }

    }

    protected static class ProfileItemsViewHolder extends RecyclerView.ViewHolder{

        private TextInputEditText textInputEditText;
        private ImageButton delete_btn;
        public ProfileItemsViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            textInputEditText = itemView.findViewById(R.id.add_option_input_text);
            delete_btn = itemView.findViewById(R.id.add_option_delete_btn);
        }
    }
}
