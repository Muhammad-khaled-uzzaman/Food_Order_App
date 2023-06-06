package com.example.foodorderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.foodorderapp.Adapters.MainAdapter;
import com.example.foodorderapp.Models.MainModel;
import com.example.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.burgertransparent,"Burger","60","Chicken Burger With Extra Cheese"));
        list.add(new MainModel(R.drawable.pizza,"Pizza","221","Prepared With Cheese,Chicken,Onion,Capsicum,Mushroom"));
        list.add(new MainModel(R.drawable.frenchfries,"French Fries","20","Special Potato French Fries"));
        list.add(new MainModel(R.drawable.chickenfry,"Chicken Fry","300","Enjoy 4 pcs Hot and Crispy with 1 Regular Fries"));
        list.add(new MainModel(R.drawable.noodles,"Noodles","128","Special Chicken Noodles"));

        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyclerviewId.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerviewId.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}