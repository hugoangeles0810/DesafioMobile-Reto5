package io.github.hugoangeles0810.desafiomobile_reto5;

import android.os.Bundle;
import android.support.annotation.Nullable;

import io.github.hugoangeles0810.navigationdraweractivity.NavDrawerActivityResources;
import io.github.hugoangeles0810.navigationdraweractivity.NavigationDrawerActivity;

@NavDrawerActivityResources(
        navigationMenu = R.menu.activity_main_drawer,
        navigationHeaderLayout = R.layout.nav_header_main,
        arrayOfMenuItemIds = R.array.menu_items_ids,
        arrayOfActivityClasses = R.array.menu_items_activities,
        currentMenuItemId = R.id.nav_third)
public class ThirdActivity extends NavigationDrawerActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        getSupportActionBar().setTitle("Third Activity");
    }
}
