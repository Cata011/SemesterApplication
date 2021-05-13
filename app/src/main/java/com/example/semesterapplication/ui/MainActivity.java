package com.example.semesterapplication.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.semesterapplication.R;
import com.example.semesterapplication.model.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    NavController navController;
    AppBarConfiguration appBarConfiguration;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_drawer);
        bottomNavigationView = findViewById(R.id.bottom_nav_view);
        toolbar = findViewById(R.id.toolbar);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        setSupportActionBar(toolbar);

        //used for displaying the drawer icon
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.tasksFragment,
                R.id.createTask)
                .setOpenableLayout(drawerLayout)
                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        NavigationUI.setupWithNavController(navigationView, navController);

        //((TasksFragment) getSupportFragmentManager().findFragmentById(R.id.tasksFragment)).optionSelected();

    }


    //used for accessing the drawer with the icon not just slide
    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }

    //used for displaying the search icon
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.share) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL, "");
            intent.putExtra(Intent.EXTRA_SUBJECT, "");
            intent.putExtra(Intent.EXTRA_TEXT, ((TasksFragment) getSupportFragmentManager().findFragmentById(R.id.tasksFragment)).dummyTasks);

            startActivity(Intent.createChooser(intent, String.valueOf(R.string.emailIntent)));
            return true;
        }
        else {
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
            return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
        }
    }
}