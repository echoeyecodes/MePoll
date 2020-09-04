package com.yata.echonotes.BottomNavigationFragments;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.yata.echonotes.Adapters.ProfileItemsAdapter;
import com.yata.echonotes.Factory.AdapterFactory.ProfileItemAdapterFactory;
import com.yata.echonotes.Factory.AdapterFactoryGenerator;
import com.yata.echonotes.R;
import de.hdodenhof.circleimageview.CircleImageView;
import org.jetbrains.annotations.NotNull;

public class Profile extends Fragment {
private RecyclerView recyclerView;
private ImageView cover_image;
private CircleImageView profile_image;

    public Profile(){

    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.profile_item_recycler_view);
        cover_image = view.findViewById(R.id.profile_cover_image);
        profile_image = view.findViewById(R.id.profile_image);

        Picasso.get().load(Uri.parse("https://res.cloudinary.com/echoeyecodes/image/upload/c_scale,w_500/v1598206091/txntfo2pklnyh77pbbfp.png")).into(cover_image);
        Picasso.get().load(Uri.parse("https://res.cloudinary.com/echoeyecodes/image/upload/v1599228106/serdecgsqbdm6mxvffdc.jpg")).into(profile_image);

        ProfileItemAdapterFactory profileItemAdapterFactory = (ProfileItemAdapterFactory) AdapterFactoryGenerator.getAdapterFactory(AdapterFactoryGenerator.ADAPTER_TYPES.PROFILE_ITEMS);
        assert profileItemAdapterFactory != null;
        ProfileItemsAdapter profileItemsAdapter = profileItemAdapterFactory.profileItemsAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(profileItemsAdapter);

    }

}
