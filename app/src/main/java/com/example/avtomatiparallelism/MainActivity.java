package com.example.avtomatiparallelism;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.PrecomputedText;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import javax.xml.transform.Result;

import static java.lang.Math.random;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;
    private Button Button1full;
    private Button Button2full;
    private Button Button3full;
    private Button Button4full;
    private Button Button1small;
    private Button Button2small;
    private Button Button3small;
    private Button Button4small;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Avtomat[] avtomats = new Avtomat[4];
        avtomats[0] = new Avtomat("1");
        avtomats[1] = new Avtomat("2");
        avtomats[2] = new Avtomat("3");
        avtomats[3] = new Avtomat("4");
        for (int i = 0; i < 4; i++) {
            avtomats[i].AddProduct("Snikers", 35, 5 + (int) (Math.random() * 25));
            avtomats[i].AddProduct("Mars", 25, 5 + (int) (Math.random() * 25));
            avtomats[i].AddProduct("Bounty", 15, 5 + (int) (Math.random() * 25));
            avtomats[i].AddProduct("Pepsi", 40, 5 + (int) (Math.random() * 25));
            avtomats[i].AddProduct("7up", 30, 5 + (int) (Math.random() * 25));
            avtomats[i].AddProduct("Water", 20, 5 + (int) (Math.random() * 25));
        }
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment1=new Fragment1(avtomats);
        fragment2=new Fragment2(avtomats);
        fragment3=new Fragment3(avtomats);
        fragment4=new Fragment4(avtomats);
        fragmentTransaction.add(R.id.table1,fragment1);
        fragmentTransaction.add(R.id.table2,fragment2);
        fragmentTransaction.add(R.id.table3,fragment3);
        fragmentTransaction.add(R.id.table4,fragment4);
        fragmentTransaction.commit();
        for (int i = 0; i < 20; i++) {
            avtomats[(int) (Math.random() * 4)].persons[i] = i;
        }
    };
}