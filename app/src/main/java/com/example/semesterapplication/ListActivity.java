package com.example.semesterapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements TaskAdapter.OnListItemClickListener, NavigationView.OnNavigationItemSelectedListener {

    RecyclerView taskList;
    TaskAdapter taskAdapter;
    ArrayList<Task> dummyTasks;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle =
                new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        taskList = findViewById(R.id.nav_host_fragment);
        taskList.hasFixedSize();
        taskList.setLayoutManager(new LinearLayoutManager(this));

        dummyTasks = new ArrayList<>();
        dummyTasks.add(new Task("nimic1", "nimic2"));
        dummyTasks.add(new Task("nimic11", "nimic2"));
        dummyTasks.add(new Task("nimic111", "nimic2"));
        dummyTasks.add(new Task("nimic1111", "nimic2"));
        dummyTasks.add(new Task("nimic1111", "nimic2"));
        dummyTasks.add(new Task("nimic11111", "nimic2"));
        dummyTasks.add(new Task("nimic111111", "nimic2"));
        dummyTasks.add(new Task("nimic1111111", "nimic2"));
        dummyTasks.add(new Task("nimic11111111", "nimic2"));


        taskAdapter = new TaskAdapter(dummyTasks, this);
        taskList.setAdapter(taskAdapter);

    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        //TODO
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
//              //  taskAdapter.getFilter().filter(newText);
//                return true;
//            }
//        });
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.settings:
                //TODO: change fragment to settings menu
                return true;
            case R.id.editProfile:
                //TODO: change fragment to edit profile menu
                return true;
            case R.id.contactPhone:
                //TODO: make intent to use phone call app
                return true;
            case R.id.contactEmail:
                //TODO: make intent to use phone email app
                return true;
            case R.id.contactMessage:
                //TODO: make intent to use phone message app
                return true;
            default:
                return false;
        }


        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_container); // not sure about the id
        //return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
    }

    private void setBottomNavigationVisibility() {
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                switch (destination.getId()) {
                    default:
                        bottomNavigationView.setVisibility(View.GONE);
                        break;
                    case R.id.bottom_nav:
                        bottomNavigationView.setVisibility(View.VISIBLE);
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

}


