package com.example.fragments_livedata_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frag_a,new FragmentOne()).commit();
        fragmentManager.beginTransaction().replace(R.id.frag_b,new FragmentTwo()).commit();
    }
}