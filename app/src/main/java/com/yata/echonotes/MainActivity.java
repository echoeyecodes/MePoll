package com.yata.echonotes;

import android.animation.Animator;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavController.OnDestinationChangedListener, BottomNavigationView.OnNavigationItemSelectedListener, Animation.AnimationListener {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private boolean isHidden = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        navController.addOnDestinationChangedListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public void onDestinationChanged(@NonNull @NotNull NavController controller, @NonNull @NotNull NavDestination destination, @Nullable @org.jetbrains.annotations.Nullable Bundle arguments) {
        int id = destination.getId();

        if ( id == R.id.fragment_add_post) {
            launchAnimation(R.anim.slide_down);
        } else {
            if(bottomNavigationView.getVisibility() != View.VISIBLE){
                launchAnimation(R.anim.slide_up);
            }
        }

    }

    private void handleBottomNavigationSelection(int position){
        bottomNavigationView.getMenu().getItem(position).setChecked(true);
    }

    private void launchAnimation(int anim){
        Animation animation = AnimationUtils.loadAnimation(this, anim);
        animation.setAnimationListener(this);
        bottomNavigationView.startAnimation(animation);
    }

    private void disableStatusbar() {
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    private void enableStatusbar() {
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        int currentId = Objects.requireNonNull(navController.getCurrentDestination()).getId();
        switch (item.getItemId()) {
            case R.id.action_home:
                if (currentId != R.id.fragment_now) {
                    navController.navigate(R.id.fragment_now);
                }
                return true;

            case R.id.action_profile:
                if (currentId != R.id.fragment_profile) {
                    navController.navigate(R.id.fragment_profile);
                }
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        int id = navController.getCurrentDestination().getId();
        switch (id){
            case R.id.fragment_now:
                handleBottomNavigationSelection(0);
                break;

            case R.id.fragment_profile:
                handleBottomNavigationSelection(2);
                break;
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if(isHidden){
            bottomNavigationView.setVisibility(View.VISIBLE);
        }else {
            bottomNavigationView.setVisibility(View.GONE);
        }
            this.isHidden = !this.isHidden;
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}