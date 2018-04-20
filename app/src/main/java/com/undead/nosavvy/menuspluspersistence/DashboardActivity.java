package com.undead.nosavvy.menuspluspersistence;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.undead.nosavvy.menuspluspersistence.adapters.ItemAdapter;
import com.undead.nosavvy.menuspluspersistence.models.Item;
import com.undead.nosavvy.menuspluspersistence.repositories.ItemRepository;

import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private static final int REGISTER_ITEM_FORM_REQUEST = 200;

    private RecyclerView itemsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        final BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        //showInicioFragment();
                        break;
                    case R.id.menu_favorite:
                        //showCameraFragment();
                        break;
                    case R.id.menu_new:
                        startActivityForResult(new Intent(DashboardActivity.this,RegisterItemActivity.class), REGISTER_ITEM_FORM_REQUEST);
                        break;
                    case R.id.menu_archive:
                        break;
                }
                return true;
            }
        });

        itemsList = (RecyclerView) findViewById(R.id.item_list);
        itemsList.setLayoutManager(new LinearLayoutManager(this));

        List<Item> items= ItemRepository.list();
        itemsList.setAdapter(new ItemAdapter(items));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // refresh data
        ItemAdapter adapter = (ItemAdapter) itemsList.getAdapter();

        List<Item> items = ItemRepository.list();
        adapter.setItems(items);
        adapter.notifyDataSetChanged();

    }



}
