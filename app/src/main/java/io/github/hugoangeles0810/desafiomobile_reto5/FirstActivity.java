package io.github.hugoangeles0810.desafiomobile_reto5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.github.hugoangeles0810.navigationdraweractivity.NavDrawerActivityResources;
import io.github.hugoangeles0810.navigationdraweractivity.NavigationDrawerActivity;

@NavDrawerActivityResources(
        navigationMenu = R.menu.activity_main_drawer,
        navigationHeaderLayout = R.layout.nav_header_main,
        arrayOfMenuItemIds = R.array.menu_items_ids,
        arrayOfActivityClasses = R.array.menu_items_activities,
        currentMenuItemId = R.id.nav_first)
public class FirstActivity extends NavigationDrawerActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        getSupportActionBar().setTitle("First Activity");

        Button dummyBtn = (Button) findViewById(R.id.dummy_btn1);
        if (dummyBtn != null) {
            dummyBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Click!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
