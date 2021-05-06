package com.example.semesterapplication.old;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.semesterapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    NavController navController;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;
    BottomNavigationView bottomOptionsView;
    Toolbar toolbar;
    AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
        setUpNavigation();

//        drawerLayout = findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle drawerToggle =
//                new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
//        drawerLayout.addDrawerListener(drawerToggle);
//        drawerToggle.syncState();
        //navigationView.setNavigationItemSelectedListener(this);

    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomOptionsView = findViewById(R.id.bottom_options_tasks);
    }

    private void setUpNavigation() {
        navController = Navigation.findNavController(this, R.id.navigation);
        setSupportActionBar(toolbar);

        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.family,
                R.id.friends,
                R.id.work,
                R.id.custom,
                R.id.own
        ).setOpenableLayout(drawerLayout).build();

        NavigationUI.setupActionBarWithNavController(this, navController);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        NavigationUI.setupWithNavController(navigationView, navController);
        setBottomNavigationVisibility();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list_toolbar_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search_filter);
//        SearchView searchView = (SearchView) menuItem.getActionView(); TODO: this is broken, why?
//        searchView.setQueryHint("Search task...");
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//              //  contentAdapter.getFilter().filter(newText);
//                return true;
//            }
//        });
        return true;
    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.settings:
//                //TODO: change fragment to settings menu
//                return true;
//            case R.id.editProfile:
//                //TODO: change fragment to edit profile menu
//                return true;
//            case R.id.contactPhone:
//                //TODO: make intent to use phone call app
//                return true;
//            case R.id.contactEmail:
//                //TODO: make intent to use phone email app
//                return true;
//            case R.id.contactMessage:
//                //TODO: make intent to use phone message app
//                return true;
//            default:
//                return false;
//        }
//    }

    private void setBottomNavigationVisibility() {
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                switch (destination.getId()) {
                    default:
                        bottomNavigationView.setVisibility(View.GONE);
                        bottomOptionsView.setVisibility(View.GONE);
                        break;
                    case R.id.family:
                    case R.id.friends:
                    case R.id.work:
                    case R.id.custom:
                        bottomOptionsView.setVisibility(View.GONE);
                        bottomOptionsView.setVisibility(View.VISIBLE);
                        break;
                    case R.id.own:
                        bottomNavigationView.setVisibility(View.VISIBLE);
                        bottomOptionsView.setVisibility(View.VISIBLE);
                        break; //TODO: remember this
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
    }
}


