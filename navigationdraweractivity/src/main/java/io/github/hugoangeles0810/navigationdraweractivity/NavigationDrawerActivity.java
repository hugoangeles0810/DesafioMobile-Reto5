package io.github.hugoangeles0810.navigationdraweractivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Map;

public abstract class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final int NO_NAVIGATION_HEADER_LAYOUT = -1;

    private DrawerLayout drawer;
    private Toolbar toolbar;
    private Map<Integer, String> mapMenuItemToActivity;
    private Intent pendingAction;
    private NavigationView navigationView;
    private NavDrawerActivityResources navDrawerRes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        loadAnnotatedResources();
        setupMenuItemsWithActivities();
        initUI();
    }

    protected void setupMenuItemsWithActivities() {
        mapMenuItemToActivity = new HashMap<>();

        TypedArray menuItemsTypedArray = getResources().obtainTypedArray(navDrawerRes.arrayOfMenuItemIds());
        TypedArray activityClassesTypedArray = getResources().obtainTypedArray(navDrawerRes.arrayOfActivityClasses());

        if (menuItemsTypedArray.length() != activityClassesTypedArray.length()) {
            throw new IllegalStateException(
                    "menuItems and activityClasses must have the same length");
        }

        int len = menuItemsTypedArray.length();

        for (int i = 0; i < len; i++) {
            mapMenuItemToActivity.put(menuItemsTypedArray.getResourceId(i, -1),
                    activityClassesTypedArray.getString(i));
        }

        menuItemsTypedArray.recycle();
        activityClassesTypedArray.recycle();
    }

    private void initUI() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // TODO: Improve this
                if (pendingAction != null) {
                    startActivity(pendingAction);
                    finish();
                }
            }
        };

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.inflateMenu(navDrawerRes.navigationMenu());
        if (navDrawerRes.navigationHeaderLayout() != NO_NAVIGATION_HEADER_LAYOUT) {
            navigationView.addHeaderView(getLayoutInflater().inflate(navDrawerRes.navigationHeaderLayout(), null));
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        navigationView.setCheckedItem(navDrawerRes.currentMenuItemId());
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (mapMenuItemToActivity.containsKey(id)) {
            pendingAction = new Intent();
            pendingAction.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            pendingAction.setClassName(this, mapMenuItemToActivity.get(id));
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        if (layoutResID == R.layout.activity_navigation_drawer) {
            super.setContentView(layoutResID);
        } else {
            ViewGroup contentView = (ViewGroup) findViewById(R.id.content_view);
            getLayoutInflater().inflate(layoutResID, contentView, true);
        }
    }

    private void loadAnnotatedResources() {
        navDrawerRes = getClass().getAnnotation(NavDrawerActivityResources.class);
        if (navDrawerRes == null) {
            throw new IllegalStateException(
                    "NavigationDrawerActivity must annotate have annotation @NavDrawerActivityResources");
        }
    }
}
